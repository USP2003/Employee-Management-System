package DB;

import java.sql.*;

public class DBConnection {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "IIM2026");

            Statement stmt = con.createStatement();


            con.close();

        }

        catch(Exception e) {
            System.out.println(e);
        }

    }
}