package CRUD_Operations;

import java.sql.*;
public class AddEmployee {
    public static void main(String[] args) {
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "IIM2026");
            PreparedStatement pr=con.prepareStatement("INSERT INTO EMPLOYEES VALUES (?,?,?,?,?,SYSDATE)");

            pr.setInt(1,103);
            pr.setString(2,"Ujwala");
            pr.setString(3,"uji45@gmail.com");
            pr.setInt(4,2);
            pr.setInt(5,55000);
            pr.executeUpdate();
            System.out.println("Data entered successfully!!");

        }

        catch(Exception e) {
            System.out.println(e);
        }

    }
}
