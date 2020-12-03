package co.GetFood.Pedido.domain.states;

import co.GetFood.Pedido.domain.entity.Pedido;

public class NotPayedState extends OrderState{

	public NotPayedState(Pedido order) {
		super(order);
	}

	@Override
	public String getStateDescription() {
		return "Pedido no pago";
	}
	
	@Override
	public OrderState orderSendOut() {
		return new SendNotPayState(getOrder());
	}
	
}
