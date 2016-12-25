import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/sakila?autoReconnect=true&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {

       Body body = new Body();

        try {
            con = DriverManager.getConnection(url, user, password);
            int temp = 2;
            while(temp == 2) {
                body.bodyProgram(con);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { con.close(); } catch(SQLException se) {  }
        }
    }
}
