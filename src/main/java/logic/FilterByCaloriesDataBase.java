package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FilterByCaloriesDataBase {
	private static final String url = "jdbc:mysql://localhost:3306/ingredients?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";
    
 // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    /**
	* method select ingredients in database by calories 
	*/
    public static void filterByCalories() {
    	Scanner in = new Scanner(System.in);
        System.out.print("Enter calorie for filter ");      
        int calorie = in.nextInt();
	    //in.close();
    	try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            String query = "SELECT * FROM `ingredients` WHERE `calory` < " + calorie;
            rs = stmt.executeQuery(query);
            System.out.println("Work with DataBase");
            while (rs.next()) {
            	   int id = rs.getInt(1);
            	   String name = rs.getString(2);
            	   int calory = rs.getInt(3);
            	   System.out.printf("id: %d, name: %s, calory: %s %n", id, name, calory);
            	 }
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
           
    	}
    	catch (SQLException sqlEx) {
            System.out.println("Unable to connect to database");
        } 
    }
}
