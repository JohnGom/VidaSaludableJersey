package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jayray.net.data.Client;
import jayray.net.data.DetalleInt;
import jayray.net.data.Intervencion;
import jayray.net.data.Jornada;
import jayray.net.data.User;

public class ClientDb {
	public Client ClientById(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
	    ArrayList<Client> clientList = new ArrayList<Client>();
		try {
		Client client = new Client();
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM participantes where identificacion=" + id);
		// ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			client.setId(rs.getInt("identificacion"));
			client.setTypeId(rs.getString("tipoId"));
			client.setEducation(rs.getString("nivelEducacion"));
			client.setFirstname(rs.getString("nombres"));
			client.setLastname(rs.getString("apellidos"));
			client.setBirthdate(rs.getDate("fechaNacimiento"));
			client.setGender(rs.getString("genero"));
			client.setStratus(rs.getInt("estrato"));
			client.setCivilStatus(rs.getString("estadocivil"));
			client.setEps(rs.getString("aseguradora"));
			client.setOccupation(rs.getString("ocupacion"));
			client.setReligion(rs.getString("religion"));
			clientList.add(client);
		}
		return client;
		} catch (Exception e) {
		throw e;
		}
		}
	public ArrayList<Intervencion> IntervencionByJornada(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
	    ArrayList<Intervencion> interList = new ArrayList<Intervencion>();
		try {
			InterpretationDb interp = new InterpretationDb();
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM intervenciones where jornada_numero=" + id);
		// ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Intervencion client = new Intervencion();
			client.setId(rs.getInt("numero"));
			client.setFechaSegui(rs.getDate("fechaSeguimiento"));
			client.setFechaInter(rs.getDate("fechaIntervencion"));
			client.setObservacion(rs.getString("observacion"));
			client.setResultado(rs.getString("resultado"));
			client.setCliente(ClientById(rs.getInt("participante")));
			client.setDetalles(detallesByIntervencion(rs.getInt("participante")));
			client.setInterpretaciones(interp.listInterpretaciones(rs.getInt("numero")));
			interList.add(client);
		}
		return interList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<DetalleInt> detallesByIntervencion(int id) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
	    ArrayList<DetalleInt> interList = new ArrayList<DetalleInt>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM detallesintervenciones where intervenido=" + id);
		// ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			DetalleInt detalle = new DetalleInt();
			detalle.setId(rs.getInt("id"));
			detalle.setIntervened(rs.getInt("intervenido"));
			detalle.setJornada(rs.getInt("jornada"));
			detalle.setQuestion(rs.getInt("pregunta"));
			detalle.setRespuesta(rs.getString("respuesta"));
			interList.add(detalle);
		}
		return interList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean insertCliente(Client client) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "insert into participantes(identificacion, tipoId, nivelEducacion, nombres, apellidos, fechaNacimiento, genero, estrato, estadocivil, aseguradora, ocupacion, religion) "
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		  preparedStmt.setInt (1, client.getId());
	      preparedStmt.setString (2, client.getTypeId());
	      preparedStmt.setString (3, client.getEducation());
	      preparedStmt.setString (4, client.getFirstname());
	      preparedStmt.setString (5, client.getLastname());
	      preparedStmt.setDate (6, client.getBirthdate());
	      preparedStmt.setString (7, client.getGender());
	      preparedStmt.setInt (8, client.getStratus());
	      preparedStmt.setString (9, client.getCivilStatus());
	      preparedStmt.setString (10, client.getEps());
	      preparedStmt.setString (11, client.getOccupation());
	      preparedStmt.setString (12, client.getReligion());
	      preparedStmt.execute();
	
	      connection.close();
	     
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public int insertIntervention(Intervencion intervencion) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "insert into intervenciones(jornada_numero, participante, observacion, resultado, fechaIntervencion, fechaSeguimiento, correo)"
		        + " values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
		  preparedStmt.setInt (1, intervencion.getJornada());
	      preparedStmt.setInt (2, intervencion.getParticipante());
	      preparedStmt.setString (3, intervencion.getObservacion());
	      preparedStmt.setString (4, intervencion.getResultado());
	      preparedStmt.setDate (5, intervencion.getFechaInter());
	      preparedStmt.setDate (6, intervencion.getFechaSegui());
	      preparedStmt.setString (7, intervencion.getCorreo());
	      preparedStmt.execute();
	      
	      int clave = 0;
	      ResultSet generatedKeys = preparedStmt.getGeneratedKeys();
	      if (generatedKeys.next()) {
	    	  clave = generatedKeys.getInt(1);
	      }
	     
	      connection.close();
	     
	      return clave;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean updateIntervention(Intervencion intervencion) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		String query = "update intervenciones set observacion = ?, resultado = ?, "
				+ "fechaIntervencion = ?, fechaSeguimiento = ?, correo = ? where numero = ?";
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		  preparedStmt.setString (1, intervencion.getObservacion());
	      preparedStmt.setString (2, intervencion.getResultado());
	      preparedStmt.setDate (3, intervencion.getFechaInter());
	      preparedStmt.setDate (4, intervencion.getFechaSegui());
	      preparedStmt.setString (5, intervencion.getCorreo());
	      preparedStmt.setInt (6, intervencion.getId());
	      preparedStmt.execute();
	      connection.close();
	     
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
}
