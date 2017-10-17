package jayray.net.data;

import java.sql.Date;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Intervencion {
	private int id;
	private int jornada;
	private int participante;
	private String observacion;
	private String resultado;
	private Date fechaInter;
	private Date fechaSegui;
	private Client cliente;
	private ArrayList<DetalleInt> detalles;
	private ArrayList<Interpretacion> interpretaciones;
	
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public int getJornada() {
		return jornada;
	}
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}
	@XmlElement
	public int getParticipante() {
		return participante;
	}
	public void setParticipante(int participante) {
		this.participante = participante;
	}
	@XmlElement
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@XmlElement
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	@XmlElement
	public Date getFechaInter() {
		return fechaInter;
	}
	public void setFechaInter(Date fechaInter) {
		this.fechaInter = fechaInter;
	}
	@XmlElement
	public Date getFechaSegui() {
		return fechaSegui;
	}
	public void setFechaSegui(Date fechaSegui) {
		this.fechaSegui = fechaSegui;
	}
	public Client getCliente() {
		return cliente;
	}
	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	public ArrayList<DetalleInt> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetalleInt> detalles) {
		this.detalles = detalles;
	}
	public ArrayList<Interpretacion> getInterpretaciones() {
		return interpretaciones;
	}
	public void setInterpretaciones(ArrayList<Interpretacion> interpretaciones) {
		this.interpretaciones = interpretaciones;
	}
}
