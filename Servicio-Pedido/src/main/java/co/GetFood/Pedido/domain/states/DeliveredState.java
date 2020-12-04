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
    
    @Override
    public void PublicFinishedOrder() {
        //logica de publicación a cola de eventos. despues de esto
    }
}
