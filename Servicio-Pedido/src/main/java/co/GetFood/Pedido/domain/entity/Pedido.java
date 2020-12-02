package co.GetFood.Pedido.domain.entity;

import co.GetFood.Pedido.domain.states.OpenState;
import co.GetFood.Pedido.domain.states.OrderState;
import co.GetFood.Pedido.domain.states.PayedState;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Representa un pedido de un respectivo restaurante. Mapeado con la BD.
 * 
 * @author Juan Pablo Solarte, Jorge Ivan Solano, Jefferson Campo
 *
 */
@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable{
	
	@Transient
	private OrderState orderState;
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private long id_restaurante;
	
	@Column
	private long id_cliente;
	
	@Column
	private String nombre_restaurante;
	
	@Column
	private String direccion_pedido;
	
	@Column
	private int telefono_pedido;
	
	@Column
	private int valor_pedido;
	
	@Column
	private String state;
	
	public String whatIsTheState() {
	    return orderState.getStateDescription();
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
	@JoinColumn(name="id_pedido", referencedColumnName = "id")
	private List<Item> items = new ArrayList<Item>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_restaurante() {
		return id_restaurante;
	}

	public void setId_restaurante(long id_restaurante) {
		this.id_restaurante = id_restaurante;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre_restaurante() {
		return nombre_restaurante;
	}

	public void setNombre_restaurante(String nombre_restaurante) {
		this.nombre_restaurante = nombre_restaurante;
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

	public int getValor_pedido() {
		return valor_pedido;
	}

	public void setValor_pedido(int valor_pedido) {
		this.valor_pedido = valor_pedido;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> ietms) {
		this.items = ietms;
	}
	
	public boolean isEmpty(Pedido order) {
		return order.getItems().isEmpty();
	}
	    
	public void orderDelivered() {
       orderState = orderState.orderDelivered();
    }
	    
	public void orderSendOut(String parcelNumber) {
	   orderState = orderState.orderSendOut(parcelNumber);
	}

    public boolean isFinished() {
	   return orderState.isFinished();
	}
	    
    public void orderedPayed(){
	   orderState = orderState.orderedPayed();
	}
		
	public void IniciarPedido() {
	  orderState = new OpenState(this);
	  setState(orderState.getClass().getSimpleName());
	}
}
