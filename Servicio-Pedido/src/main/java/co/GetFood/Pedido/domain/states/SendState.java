package co.GetFood.Pedido.domain.states;

import co.GetFood.Pedido.domain.entity.Pedido;

public class SendState extends OrderState{

	public SendState(Pedido order) {
		super(order);
	}

	@Override
	public String getStateDescription() {
		return "Enviada";
	}

	@Override
    public OrderState orderDelivered() {
        return new DeliveredState(getOrder());
    }
}
