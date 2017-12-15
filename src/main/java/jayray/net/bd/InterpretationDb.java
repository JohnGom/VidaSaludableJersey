package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jayray.net.data.DetalleInt;
import jayray.net.data.InfoInter;
import jayray.net.data.Interpretacion;
import jayray.net.data.Jornada;
import jayray.net.data.Pregunta;
import jayray.net.data.Programa;
import jayray.net.data.User;

public class InterpretationDb {
	
	public ArrayList<Pregunta> questionsByDimension(String dimension) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Pregunta> questionsList = new ArrayList<Pregunta>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM pregunta where dimension='" + dimension +"'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Pregunta question = new Pregunta();
			question.setId(rs.getInt("id"));
			question.setQuestion(rs.getString("preguntas"));
			question.setDimension(rs.getString("dimension"));
	        questionsList.add(question);
		}
		return questionsList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<Pregunta> questionsAll() throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Pregunta> questionsList = new ArrayList<Pregunta>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM pregunta");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Pregunta question = new Pregunta();
			question.setId(rs.getInt("id"));
			question.setQuestion(rs.getString("preguntas"));
			question.setDimension(rs.getString("dimension"));
	        questionsList.add(question);
		}
		return questionsList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<InfoInter> infoInterByDimension(String dimension) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<InfoInter> infoList = new ArrayList<InfoInter>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM infoInterpretaciones where dimension='" + dimension +"'");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			InfoInter question = new InfoInter();
			question.setId(rs.getInt("id"));
			question.setCategoria(rs.getString("categoria"));
			question.setDimension(rs.getString("dimension"));
			question.setRecomendacion(rs.getString("recomendacion"));
			infoList.add(question);
		}
		return infoList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<InfoInter> infoAllInter() throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<InfoInter> infoList = new ArrayList<InfoInter>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM infoInterpretaciones");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			InfoInter question = new InfoInter();
			question.setId(rs.getInt("id"));
			question.setCategoria(rs.getString("categoria"));
			question.setDimension(rs.getString("dimension"));
			question.setRecomendacion(rs.getString("recomendacion"));
			infoList.add(question);
		}
		return infoList;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public ArrayList<Interpretacion> listInterpretaciones(int inter) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		ArrayList<Interpretacion> listInter = new ArrayList<Interpretacion>();
		try {
		PreparedStatement ps = connection
		.prepareStatement("SELECT * FROM interpretaciones where intervencion=" + inter);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Interpretacion interpretacion = new Interpretacion();
			interpretacion.setId(rs.getInt("id"));
			interpretacion.setIntervencion(rs.getInt("intervencion"));
			interpretacion.setNombre(rs.getString("nombre"));
			interpretacion.setResultado(rs.getString("resultado"));
			interpretacion.setRecomendacion(rs.getString("recomendacion"));
			interpretacion.setDimension(rs.getString("dimension"));
			interpretacion.setParticipante(rs.getInt("participante"));
			listInter.add(interpretacion);
		}
		return listInter;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean insertDetail(ArrayList<DetalleInt> detalles) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		for(int i=0; i<detalles.size(); i++) {
			String query = " insert into detallesintervenciones(intervenido, pregunta, jornada, respuesta)"
			        + " values (?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
	        preparedStmt.setInt(1, detalles.get(i).getIntervened());
	        preparedStmt.setInt(2, detalles.get(i).getQuestion());
	        preparedStmt.setInt(3, detalles.get(i).getJornada());
	        preparedStmt.setString (4, detalles.get(i).getRespuesta());
	        preparedStmt.execute();
		}
	      connection.close();
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
	
	public Boolean insertInterpre(ArrayList<Interpretacion> interpretacion) throws Exception {
		DbConnection database= new DbConnection();
		Connection connection = database.getConnection();
		try {
		for(int i=0; i<interpretacion.size(); i++) {
			String query = " insert into interpretaciones(participante, nombre, resultado, recomendacion, dimension, intervencion)"
			        + " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = connection.prepareStatement(query);
	        preparedStmt.setInt(1, interpretacion.get(i).getParticipante());
	        preparedStmt.setString(2, interpretacion.get(i).getNombre());
	        preparedStmt.setString(3, interpretacion.get(i).getResultado());
	        preparedStmt.setString(4, interpretacion.get(i).getRecomendacion());
	        preparedStmt.setString(5, interpretacion.get(i).getDimension());
	        preparedStmt.setInt(6, interpretacion.get(i).getIntervencion());
	        preparedStmt.execute();
		}
	      connection.close();
	      return true;
		} catch (Exception e) {
		throw e;
		}
		}
}
