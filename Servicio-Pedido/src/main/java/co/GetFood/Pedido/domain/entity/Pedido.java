package co.GetFood.Pedido.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido extends EntityPedido implements Serializable{
	
	
	public Pedido(Long id_pedido, Long id_rest, String nombre_restaurante, Long id_cliente, String direccion_pedido,
			int telefono_pedido, int precio_pedido) {
		super(id_pedido, id_rest, nombre_restaurante, id_cliente, direccion_pedido, telefono_pedido, precio_pedido);
	}
	
	public Pedido(Long id_rest) {
		super(id_rest);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Item> items;
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
}
