package com.urey.example.io;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessQuery {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String dbUr1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=E:\\Pro_Src\\∫≈¬ÎπÈ Ùµÿ\\mobile\\" + "Data.mdb";
		String user = "";
		String password = "";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection c = DriverManager.getConnection(dbUr1, user, password);
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("SELECT   MobileNumber   " + "FROM   DM_Mobile");
		while (r.next()) {
			System.out.println(r.getString("MobileNumber"));
		}
		s.close();
	}
}
