package coneccionConMySQL;

import java.sql.*;

public class Jdbc10 {
	public static void main(String args[]) {

		try {
			Statement stmt;
			ResultSet rs;

			// Register the JDBC driver for MySQL.
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hibernate";
			Connection con = DriverManager.getConnection(url, "hibernate",
					"hibernate");
			// Display URL and connection information
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			// Get a Statement object
			stmt = con.createStatement();
			try {
				// stmt.executeUpdate("DROP TABLE myTable");
			} catch (Exception e) {
				System.out.print(e);
				System.out.println("No existing table to delete");
			}// end catch
			//stmt.executeUpdate("CREATE TABLE Event(id Long,"
			//		+ "title varchar(10))");
			stmt.executeUpdate("INSERT INTO Event(id, "
					+ "title) VALUES(1,'one')");

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * from Event ORDER BY id");
			System.out.println("Display all results:");
			while (rs.next()) {
				int theInt = rs.getInt("id");
				String str = rs.getString("title");
				System.out.println("\tid= " + theInt + "\ttitle= " + str);
			}// end while loop

			// System.out.println("Display row number 2:");
			// if (rs.absolute(2)) {
			// int theInt = rs.getInt("test_id");
			// String str = rs.getString("test_val");
			// System.out.println("\ttest_id= " + theInt + "\tstr = " + str);
			// }// end if
			// stmt.executeUpdate("DROP TABLE myTable");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}// end catch
	}// end main
}// end class Jdbc10
