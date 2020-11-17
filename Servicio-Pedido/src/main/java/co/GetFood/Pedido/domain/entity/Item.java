package co.GetFood.Pedido.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	@Id
	@Column 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pedido;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_producto;
	
	@Column 
	private String nombre_product;
	
	@Column 
	private int cantidad_producto;
	
	@Column 
	private int precio_producto;
	
	@Column 
	private int precio_item;

	public long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
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
