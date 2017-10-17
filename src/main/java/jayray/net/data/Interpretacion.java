package jayray.net.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Interpretacion {
	private int id;
	private int intervencion;
	private int participante;
	private String nombre;
	private String resultado;
	private String recomendacion;
	private String dimension;
	
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public int getIntervencion() {
		return intervencion;
	}
	public void setIntervencion(int intervencion) {
		this.intervencion = intervencion;
	}
	@XmlElement
	public int getParticipante() {
		return participante;
	}
	public void setParticipante(int participante) {
		this.participante = participante;
	}
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	@XmlElement
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getRecomendacion() {
		return recomendacion;
	}
	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}
}
