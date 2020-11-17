package co.GetFood.Pedido.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import co.GetFood.Item.domain.service.IItemService;
import co.GetFood.Pedido.domain.entity.Pedido;
import co.GetFood.Pedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.Pedido.presentation.rest.exceptions.ResourceNotFoundException;

public abstract class PedidoBuilder {
	
	protected Pedido pedido;
	
	public PedidoBuilder(Pedido pedido) {
		this.pedido = pedido;
	}

	@Autowired
	protected IPedidoService servicioPedido;
	
	@Autowired
	protected IItemService servicioItem;
	
	public Pedido getPedido() {
		return pedido;
	}
	

	public abstract PedidoBuilder generatePedido() throws PedidoDomainException, ResourceNotFoundException ;
	
	public abstract PedidoBuilder addItem() throws PedidoDomainException, ResourceNotFoundException;
	
	/*
	private void checkItems() {
		
	}*/
}
