package preUso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DestructorDB {

	public static void main(String args[]) {

		try {
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mysql";

			// Get a connection to the database for a
			// user named root with a blank password.
			// This user is the default administrator
			// having full privileges to do anything.
			Connection con = DriverManager.getConnection(url, "root", "1234");

			// Display URL and connection information
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			// Get a Statement object
			stmt = con.createStatement();
			stmt.executeUpdate("REVOKE ALL PRIVILEGES ON *.* "
					+ "FROM 'hibernate'@'localhost'");
			stmt.executeUpdate("REVOKE GRANT OPTION ON *.* "
					+ "FROM 'hibernate'@'localhost'");
			stmt.executeUpdate("DELETE FROM mysql.user WHERE "
					+ "User='hibernate' and Host='localhost'");
			stmt.executeUpdate("FLUSH PRIVILEGES");
			stmt.executeUpdate("DROP DATABASE hibernate");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}// end catch
	}// end main
}
