package co.GetFood.restaurante.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name ="restaurante")
public class Restaurante {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long restnit;
	
	@Column
	private String restnombre;
	
	@Column
	private String restdireccion;
	
	@Column
	private Long resttelefono;
	
	@Column
	private boolean restabierto;

	@Column
	public Long getRestnit() {
		return restnit;
	}

	public void setRestnit(Long restnit) {
		this.restnit = restnit;
	}

	public String getRestnombre() {
		return restnombre;
	}

	public void setRestnombre(String restnombre) {
		this.restnombre = restnombre;
	}

	public String getRestdireccion() {
		return restdireccion;
	}

	public void setRestdireccion(String restdireccion) {
		this.restdireccion = restdireccion;
	}

	public Long getResttelefono() {
		return resttelefono;
	}

	public void setResttelefono(Long resttelefono) {
		this.resttelefono = resttelefono;
	}

	public boolean isRestabierto() { return restabierto; }
	  
	public void setRestabierto(boolean restabierto) { 
		this.restabierto = restabierto; }
	 
}