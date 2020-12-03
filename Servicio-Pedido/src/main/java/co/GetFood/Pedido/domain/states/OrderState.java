package co.GetFood.Pedido.domain.states;

import co.GetFood.Pedido.domain.entity.Item;
import co.GetFood.Pedido.domain.entity.Pedido;

public abstract class OrderState {
	
	private Pedido order;
	
	public OrderState(Pedido order) {
		super();
		this.order = order;
	}

	/**
     * @return order
     */
    public Pedido getOrder() {
        return order;
    }
    
	public abstract String getStateDescription();
	
	 
	
    public OrderState orderSendOut() {
        throw new IllegalStateException("No se puede enviar la orden cuando la orden está en fase " + getStateDescription());
    }

    public OrderState orderDelivered() {
        throw new IllegalStateException("No se puede entregar una orden cuando la orden está en fase " + getStateDescription());
    }
    
    public void PublicFinishedOrder() {
    	throw new IllegalStateException("No se puede publicar una orden finalizada cuando la orden está en fase " + getStateDescription());
    }
}
