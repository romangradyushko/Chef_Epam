package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataBaseCRUD {
	private static final String url = "jdbc:mysql://localhost:3306/ingredients?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";
    
 // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    /**
	* method insert ingredients in database
	*/
	public static void insertIntoDataBase() {
		Scanner in = new Scanner(System.in);
        System.out.print("Enter id for insert ");  
        int id = in.nextInt();
        System.out.print("Enter name for insert ");  
        String name = in.next();
        System.out.print("Enter calory for insert ");  
        int calory = in.nextInt();
    	try {
    		// opening database connection to MySQL server
	        con = DriverManager.getConnection(url, user, password);
	
	        // getting Statement object to execute query
	        stmt = con.createStatement();
	
	        // executing INSERT query
	        String query = "INSERT INTO `ingredients` (`id`, `name`, `calory`) VALUES (" + "'"+id+"'" +", "+ "'"+name+"'" + ", " + "'"+calory+"'" + ")"; //('5', 'Peas', '58');
            stmt.executeUpdate(query); 
    	}
    	catch (SQLException sqlEx) {
            System.out.println("Failed to connect to database");
        } 
    	finally {
    		try { con.close(); } catch(SQLException se) { /*can't do anything */ }
    		try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
    	}
	}
	
	/**
	* method select ingredients in database by calories 
	*/
    public static void filterByCalories() {
    	Scanner in = new Scanner(System.in);
        System.out.print("Enter calorie for filter ");      
        int calorie = in.nextInt();
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
    	}
    	catch (SQLException sqlEx) {
            System.out.println("Failed to connect to database");
        } 
    	finally {
    		try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
    	}
    }
    
    /**
	* method update ingredients in database  
	*/
	public static void updateDataBase() {
		Scanner in = new Scanner(System.in);
        System.out.print("Enter id for update ");  
        int id = in.nextInt();
        System.out.print("Enter calory for update ");  
        int calory = in.nextInt();
    	try {
    		// opening database connection to MySQL server
	        con = DriverManager.getConnection(url, user, password);
	
	        // getting Statement object to execute query
	        stmt = con.createStatement();
	
	        // executing INSERT query
	        String query = "UPDATE `ingredients` SET `calory`= " + calory + " WHERE `id`= " + id;
            stmt.executeUpdate(query);
    	}
    	catch (SQLException sqlEx) {
    		System.out.println("Failed to connect to database");
        } 
    	finally {
    		try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
    	}
    }
	
	/**
	* method delete record from database 
	*/
	public static void deleteFromDataBase() {
		
		Scanner in = new Scanner(System.in);
        System.out.print("Enter id for delete ");
        int id = in.nextInt();
	    in.close();
    	try {
    		// opening database connection to MySQL server
	        con = DriverManager.getConnection(url, user, password);
	
	        // getting Statement object to execute query
	        stmt = con.createStatement();
	
	        // executing INSERT query
	        String query = "DELETE FROM `ingredients` WHERE `id` = "  + id;
	        stmt.executeUpdate(query);
	        
    	}
    	catch (SQLException sqlEx) {
    		System.out.println("Failed to connect to database");
        } 
    	finally {
    		try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
    	}
    }
}
