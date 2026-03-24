package CRUD_Operations;

import java.sql.*;
public class ViewEmployees {
    public static void main(String[] args) {
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "IIM2026");
            Statement st=con.createStatement();
            ResultSet rt=st.executeQuery("SELECT * FROM EMPLOYEES");
            System.out.println("---------------------------------");
            System.out.println("Id | Name | Salary |");
            while (rt.next()){
                int id= rt.getInt("Employee_Id");
                String name=rt.getString("Name");
                int salary=rt.getInt("Salary");
                System.out.println(id +"|"+ name+ "|"+ salary+ "|");
            }
            con.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }

    }
}
