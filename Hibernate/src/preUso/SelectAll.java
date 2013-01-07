package preUso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConectionH c = new ConectionH();
		Statement stmt = c.getStatement();
		try {
			stmt = c.getStatement2();
			ResultSet rs = stmt.executeQuery("SELECT * "
					+ "from Event");
			System.out.println("Display all results:");
			while (rs.next()) {
				int theInt = rs.getInt("id");
				String str = rs.getString("title");
				System.out.println("\tid= " + theInt + "\ttitle = " + str);
			}// end while loop
			
			rs = stmt.executeQuery("SELECT * from Eventos");
			System.out.println("Display all results:");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String taste = rs.getString("taste");
				System.out.println("\tid= " + id + "\tname= " + name
						+ "\ttaste= " + taste);
			}// end while loop
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}