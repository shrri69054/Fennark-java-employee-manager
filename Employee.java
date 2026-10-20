public class Employee {
    private final String name;
    private final int id;
    private final String department;

    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Department: " + department;
    }
}
