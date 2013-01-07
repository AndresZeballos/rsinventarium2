package preUso;

import java.sql.*;

public class CreaDB {
	public static void main(String args[]) {
		try {
			Statement stmt;
			String url;
			Connection con;
			ResultSet rs;

			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/mysql";
			con = DriverManager.getConnection(url, "root", "1234");
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			stmt = con.createStatement();
			stmt.executeUpdate("CREATE DATABASE hibernate");
			stmt.executeUpdate("GRANT SELECT,INSERT,UPDATE,DELETE,"
					+ "CREATE,DROP "
					+ "ON hibernate.* TO 'hibernate'@'localhost' "
					+ "IDENTIFIED BY 'hibernate';");
			con.close();

			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/hibernate";
			con = DriverManager.getConnection(url, "hibernate", "hibernate");
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);

			stmt = con.createStatement();
			try {
				// stmt.executeUpdate("DROP TABLE Event");
			} catch (Exception e) {
				System.out.print(e);
				System.out.println("No existing table to delete");
			}// end catch
			// Crea la tabla en la base hibernate
			stmt.executeUpdate("CREATE TABLE Event(id Long,"
					+ "title varchar(10))");
			stmt.executeUpdate("INSERT INTO Event(id, "
					+ "title) VALUES(1,'one')");
			stmt.executeUpdate("INSERT INTO Event(id, "
					+ "title) VALUES(1,'one')");
			stmt.executeUpdate("INSERT INTO Event(id, "
					+ "title) VALUES(2,'tiu')");

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * from Event ORDER BY id");
			System.out.println("Display all results:");
			while (rs.next()) {
				int theInt = rs.getInt("id");
				String str = rs.getString("title");
				System.out.println("\tid= " + theInt + "\ttitle= " + str);
			}// end while loop

			// stmt.executeUpdate("DROP TABLE myTable");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}// end catch
	}// end main
}// end class
