class EmployeeRecord {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeRecord(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyManagement {
    public static void main(String[] args) {
        EmployeeRecord e1 = new EmployeeRecord("Alice", 50000);
        EmployeeRecord e2 = new EmployeeRecord("Bob", 60000);
        EmployeeRecord e3 = new EmployeeRecord("Charlie", 55000);

        EmployeeRecord.printCompanyInfo();
    }
}