package co.GetFood.Pedido.domain.states;

import co.GetFood.Pedido.domain.entity.Pedido;

public class DeliveredState extends OrderState {

	public DeliveredState(Pedido order) {
		super(order);
	}

	@Override
	public String getStateDescription() {
		return "Finalizada";
	}
    
}
