package com.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;

import com.rest.model.DataSource;
import com.rest.model.User;
import com.rest.util.ApplicationContextProvider;

public class DBUtil {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		DataSource dataSource = (DataSource) context.getBean("datasource");
		Class.forName(dataSource.getDbDriverClass());
		Connection con = DriverManager.getConnection(
				dataSource.getDbURL() + dataSource.getDbPort() + "/" + dataSource.getDbName(),
				dataSource.getDbUserName(), dataSource.getDbPassword());

		return con;
	}
	
	public static void setUserDetails(User user){
		String sqlQuery = "insert into user(username,password,isactive) values(?,?,1)";
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
			con.commit();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
