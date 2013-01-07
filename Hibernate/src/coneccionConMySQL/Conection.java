package coneccionConMySQL;

import java.sql.*;

public class Conection {

	Statement stmt;
	Connection con;

	String usuario;
	String password;

	public Statement getStatement() {
		if (usuario != null && password != null) {
			return this.stmt;
		} else {
			return null;
		}
	}

	public Statement getStatement2() {
		if (usuario != null && password != null) {
			try {
				stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				return stmt;
			} catch (SQLException e) {
				e.printStackTrace();
				stmt = null;
			}
		}
		return stmt;
	}

	public Conection() {

		Login log = new Login();

		usuario = log.getUsuario();
		password = log.getPassword();

		try {

			// Esta clase no ejecuta ninguna sentecia ni obtiene resultados
			// ResultSet rs;

			// Register the JDBC driver for MySQL.
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/JunkDB";

			if (usuario != null && password != null) {
				con = DriverManager.getConnection(url, usuario, password);

				/*
				 * Codigo original "HARCODEADO" Connection con =
				 * DriverManager.getConnection(url, "auser", "drowssap");
				 */
				// Display URL and connection information
				// System.out.println("URL: " + url);
				// System.out.println("Connection: " + con);

				// Get a Statement object
				stmt = con.createStatement();

			}

			/*
			 * try { stmt.executeUpdate("DROP TABLE myTable"); } catch
			 * (Exception e) { System.out.print(e);
			 * System.out.println("No existing table to delete"); }// end catch
			 */

			/*
			 * stmt.executeUpdate("CREATE TABLE myTable(test_id int," +
			 * "test_val char(15) not null)");
			 * stmt.executeUpdate("INSERT INTO myTable(test_id, " +
			 * "test_val) VALUES(1,'One')");
			 * stmt.executeUpdate("INSERT INTO myTable(test_id, " +
			 * "test_val) VALUES(2,'Two')");
			 * stmt.executeUpdate("INSERT INTO myTable(test_id, " +
			 * "test_val) VALUES(3,'Three')");
			 * stmt.executeUpdate("INSERT INTO myTable(test_id, " +
			 * "test_val) VALUES(4,'Four')");
			 * stmt.executeUpdate("INSERT INTO myTable(test_id, " +
			 * "test_val) VALUES(5,'Five')");
			 */

			/*
			 * stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			 * ResultSet.CONCUR_READ_ONLY); rs = stmt.executeQuery("SELECT * " +
			 * "from myTable ORDER BY test_id");
			 * System.out.println("Display all results:"); while (rs.next()) {
			 * int theInt = rs.getInt("test_id"); String str =
			 * rs.getString("test_val"); System.out.println("\ttest_id= " +
			 * theInt + "\tstr = " + str); }// end while loop
			 * 
			 * System.out.println("Display row number 2:"); if (rs.absolute(2))
			 * { int theInt = rs.getInt("test_id"); String str =
			 * rs.getString("test_val"); System.out.println("\ttest_id= " +
			 * theInt + "\tstr = " + str); }// end if
			 * stmt.executeUpdate("DROP TABLE myTable");
			 */
			// con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}// end catch
	}

	public void Close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
