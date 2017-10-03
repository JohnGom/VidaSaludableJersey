package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jayray.net.data.Jornada;
import jayray.net.data.Programa;

public class Program {

	public Programa getPrograms(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Programa> userList = new ArrayList<Programa>();
		try {
        Programa program = new Programa();
		PreparedStatement ps = connection
		.prepareStatement("select * from programas where id="+id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
	    program.setId(rs.getInt("id"));
	    program.setName(rs.getString("nombre"));
	    program.setDescription(rs.getString("descripcion"));
	    program.setEntity(rs.getString("entidadColaboradora"));
		}
		return program;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<Programa> getAllPrograms() throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Programa> userList = new ArrayList<Programa>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("select * from programas");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	    Programa program = new Programa();
	    program.setId(rs.getInt("id"));
	    program.setName(rs.getString("nombre"));
	    program.setDescription(rs.getString("descripcion"));
	    program.setEntity(rs.getString("entidadColaboradora"));
		userList.add(program);
		}
		return userList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean insertProgram(Programa programa) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = " insert into programas(nombre, descripcion, entidadColaboradora)"
		        + " values (?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
	      preparedStmt.setString (1, programa.getName());
	      preparedStmt.setString (2, programa.getDescription());
	      preparedStmt.setString (3, programa.getEntity());
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean DeletePrograma(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "delete from programas where id = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		  preparedStmt.setInt(1, id);
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean updatePrograma(Programa programa) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "update programas set nombre = ?, descripcion = ?, entidadColaboradora = ? "
				+ "where id = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setString (1, programa.getName());
	      preparedStmt.setString (2, programa.getDescription());
	      preparedStmt.setString (3, programa.getEntity());
	      preparedStmt.setInt(4, programa.getId());
	      
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
}
