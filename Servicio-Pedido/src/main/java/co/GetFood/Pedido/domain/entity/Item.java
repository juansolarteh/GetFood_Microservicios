package co.GetFood.Pedido.domain.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item")
public class Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idItem;
	
	@Column
	private long id_producto;
	
	@Column 
	private String nombre_product;
	
	@Column 
	private int cantidad_producto;
	
	@Column 
	private int precio_producto;
	
	@Column 
	private int precio_item;
	
	

	public long getId_producto() {
		return id_producto;
	}

	public void setId_producto(long id_producto) {
		this.id_producto = id_producto;
	}

	public String getNombre_product() {
		return nombre_product;
	}

	public void setNombre_product(String nombre_product) {
		this.nombre_product = nombre_product;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public int getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(int precio_producto) {
		this.precio_producto = precio_producto;
	}

	public int getPrecio_item() {
		return precio_item;
	}

	public void setPrecio_item(int precio_item) {
		this.precio_item = precio_item;
	}
	
}
