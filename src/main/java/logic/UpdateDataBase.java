package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDataBase {
	private static final String url = "jdbc:mysql://localhost:3306/ingredients?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";
    
 // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    
    /**
	* method update ingredients in database  
	*/
	public static void updateDataBase() {
		Scanner in = new Scanner(System.in);
        System.out.print("Enter id for update ");  
        int id = in.nextInt();
        System.out.print("Enter calory for update ");  
        int calory = in.nextInt();
        in.close();
    	try {
    		// opening database connection to MySQL server
	        con = DriverManager.getConnection(url, user, password);
	
	        // getting Statement object to execute query
	        stmt = con.createStatement();
	
	        // executing INSERT query
	        String query = "UPDATE `ingredients` SET `calory`= " + calory + " WHERE `id`= " + id;
            stmt.executeUpdate(query);
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
    	}
    	catch (SQLException sqlEx) {
    		System.out.println("Не удалось подключиться к базе данных");
        } 
    }
}
