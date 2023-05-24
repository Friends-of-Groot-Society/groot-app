package app.mapl.util;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
//public static Connection conn = JDBCConnection.getConnection();

public class JDBCConnection {
	@Value("${spring.datasource.driver-class-name}") // ${"oracle.jdbc.driver.OracleDriver"})
	private static String DRIVER;

	@Value("${spring.datasource.url}")
	private static  String URL;// = "jdbc:oracle:thin:@thomas.cmcadlepsyx9.us-east-1.rds.amazonaws.com:1521:thomas";
	public static Connection conn = null; // connect to singleton design pattern
	public static Connection getConnection() {
		try {
			System.out.println(Class.forName(DRIVER)+DRIVER+"...${DRIVER} JDBC Driver connected.");
		} catch (ClassNotFoundException e) {
			System.out.println("oops, Driver not found :-O");
			e.printStackTrace();
		}
		if(conn == null) {
			String endpoint = URL;
			String username = "thomas";
			String password = getJDBCKey();//
			try {
				conn = DriverManager.getConnection(endpoint, username, password);
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return conn;
		}
		return null;
	}

	public static String getJDBCKey() {
		Map<String, String> env = System.getenv();
		for (Map.Entry<String, String> entry : env.entrySet()) {
			if (entry.getKey().equals("ORACLE_DB_PASSWORD")) {
				return entry.getValue();
			}
		}
		return null;
	}

}
