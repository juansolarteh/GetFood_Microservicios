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
	
	public OrderState openOrder() {
		throw new IllegalStateException("No se puede abrir la orden cuando la orden está  " + getStateDescription());	    
	}

    public OrderState orderedPayed(){
        throw new IllegalStateException("No se puede pagar la orden cuando la orden está " + getStateDescription());
    }

    public OrderState orderSendOut(String parcelNumber) {
        throw new IllegalStateException("No se puede enviar la orden cuando la orden está " + getStateDescription());
    }

    public OrderState orderDelivered() {
        throw new IllegalStateException("No se puede ordenar una orden cuando la orden está " + getStateDescription());
    }
    
    public boolean isFinished() {
        return false;
    }
}
