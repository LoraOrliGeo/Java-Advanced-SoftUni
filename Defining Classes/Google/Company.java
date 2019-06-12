package DefiningClasses.P07_Google;

public class Company {
    private String name;
    private String department;
    private double salary;

    public Company() {
        this.name = "";
        this.department = "";
        this.salary = 0;
    }

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        String output = this.name.equals("") ? "Company:" : String.format("Company:%n%s %s %.2f", this.name, this.department, this.salary);
        return output;
    }
}
