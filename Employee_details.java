class Employee {
    private int empId;
    private String name;
    private double salary;

    // --- Constructors ---
    public Employee() {
        this(0, "Unknown", 0.0); // chaining
    }

    public Employee(int empId, String name) {
        this(empId, name, 0.0); // chaining
    }

    public Employee(int empId, String name, double salary) {
        setEmpId(empId);
        setName(name);
        setSalary(salary);
    }

    // --- Getters and Setters ---
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        if (empId > 0) {
            this.empId = empId;
        } else {
            System.out.println("Invalid Employee ID! Setting to 0.");
            this.empId = 0;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name! Setting to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary! Setting to 0.0.");
            this.salary = 0.0;
        }
    }

    // --- Method Overloading ---
    public void raiseSalary(double percentage) {
        if (percentage > 0) {
            salary += salary * (percentage / 100);
        } else {
            System.out.println("Invalid percentage! Raise not applied.");
        }
    }

    public void raiseSalary(int amount) {  // overloaded with fixed amount
        if (amount > 0) {
            salary += amount;
        } else {
            System.out.println("Invalid amount! Raise not applied.");
        }
    }

    // --- Display ---
    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

// --- Main Class ---
public class Employee_details {
    public static void main(String[] args) {
        // Using constructor with all fields
        Employee e1 = new Employee(101, "Rudra", 50000);
        System.out.println("Before raise: " + e1);
        e1.raiseSalary(10);  // raise by 10%
        System.out.println("After 10% raise: " + e1);
        e1.raiseSalary(5000); // raise by fixed 5000
        System.out.println("After 5000 raise: " + e1);

        // Using no-arg constructor and setters
        Employee e2 = new Employee();
        e2.setEmpId(102);
        e2.setName("Aman");
        e2.setSalary(40000);
        System.out.println("\nBefore raise: " + e2);
        e2.raiseSalary(15); // raise by 15%
        System.out.println("After 15% raise: " + e2);
        e2.raiseSalary(3000); // raise by fixed 3000
        System.out.println("After 3000 raise: " + e2);
    }
}
//__Output__//
// Before raise: Employee [ID=101, Name=Rudra, Salary=50000.0]
// After 10% raise: Employee [ID=101, Name=Rudra, Salary=55000.0]
// After 5000 raise: Employee [ID=101, Name=Rudra, Salary=60000.0]

// Before raise: Employee [ID=102, Name=Aman, Salary=40000.0]
// After 15% raise: Employee [ID=102, Name=Aman, Salary=46000.0]
// After 3000 raise: Employee [ID=102, Name=Aman, Salary=49000.0]


