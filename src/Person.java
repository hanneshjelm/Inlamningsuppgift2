public class Person {
    private String name;
    private String SSNumber;


    public Person(String SSNumber, String name) {
        this.SSNumber = SSNumber;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getSSNumber() {
        return SSNumber;
    }
}
