package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import jayray.net.data.Jornada;
import jayray.net.data.Programa;
import jayray.net.data.User;

public class JornadaDb {
	public ArrayList<Jornada> getAllJornadas() throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Jornada> jornadaList = new ArrayList<Jornada>();
		LoginHandler user = new LoginHandler();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM jornadas");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	    Jornada jornada = new Jornada();
	    jornada.setId(rs.getInt("numero"));
	    jornada.setPrograma(rs.getInt("programa"));
	    jornada.setName(rs.getString("nombre"));
	    jornada.setInfoEncargado(user.userById(rs.getInt("encargado")));
	    jornada.setCity(rs.getString("ubicacion_codMunicipio"));
	    jornada.setDepartment(rs.getString("ubicacion_dpto"));
	    jornada.setDate(rs.getDate("fecha"));
	    jornada.setTipo(rs.getString("tipo"));
	    jornada.setPlace(rs.getString("lugarJornada"));
	    jornadaList.add(jornada);
		}
		return jornadaList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<Jornada> getJornadas(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Jornada> jornadaList = new ArrayList<Jornada>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM jornadas WHERE programa="+id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	    Jornada jornada = new Jornada();
	    jornada.setId(rs.getInt("numero"));
	    jornada.setPrograma(rs.getInt("programa"));
	    jornada.setEncargado(rs.getInt("encargado"));
	    jornada.setCity(rs.getString("ubicacion_codMunicipio"));
	    jornada.setDepartment(rs.getString("ubicacion_dpto"));
	    jornada.setDate(rs.getDate("fecha"));
	    jornada.setTipo(rs.getString("tipo"));
	    jornada.setPlace(rs.getString("lugarJornada"));
	    jornadaList.add(jornada);
		}
		return jornadaList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean insertJornada(Jornada jornada) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = " insert into jornadas(programa, encargado, nombre, ubicacion_codMunicipio, ubicacion_dpto, fecha, tipo, lugarJornada, cuestionario)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		  preparedStmt.setInt (1, jornada.getPrograma());
	      preparedStmt.setInt (2, jornada.getEncargado());
	      preparedStmt.setString (3, jornada.getName());
	      preparedStmt.setString (4, jornada.getCity());
	      preparedStmt.setString (5, jornada.getDepartment());
	      preparedStmt.setDate (6, jornada.getDate());
	      preparedStmt.setString (7, jornada.getTipo());
	      preparedStmt.setString (8, jornada.getPlace());
	      preparedStmt.setInt (9, 1);
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	public Boolean DeleteJornada(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "delete from jornadas where numero = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		  preparedStmt.setInt(1, id);
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean UpdateJornada(Jornada jornada) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "update jornadas set encargado = ?, nombre = ?, ubicacion_codMunicipio = ?, "
				+ "ubicacion_dpto = ?, fecha = ?, tipo = ?, lugarJornada = ?  where numero = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
	      preparedStmt.setInt (1, jornada.getEncargado());
	      preparedStmt.setString (2, jornada.getName());
	      preparedStmt.setString (3, jornada.getCity());
	      preparedStmt.setString (4, jornada.getDepartment());
	      preparedStmt.setDate (5, jornada.getDate());
	      preparedStmt.setString (6, jornada.getTipo());
	      preparedStmt.setString (7, jornada.getPlace());
	      preparedStmt.setInt (8, jornada.getId());
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
}
