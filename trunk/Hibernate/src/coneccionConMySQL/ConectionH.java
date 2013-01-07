package coneccionConMySQL;

import java.sql.*;

public class ConectionH {
	Statement stmt;
	Connection con;

	public Statement getStatement() {
		return this.stmt;
	}

	public Statement getStatement2() {
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			e.printStackTrace();
			stmt = null;
		}
		return stmt;
	}

	public ConectionH() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hibernate";
			con = DriverManager.getConnection(url, "hibernate", "hibernate");
			stmt = con.createStatement();
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
