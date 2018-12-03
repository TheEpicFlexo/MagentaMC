package de.theepicflexo.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class MySQL {
	static String host;
	static String database;
	static String user;
	static String password;

	private static Connection con;

	public static void connect() {
		if (!isConnected()) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database, user, password);
				System.out.println("§8[LOBBY] - §aMySQL Verbunden");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void disconnect() {
		if (isConnected()) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("§8[LOBBY] - §aMySQL Verbindung getrennt");
				e.printStackTrace();
			}

		}
	}

	public static boolean isConnected() {
		return (con == null ? false : true);
	}

	public static void update(String qry) {
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) con.prepareStatement(qry);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ResultSet getResult(String qry) {
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(qry);
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
