package co.GetFood.Pedido.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class EntityPedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public EntityPedido(Long id_pedido, Long id_rest, String nombre_restaurante, Long id_cliente,
			String direccion_pedido, int telefono_pedido, int precio_pedido) {
		this.id_rest = id_rest;
		this.nombre_restaurante = nombre_restaurante;
		this.id_cliente = id_cliente;
		this.direccion_pedido = direccion_pedido;
		this.telefono_pedido = telefono_pedido;
		this.precio_pedido = precio_pedido;
	}
	
	public EntityPedido(Long id_rest) {
		this.id_rest = id_rest;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pedido;

	@Column
	private Long id_rest;
	
	@Column 
	private String nombre_restaurante;
	
	@Column 
	private Long id_cliente;
	
	@Column 
	private String direccion_pedido;
	
	@Column 
	private int telefono_pedido;
	
	@Column 
	private int precio_pedido;

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long idPedido) {
		this.id_pedido = idPedido;
	}

	public Long getId_rest() {
		return id_rest;
	}

	public void setId_rest(Long id_rest) {
		this.id_rest = id_rest;
	}

	public String getNombre_restaurante() {
		return nombre_restaurante;
	}

	public void setNombre_restaurante(String nombre_restaurante) {
		this.nombre_restaurante = nombre_restaurante;
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getDireccion_pedido() {
		return direccion_pedido;
	}

	public void setDireccion_pedido(String direccion_pedido) {
		this.direccion_pedido = direccion_pedido;
	}

	public int getTelefono_pedido() {
		return telefono_pedido;
	}

	public void setTelefono_pedido(int telefono_pedido) {
		this.telefono_pedido = telefono_pedido;
	}

	public int getPrecio_pedido() {
		return precio_pedido;
	}

	public void setPrecio_pedido(int precio_pedido) {
		this.precio_pedido = precio_pedido;
	}
	
}
