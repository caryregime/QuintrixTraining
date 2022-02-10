package projectJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws SQLException{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String databaseURL = "jdbc:mysql://localhost:3306/sakila";
		String user = "root";
		String password = "R3g!Me645";

		myConn = DriverManager.getConnection(databaseURL,user,password);


		//1
		myStmt = myConn.prepareStatement
				("Select * From sakila.city c \r\n"
						+ "Order By c.city ASC \r\n"
						+ "limit ?"); 
		myStmt.setInt(1, 10);
		myRs = myStmt.executeQuery();
		System.out.println(myRs);

		//2
		myStmt = myConn.prepareStatement
				("Select * From sakila.film f \r\n"
						+ "Where f.title LIKE '%airplane%'"); 
		myRs = myStmt.executeQuery();
		System.out.println(myRs);

		//3
		myStmt = myConn.prepareStatement
				("Select * From sakila.payment p\r\n"
						+ "Where p.amount = (SELECT MAX(amount) FROM sakila.payment)"); 
		myRs = myStmt.executeQuery();
		System.out.println(myRs);

		//4
		myStmt = myConn.prepareStatement
				("SELECT COUNT(*) FROM sakila.customer c\r\n"
						+ "Where c.store_id = ?"); 
		myStmt.setInt(1, 1);
		myRs = myStmt.executeQuery();
		System.out.println(myRs);

		//5
		myStmt = myConn.prepareStatement
				("SELECT p.payment_id, p.customer_id, p.staff_id, p.rental_id, p.amount, p.payment_date, p.last_update \r\n"
						+ "FROM sakila.payment p\r\n"
						+ "INNER JOIN sakila.customer c\r\n"
						+ "ON p.customer_id = c.customer_id\r\n"
						+ "Where c.email = ?"); 
		myStmt.setString(1, "NANCY.THOMAS@sakilacustomer.org");
		myRs = myStmt.executeQuery();
		System.out.println(myRs);

		//6
		myStmt = myConn.prepareStatement
				("SELECT f.film_id, f.title, f.description, f.release_year, f.language_id, f.original_language_id, f.rental_duration, f.rental_rate, f.length, f.replacement_cost, f.rating, f.special_features, f.last_update\r\n"
						+ "FROM sakila.film f\r\n"
						+ "INNER JOIN sakila.film_actor fa\r\n"
						+ "ON f.film_id = fa.film_id\r\n"
						+ "INNER JOIN sakila.actor a\r\n"
						+ "ON fa.actor_id = a.actor_id\r\n"
						+ "Where a.first_name = ? AND a.last_name = ?"); 
		myStmt.setString(1, "Bob");
		myStmt.setString(2, "Fawcett");
		myRs = myStmt.executeQuery();
		System.out.println(myRs);
	}
}
