package co.GetFood.Pedido.domain.states;

import co.GetFood.Pedido.domain.entity.Item;
import co.GetFood.Pedido.domain.entity.Pedido;

public class OpenState extends OrderState{

	public OpenState(Pedido order) {
		super(order);
	}

	@Override
	public String getStateDescription() {
		return "Abierta";
	}
	
	@Override
	public OrderState orderedPayed() {
		return new PayedState(getOrder());
	}
	
}
