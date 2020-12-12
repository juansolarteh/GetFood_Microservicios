package co.GetFood.Pedido.domain.entity;

import co.GetFood.Pedido.domain.states.NotPayedState;
import co.GetFood.Pedido.domain.states.OrderState;
import co.GetFood.Pedido.domain.states.PayedState;
import co.GetFood.Pedido.domain.states.SendNotPayState;
import co.GetFood.Pedido.domain.states.SendState;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

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

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

import com.sun.tools.javac.Main;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
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

	@Expose
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Expose
	@Column
	private long id_restaurante;
	
	@Expose
	@Column
	private long id_cliente;
	
	@Expose
	@Column
	private String nombre_restaurante;
	
	@Expose
	@Column
	private String direccion_pedido;
	
	@Expose
	@Column
	private int telefono_pedido;
	
	@Expose
	@Column
	private int valor_pedido;
	
	@Column
	private String state;
	
	@Expose
	@OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
	@JoinColumn(name="id_pedido", referencedColumnName = "id")
	private List<Item> items = new ArrayList<Item>();
	
	
	public String whatIsTheState() {
	    return orderState.getStateDescription();
	}
	
	public void adjustOrderState() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		Constructor<?> cons = Class.forName("co.GetFood.Pedido.domain.states."+state).getDeclaredConstructor(this.getClass());
		cons.setAccessible(true);
		orderState = (OrderState) cons.newInstance(new Object[] {this});
		
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
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
	    
	public void deliverOrder() throws IOException, TimeoutException {
       orderState = orderState.orderDelivered();
       setState(orderState.getClass().getSimpleName());
    }
	    
	public void orderNotPaySendOut() {
		   orderState = orderState.orderSendOut();
		   setState(orderState.getClass().getSimpleName());
	}
	
	public void orderSendOut() {
	   orderState =  orderState.orderSendOut();
	   setState(orderState.getClass().getSimpleName());
	}

	public void IniciarPedidoNoPago() {
	  orderState = new NotPayedState(this);
	  setState(orderState.getClass().getSimpleName());
	}
	
	public void IniciarPedidoPago() {
		  orderState = new PayedState(this);
		  setState(orderState.getClass().getSimpleName());
	}
	
}
