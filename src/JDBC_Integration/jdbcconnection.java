package JDBC_Integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcconnection {
    static String host = "localhost"; // Replace with your MySQL host
    static String port = "3306";      // Default MySQL port

    public static void main(String[] args) {
        // Database credentials
        String database = "qadbtest"; // Replace with your database name
        String username = "root";    // Replace with your MySQL username
        String password = "Mysql#@107"; // Replace with your MySQL password

        try {
            // Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);

            // Create a statement
            Statement s = con.createStatement();

            // Execute the query
            ResultSet rs = s.executeQuery("SELECT * FROM employeeinfo WHERE location = 'Varanasi';");

            // Process the result set
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age")); // Use getInt for numeric values
            }

            // Close the resources
            rs.close();
            s.close();
            con.close();

        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        }
        
     // suppose want to inject the data from DB then 
    	
    	/*
    	while(rs.next()) {
    	WebDriver driver = new ChromeDriver();
    	driver.findElement(By.id("abc").sendKeys(rs.getString("name"));
    	driver.findElement(By.id("xyz").sendKeys(rs.getString("age"));
    	} 
    	 */
    }
}


/*
This works only for mySQL database

Connection URL : 
"jdbc:mysql://" + hostname + ":" + port_number + "/databasename";

Our system : 
"jdbc:mysql://" +localhost+ ":" +3306+ "/qadbtest";

*/