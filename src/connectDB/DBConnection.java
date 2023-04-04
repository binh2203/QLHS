package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static DBConnection instance;
	private Connection cnt;

	private DBConnection() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyHieuSach;trustServerCertificate=true";
		String user = "sa";
		String pass = "241853048@@Binh";
		try {
			cnt = DriverManager.getConnection(url, user, pass);
//			System.out.println("Connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public synchronized static DBConnection getInstance() {
		if (instance == null)
			instance = new DBConnection();
		return instance;
	}

	public Connection getConnection() {
		return cnt;
	}

}