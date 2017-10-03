package jayray.net.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jayray.net.data.DetalleInt;
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
}
