import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class IO {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public List<GymMember> readMembersFromFile(String filename) {
        List<GymMember> members = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String SSNumber = data[0];
                String name = data[1].trim();
                LocalDate lastPayment = LocalDate.parse(br.readLine(), formatter);
                members.add(new GymMember(SSNumber, name, lastPayment));

            }
        } catch (IOException e) {
            System.out.println("Något gick fel");
            e.printStackTrace();
        }
        return members;
    }

    public void logWorkoutToFile(String directory, GymMember member) {
        String safeFileName = member.getName().trim().replaceAll(" ", "_");
        String filename = directory + "/" + safeFileName + "-workout-log.txt";
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(filename);
        boolean isNewFile = !file.exists();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            if (isNewFile) {
                bw.write(member.toString());
                bw.write(LocalDate.now().format(formatter));
                bw.newLine();
            }
            else {
                bw.write(LocalDate.now().format(formatter));
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Något gick fel.");
            e.printStackTrace();
        }
    }
}
