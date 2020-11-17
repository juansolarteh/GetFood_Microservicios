package co.GetFood.Pedido.domain.service;

import co.GetFood.Pedido.domain.entity.EntityPedido;
import co.GetFood.Pedido.domain.entity.Item;
import co.GetFood.Pedido.domain.entity.Pedido;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;

public class PedidoBuilderCrear extends PedidoBuilder {
	
	public PedidoBuilderCrear(Pedido pedido) {
		super(pedido);
	}

	@Override
	public PedidoBuilder generatePedido() throws PedidoDomainException {
		EntityPedido Spedido = new EntityPedido(pedido.getId_pedido(),pedido.getId_rest(),pedido.getNombre_restaurante(),pedido.getId_cliente(),pedido.getDireccion_pedido(), pedido.getTelefono_pedido(), pedido.getPrecio_pedido());
		servicioPedido.create(Spedido);
		return this;
	}

	@Override
	public PedidoBuilder addItem() throws PedidoDomainException {
		for(Item i: pedido.getItems())
		{
			servicioItem.create(i);
		}
		
		return this;
	}
}
