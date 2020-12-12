package co.GetFood.Pedido.domain.states;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import co.GetFood.Pedido.RabbitMQ.OrderPublisher;
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
    public OrderState orderDelivered() throws IOException, TimeoutException {
		OrderPublisher op = new OrderPublisher();
		op.publicar(getOrder());
        return new DeliveredState(getOrder());
    }
}
