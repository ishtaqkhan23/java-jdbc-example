import java.sql.*;

//before writing this program
//make sure you have a database setup in your local and
// add the mysql connector library into the project
// steps to add
// 1. download connector jar file
// 2. add jar file to the project. In intellij, open file -> project structure -> libraries -> add using + icon -> apply)
public class Main {

    public static void main(String[] args) {

        try {
            //step1: load driver class
            Class.forName("com.mysql.jdbc.Driver");

            //step2: establish a connection by providing connection url, username and password.
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mycompany", "root", "root");


            //step3: create a statement object on connection obj
            Statement stmt = con.createStatement();

            //step4: pass a query to the executeQuery method of statement object
            // the query result will be returned as a ResultSet object
            ResultSet rs = stmt.executeQuery("select * from employee where id = 1 ");

            //step5: read the result through resultset object
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)
                + " "+ rs.getInt(4) + " "+ rs.getDate(5) + " " + rs.getString(6));
                //System.out.println(rs.getString("name"));
            }

            //step6: close the connection obj
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found : "+e);
        } catch (SQLException e) {
            System.out.println("SQL Exception : "+ e);
        }
    }
}