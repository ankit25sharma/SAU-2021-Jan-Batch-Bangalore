package springAU;

import java.sql.*;

public class InsertDB {
	public void insertToDB(int num) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		String dbUrl = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";
		String user = "sMkXvyYxZM";
		String password = "8h9tWhCKws";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl,user,password);
			String sql = "Insert into test values(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, num);
			preparedStatement.setString(2, "Ankit");
			preparedStatement.execute();
			
			ResultSet result = preparedStatement.executeQuery("select * from test");
			while(result.next()) {
			    String id = result.getString("id");
			    String name = result.getString("name");
			    System.out.println(id + "   " + name); 
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
				connection.close();
			if(preparedStatement!=null)
				preparedStatement.close();
			if(resultSet!=null)
				resultSet.close();
		}
 	}
	
}
