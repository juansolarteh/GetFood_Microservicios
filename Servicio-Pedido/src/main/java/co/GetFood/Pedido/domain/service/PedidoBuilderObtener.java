package co.GetFood.Pedido.domain.service;

import java.util.ArrayList;
import java.util.List;

import co.GetFood.Pedido.domain.entity.EntityPedido;
import co.GetFood.Pedido.domain.entity.Item;
import co.GetFood.Pedido.domain.entity.Pedido;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.Pedido.presentation.rest.exceptions.ResourceNotFoundException;

public class PedidoBuilderObtener extends PedidoBuilder {
	
	List<Pedido> pedidos;
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public PedidoBuilderObtener(Pedido pedido) {
		super(pedido);
	}

	@Override
	public PedidoBuilder generatePedido() throws PedidoDomainException, ResourceNotFoundException {
		pedidos = servicioPedido.findByIdRest(pedido.getId_rest());
		return this;
	}

	@Override
	public PedidoBuilder addItem() throws PedidoDomainException, ResourceNotFoundException {
		for(Pedido ped : pedidos)
		{
			ped.setItems((ArrayList<Item>)servicioItem.findByIdPedido(ped.getId_pedido()));
		}
		return this;
	}
}
