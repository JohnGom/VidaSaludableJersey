package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jayray.net.data.Programa;
import jayray.net.data.User;

public class UserDb {
	public ArrayList<User> getAllUsers() throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<User> userList = new ArrayList<User>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM encargados");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("cedula"));
			user.setName(rs.getString("nombre"));
			user.setUsername(rs.getString("usuario"));
			user.setPassword(rs.getString("contrasena"));
			user.setType(rs.getString("tipo"));
			userList.add(user);
		}
		return userList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<User> getUsersEncuestador() throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<User> userList = new ArrayList<User>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM encargados where tipo = 'encuestador'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("cedula"));
			user.setName(rs.getString("nombre"));
			user.setUsername(rs.getString("usuario"));
			user.setPassword(rs.getString("contrasena"));
			user.setType(rs.getString("tipo"));
			userList.add(user);
		}
		return userList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean insertUser(User user) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = " insert into encargados(cedula, nombre, usuario, contrasena, tipo)"
		        + " values (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
	      preparedStmt.setInt (1, user.getId());
	      preparedStmt.setString (2, user.getName());
	      preparedStmt.setString (3, user.getUsername());
	      preparedStmt.setString (4, user.getPassword());
	      preparedStmt.setString (5, user.getType());
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean DeleteUser(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "delete from encargados where cedula = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		  preparedStmt.setInt(1, id);
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean updateUser(User user) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "update encargados set nombre = ?, usuario = ?, contrasena = ?, tipo = ? "
				+ "where cedula = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setString (1, user.getName());
	      preparedStmt.setString (2, user.getUsername());
	      preparedStmt.setString (3, user.getPassword());
	      preparedStmt.setString (4, user.getType());
	      preparedStmt.setInt(5, user.getId());
	      
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}

}
