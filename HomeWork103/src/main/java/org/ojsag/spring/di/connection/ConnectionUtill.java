package org.ojsag.spring.di.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class ConnectionUtill {
	
	public ConnectionUtill(){
		try {
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:/pds");
	}

	public void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		}
	}

	public void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
			}
		}
	}

	public void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		}
	}

	public void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
			}
		}
	}
}
