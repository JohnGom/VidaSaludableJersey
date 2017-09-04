package jayray.net.data;

import java.sql.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Jornada {
	private int id;
	private int encargado;
	private User infoEncargado;
	private int programa;
	private String name;
	private String city;
	private String department;
	private Date date;
	private String tipo;
	private String place;
	
	@XmlElement
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@XmlElement
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@XmlElement
	public Date getDate() {
		return date;
	}
	public void setDate(Date string) {
		this.date = string;
	}
	@XmlElement
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	@XmlElement
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@XmlElement
	public int getEncargado() {
		return encargado;
	}
	public void setEncargado(int encargado) {
		this.encargado = encargado;
	}
	@XmlElement
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public int getPrograma() {
		return programa;
	}
	public void setPrograma(int programa) {
		this.programa = programa;
	}
	public User getInfoEncargado() {
		return infoEncargado;
	}
	public void setInfoEncargado(User infoEncargado) {
		this.infoEncargado = infoEncargado;
	}

}
