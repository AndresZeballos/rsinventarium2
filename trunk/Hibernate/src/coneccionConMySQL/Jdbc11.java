package coneccionConMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mysql";
			Connection con = DriverManager.getConnection(url, "root", "");
			System.out.println("URL: " + url);
			System.out.println("Connection: " + con);
			stmt = con.createStatement();
			stmt.executeUpdate("CREATE DATABASE hibernate");
			stmt.executeUpdate("GRANT SELECT,INSERT,UPDATE,DELETE,"
					+ "CREATE,DROP " + "ON hibernate.* TO 'hibernate'@'localhost' "
					+ "IDENTIFIED BY 'hibernate';");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}// end catch
	}// end main
}// end class Jdbc11
