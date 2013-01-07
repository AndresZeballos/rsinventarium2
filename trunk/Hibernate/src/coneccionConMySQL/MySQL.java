package coneccionConMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConectionH c = new ConectionH();
		Statement stmt = c.getStatement();
		try {
			stmt = c.getStatement2();
			ResultSet rs = stmt.executeQuery("SELECT * "
					+ "from Event ORDER BY id");
			System.out.println("Display all results:");
			while (rs.next()) {
				int theInt = rs.getInt("id");
				String str = rs.getString("title");
				System.out.println("\tid= " + theInt + "\ttitle = " + str);
			}// end while loop
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}