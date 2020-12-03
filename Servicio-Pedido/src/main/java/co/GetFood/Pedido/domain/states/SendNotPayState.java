package co.GetFood.Pedido.domain.states;

import co.GetFood.Pedido.domain.entity.Pedido;
	
public class SendNotPayState extends OrderState{

	public SendNotPayState(Pedido order) {
		super(order);
	}

	@Override
	public String getStateDescription() {
		return "Enviado sin pagar";
	}

	@Override
    public OrderState orderDelivered() {
        return new DeliveredState(getOrder());
    }
}
