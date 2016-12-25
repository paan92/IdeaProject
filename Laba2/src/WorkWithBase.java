import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class WorkWithBase {

    public WorkWithBase() {
    }

    public void seeAllActors(Connection con) throws SQLException {

        String query = "select * from actor";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String last_update = rs.getString(4);
                System.out.println(id + "  first_name " + first_name + "  last_name " + last_name +
                        "  last_update " + last_update);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { stmt.close(); } catch(SQLException se) {  }
            try { rs.close(); } catch(SQLException se) {  }
        }
    }

    public void seeAllCategory(Connection con) throws SQLException {

        String query = "select * from category";
        Statement stmt = con.createStatement();
        ResultSet  rs = stmt.executeQuery(query);

        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String Name = rs.getString(2);
                System.out.println(id + " " + Name);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { stmt.close(); } catch(SQLException se) {  }
            try { rs.close(); } catch(SQLException se) {  }
        }
    }

    public void seeAllAddress(Connection con) throws SQLException{

        String query = "select * from address";
        Statement stmt = con.createStatement();
        ResultSet  rs = stmt.executeQuery(query);
        try {
            while (rs.next()) {
                String district = rs.getString(4);
                String postal_code = rs.getString(6);
                String phone = rs.getString(7);
                System.out.println(district + "   " + postal_code + "   " + phone);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { stmt.close(); } catch(SQLException se) {  }
            try { rs.close(); } catch(SQLException se) {  }
        }
    }

    public void search(Connection con, String obj_search) throws SQLException {

        String query = "select * from actor where actor.first_name = " + obj_search + ";";
        Statement stmt = con.createStatement();
        ResultSet  rs = stmt.executeQuery(query);

        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                System.out.println(id + "  first_name " + first_name + "  last_name " + last_name +
                        "  last_update ");
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try { stmt.close(); } catch(SQLException se) {  }
            try { rs.close(); } catch(SQLException se) {  }
        }
    }

    public void delete(Connection con, int number) throws SQLException {

        String temp = Integer.toString(number);
        String query = "DELETE from actor where actor_id = " + temp + ";";
        Statement stmt = con.createStatement();

        stmt.executeUpdate(query);
        try {
            stmt.close();
        } catch (SQLException se) {
        }
    }

    public void update(Connection con, int number) throws SQLException{
        String temp = Integer.toString(number);
        System.out.println("Введите новое имя");
        Scanner scanner = new Scanner(System.in);
        String temp1 = new String();
        temp1 = "'" + scanner.nextLine() + "'";

        System.out.println("Введите новую фамилию");
        Scanner scanner1 = new Scanner(System.in);
        String temp2 = new String();
        temp2 = "'" + scanner1.nextLine() + "'";
        String query = "update actor\n" +
                "set first_name = " + temp1 + " ," + "\n" +
                "\tlast_name = " + temp2  + "\n" +
                "where actor_id = " + temp + "\n" +
                "limit 1";
        Statement stmt = con.createStatement();



        stmt.executeUpdate(query);
        try {
            stmt.close();
        } catch (SQLException se) {
        }
    }

    public void add(Connection con) throws SQLException{

        System.out.println("Введите имя");
        Scanner scanner = new Scanner(System.in);
        String temp1 = new String();
        temp1 = "'" + scanner.nextLine() + "'";

        System.out.println("Введите фамилию");
        Scanner scanner1 = new Scanner(System.in);
        String temp2 = new String();
        temp2 = "'" + scanner1.nextLine() + "'";

        String query = "insert into actor\n" +
                "values (actor_id, " + temp1 +
                ", " + temp2 +
                ", current_timestamp());";

        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
    }
}
