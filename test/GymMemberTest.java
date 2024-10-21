import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class GymMemberTest {

    GymMember oldMember = new GymMember("Bengt Bengtsson", "7503143162", LocalDate.now().minusYears(2));
    GymMember currentMember = new GymMember("David Davidsson", "9904243342", LocalDate.now().minusMonths(6));

    @Test
    public void checkMembershipStatusTest() {
        oldMember.checkMembershipStatus();
        assertFalse(oldMember.getMemberStatus());
        currentMember.checkMembershipStatus();
        assertTrue(currentMember.getMemberStatus());
    }
}
