import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IOTest {
    IO io = new IO();

    @Test
    public void readMembersFromFileTest() {
        List<GymMember> members = io.readMembersFromFile("src/data_inlamningsuppg2.txt");
        assertTrue(members.size() == 14);

        GymMember gymMember1 = members.get(0);
        assertEquals("7703021234", gymMember1.getSSNumber().trim());
        assertEquals("Alhambra Aromes", gymMember1.getName().trim());
        assertEquals(LocalDate.parse("2024-07-01"), gymMember1.getLastPayment());

        GymMember gymMember2 = members.get(1);
        assertEquals("8204021234", gymMember2.getSSNumber().trim());
        assertEquals("Bear Belle", gymMember2.getName().trim());
        assertEquals(LocalDate.parse("2019-12-02"), gymMember2.getLastPayment());
        assertNotEquals("Alhambra Aromes", gymMember2.getName().trim());
    }

    @Test
    public void logWorkoutToFileTest() throws IOException {
        IO io = new IO();

        GymMember gm = new GymMember("6702144433", "Bob", LocalDate.parse("2024-07-01"));
        io.logWorkoutToFile("workout-logs", gm);

        GymMember gm2 = new GymMember("7704116463", "Rob", LocalDate.parse("2024-09-01"));
        io.logWorkoutToFile("workout-logs", gm2);

        List<String> lines = Files.readAllLines(Path.of("workout-logs/Bob-workout-log.txt"));
        assertEquals(4, lines.size());

        String temp = lines.get(0);
        assertTrue(temp.equals("Name: Bob"));
        temp = lines.get(1);
        assertTrue(temp.equals("SSNumber: 6702144433"));
    }
}
