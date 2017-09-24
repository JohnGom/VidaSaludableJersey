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
	public ArrayList<Jornada> getAllJornadas(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Jornada> jornadaList = new ArrayList<Jornada>();
		LoginHandler user = new LoginHandler();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM jornadas where programa=" + id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	    Jornada jornada = new Jornada();
	    jornada.setId(rs.getInt("numero"));
	    jornada.setPrograma(rs.getInt("programa"));
	    jornada.setName(rs.getString("nombre"));
	    jornada.setEncargados(user.users(rs.getInt("numero")));
	    jornada.setCity(rs.getString("ubicacion_codMunicipio"));
	    jornada.setDepartment(rs.getString("ubicacion_dpto"));
	    jornada.setDate(rs.getDate("fecha"));
	    jornada.setTipo(rs.getString("tipo"));
	    jornada.setPlace(rs.getString("lugarJornada"));
	    jornada.setState(rs.getString("estado"));
	    jornadaList.add(jornada);
		}
		return jornadaList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<Jornada> getJornadaByEncuestador(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Jornada> jornadaList = new ArrayList<Jornada>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("select DISTINCT jornadas.* from jornadas \r\n" + 
				"inner JOIN encargadosjornada ON encargadosjornada.jornada=jornadas.numero\r\n" + 
				"WHERE encargadosjornada.encargado ="+id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
	    Jornada jornada = new Jornada();
	    jornada.setId(rs.getInt("numero"));
	    jornada.setPrograma(rs.getInt("programa"));
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
		String query = "insert into jornadas(programa, nombre, ubicacion_codMunicipio, ubicacion_dpto, fecha, tipo, lugarJornada, estado)"
		        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		  preparedStmt.setInt (1, jornada.getPrograma());
	      preparedStmt.setString (2, jornada.getName());
	      preparedStmt.setString (3, jornada.getCity());
	      preparedStmt.setString (4, jornada.getDepartment());
	      preparedStmt.setDate (5, jornada.getDate());
	      preparedStmt.setString (6, jornada.getTipo());
	      preparedStmt.setString (7, jornada.getPlace());
	      preparedStmt.setString (8, jornada.getState());
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
		String query = "update jornadas set nombre = ?, ubicacion_codMunicipio = ?, "
				+ "ubicacion_dpto = ?, fecha = ?, tipo = ?, lugarJornada = ?, estado = ?  where numero = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
	      preparedStmt.setString (1, jornada.getName());
	      preparedStmt.setString (2, jornada.getCity());
	      preparedStmt.setString (3, jornada.getDepartment());
	      preparedStmt.setDate (4, jornada.getDate());
	      preparedStmt.setString (5, jornada.getTipo());
	      preparedStmt.setString (6, jornada.getPlace());
	      preparedStmt.setString (7, jornada.getState());
	      preparedStmt.setInt (8, jornada.getId());
	      preparedStmt.execute();
	      
	      connection.close();
	      
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean insertEncargadosJornada(ArrayList<User> users, int jornada) throws Exception {
			DbConnection database= new DbConnection();
			Connection connection = database.getConnection();
			try {
			for(int i=0; i<users.size(); i++) {
				boolean estado = users.get(i).isState();
				PreparedStatement ps = connection
				.prepareStatement("select * from encargadosjornada where jornada="+ jornada + " and encargado="+users.get(i).getId());
				ResultSet rs = ps.executeQuery();
				if(rs.next() && !estado){
					System.out.println("elimina");
	            	String query = "delete from encargadosjornada where jornada = ? and encargado = ?";
	        		PreparedStatement preparedStmt = connection.prepareStatement(query);
	        		  preparedStmt.setInt(1, jornada);
	        		  preparedStmt.setInt(2, users.get(i).getId());
	        	      preparedStmt.execute();
		        }
		        else if(!rs.next() && estado) {
		        	System.out.println("crea");
	            	String query = "INSERT INTO encargadosjornada(encargado, jornada) VALUES (?,?)";
	        		PreparedStatement preparedStmt = connection.prepareStatement(query);
	        		  preparedStmt.setInt(1, users.get(i).getId());
	        		  preparedStmt.setInt(2, jornada);
	        	      preparedStmt.execute();
		        }
			}
			connection.close();
		    return true;
			} catch (Exception e) {
			throw e;
			}
	}
	
}
