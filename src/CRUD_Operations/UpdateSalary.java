package CRUD_Operations;

import java.sql.*;
public class UpdateSalary {
    public static void main(String[] args) {
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "username",
                    "password");
            CallableStatement cs= con.prepareCall("{call update_salary(?,?)}");
            cs.setInt(1,101);
            cs.setInt(2,800000);
            cs.execute();
            System.out.println("Salary updated successfully!!");
            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
