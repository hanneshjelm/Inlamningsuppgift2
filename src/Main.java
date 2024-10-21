import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
        IO io = new IO();
        List<GymMember> gymMembers = io.readMembersFromFile("src/data_inlamningsuppg2.txt");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Skriv in namn eller personnummer: ");
            String input = scan.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            boolean foundInList = false;
            for (GymMember gymMember : gymMembers) {
                if (gymMember.getName().equalsIgnoreCase(input) || gymMember.getSSNumber().equals(input)) {
                    foundInList = true;
                    gymMember.checkMembershipStatus();
                    if (gymMember.getMemberStatus()) {
                        System.out.println(gymMember.getName() + " is a current member");
                        io.logWorkoutToFile("workout-logs", gymMember);
                        break;
                    } else if (!gymMember.getMemberStatus()) {
                        System.out.println(gymMember.getName() + " is a former member");
                        break;
                    }
                }
            }
            if (!foundInList) {
                System.out.println(input + " is not a member");
            }
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
    }
}