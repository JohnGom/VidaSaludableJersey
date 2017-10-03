package jayray.net.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DetalleInt {
	private int id;
	private int question;
	private int intervened;
	private int jornada;
	private String respuesta;
	
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	@XmlElement
	public int getIntervened() {
		return intervened;
	}
	public void setIntervened(int intervened) {
		this.intervened = intervened;
	}
	@XmlElement
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	@XmlElement
	public int getJornada() {
		return jornada;
	}
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}
}
