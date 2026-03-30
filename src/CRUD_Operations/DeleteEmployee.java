package CRUD_Operations;

import java.sql.*;
public class DeleteEmployee {
    public static void main(String[] args) {
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "username",
                    "password");
            PreparedStatement pr=con.prepareStatement("DELETE FROM Attendance WHERE Employee_Id=?");
            pr.setInt(1,101);
            int rows=pr.executeUpdate();
            if(rows>0){
                System.out.println("Employee deleted successfully!!");
            }else {
                System.out.println("Employee Not Found");
            }
            con.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }
    }
}
