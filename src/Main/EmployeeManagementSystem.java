package Main;

import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static Connection con;

    public static void main(String[] args) {

        try {
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "IIM2026"
            );

            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addEmployee(sc);
                        break;
                    case 2:
                        viewEmployees();
                        break;
                    case 3:
                        updateSalary(sc);
                        break;
                    case 4:
                        deleteEmployee(sc);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }

            } while (choice != 5);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // ➕ ADD EMPLOYEE
    public static void addEmployee(Scanner sc) throws Exception {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Department ID: ");
        int dept = sc.nextInt();

        System.out.print("Enter Salary: ");
        int salary = sc.nextInt();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO employees (employee_id, name, email, department_id, salary, hire_date) VALUES (?, ?, ?, ?, ?, SYSDATE)"
        );

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, email);
        ps.setInt(4, dept);
        ps.setInt(5, salary);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee added successfully");
        }
    }

    // 📖 VIEW EMPLOYEES
    public static void viewEmployees() throws Exception {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

        System.out.println("\nID\tName\tSalary");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("employee_id") + "\t" +
                            rs.getString("name") + "\t" +
                            rs.getInt("salary")
            );
        }
    }


    // ✏️ UPDATE SALARY (CALL PROCEDURE)
    public static void updateSalary(Scanner sc) throws Exception {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Salary: ");
        int salary = sc.nextInt();

        CallableStatement cs = con.prepareCall("{call update_salary(?,?)}");

        cs.setInt(1, id);
        cs.setInt(2, salary);

        cs.execute();

        System.out.println("Salary updated successfully (with history)");
    }

    // 🗑️ DELETE EMPLOYEE (WITH CHILD RECORD HANDLING)
    public static void deleteEmployee(Scanner sc) throws Exception {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        // Delete child records first
        PreparedStatement ps1 = con.prepareStatement(
                "DELETE FROM attendance WHERE employee_id = ?");
        ps1.setInt(1, id);
        ps1.executeUpdate();

        PreparedStatement ps2 = con.prepareStatement(
                "DELETE FROM salary_history WHERE employee_id = ?");
        ps2.setInt(1, id);
        ps2.executeUpdate();

        // Delete main employee
        PreparedStatement ps3 = con.prepareStatement(
                "DELETE FROM employees WHERE employee_id = ?");
        ps3.setInt(1, id);

        int rows = ps3.executeUpdate();

        if (rows > 0) {
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Employee not found");
        }
    }
}