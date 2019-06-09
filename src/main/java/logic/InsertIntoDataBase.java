package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertIntoDataBase {
	private static final String url = "jdbc:mysql://localhost:3306/ingredients?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "";
    
 // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    
    /**
	* method insert ingredients in database
	*/
	public static void insertIntoDataBase() {
		Scanner in = new Scanner(System.in);
        System.out.print("Enter id for insert ");  
        int id = in.nextInt();
        System.out.print("Enter name for insert ");  
        //String name = in.nextLine();
        String name = in.next();
        System.out.print("Enter calory for insert ");  
        int calory = in.nextInt();
	    //in.close();
    	try {
    		// opening database connection to MySQL server
	        con = DriverManager.getConnection(url, user, password);
	
	        // getting Statement object to execute query
	        stmt = con.createStatement();
	
	        // executing INSERT query
	        String query = "INSERT INTO `ingredients` (`id`, `name`, `calory`) VALUES (" + "'"+id+"'" +", "+ "'"+name+"'" + ", " + "'"+calory+"'" + ")"; //('5', 'Peas', '58');
            stmt.executeUpdate(query);
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ } 
    	}
    	catch (SQLException sqlEx) {
            System.out.println("Не удалось подключиться к базе данных");
        } 
    }
}
