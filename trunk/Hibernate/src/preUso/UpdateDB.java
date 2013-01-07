package preUso;

import java.sql.*;

public class UpdateDB {
	public static void main(String args[]) {
		ConectionH c = new ConectionH();
		Statement stmt = c.getStatement2();
		ResultSet rs;
		try {

			stmt.executeUpdate("CREATE TABLE Eventos(id int(11) "
			+ "auto_increment , name varchar(250) default NULL, "
					+ "taste varchar(250) default NULL, PRIMARY KEY (id))");

			stmt.executeUpdate("INSERT INTO Eventos(id,name,taste) "
					+ "VALUES(1,'one', 'Uno')");
			stmt.executeUpdate("INSERT INTO Eventos(id,name,taste) "
					+ "VALUES(2,'two','Dos')");
			stmt.executeUpdate("INSERT INTO Eventos(id,name,taste) "
					+ "VALUES(3,'three','Tres')");

			rs = stmt.executeQuery("SELECT * from Eventos");
			System.out.println("Display all results:");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String taste = rs.getString("taste");
				System.out.println("\tid= " + id + "\tname= " + name
						+ "\ttaste= " + taste);
			}// end while loop
			c.Close();
		} catch (SQLException e) {
			e.printStackTrace();
		}// end catch
	}// end main
}// end class
