package co.GetFood.Pedido.domain.states;

import co.GetFood.Pedido.domain.entity.Pedido;

public class PayedState extends OrderState{

	public PayedState(Pedido order) {
		super(order);
	}
	
	/**
     * Descripción del estado
     * 
     * @return estado
     */
    @Override
    public String getStateDescription() {
        return "Pagada";
    }
    
    /**
     * Metodo que enlaza la secuencia segun las reglas de negocio
     * 
     * @param parcelNumber
     * @return 
     */
    @Override
    public OrderState orderSendOut() {
        return new SendState(getOrder());
    }
}
