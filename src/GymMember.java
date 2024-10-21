import java.time.LocalDate;

public class GymMember extends Person{
    private boolean memberStatus = false;
    private LocalDate lastPayment;

    public GymMember(String SSNumber, String name, LocalDate lastPayment) {
        super(SSNumber, name);
        this.lastPayment = lastPayment;
    }

    public void checkMembershipStatus(){
        if (lastPayment.isAfter(LocalDate.now().minusYears(1))) {
            memberStatus = true;
        }
    }

    public boolean getMemberStatus() {
        return memberStatus;
    }

    public LocalDate getLastPayment() {
        return lastPayment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + getName() + "\n");
        sb.append("SSNumber: " + getSSNumber() + "\n");
        sb.append("Workouts: \n");
        return sb.toString();
    }
}
