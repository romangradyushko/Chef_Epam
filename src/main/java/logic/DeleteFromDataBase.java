package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteFromDataBase {
	private static final String url = "jdbc:mysql://localhost:3306/ingredients?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";
    
 // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
   
    /**
	* method delete record from database 
	*/
	public static void deleteFromDataBase() {
		
		Scanner in = new Scanner(System.in);
        System.out.print("Enter id for delete ");
        
        
        int id = in.nextInt();
	    //in.close();
    	try {
    		// opening database connection to MySQL server
	        con = DriverManager.getConnection(url, user, password);
	
	        // getting Statement object to execute query
	        stmt = con.createStatement();
	
	        // executing INSERT query
	        String query = "DELETE FROM `ingredients` WHERE `id` = "  + id;
	       // String query = String.format("DELETE FROM `ingredients` WHERE `id` = %i ", id);
	        stmt.executeUpdate(query);
	        
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
    	}
    	catch (SQLException sqlEx) {
    		System.out.println("Не удалось подключиться к базе данных");
        } 
    }
}
