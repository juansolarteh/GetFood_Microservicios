package co.GetFood.HisPedido.RabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import com.google.gson.Gson;

public class RabbitMQListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		Gson gson = new Gson();
		Protocol proto = gson.fromJson(new String (message.getBody()),Protocol.class);
		/*
		 * System.out.println("[CONSUMIDOR] accion: " + proto.getAction()) ;
		 * System.out.println("[CONSUMIDOR] mensaje: " + proto.getMessage());
		 */
		System.out.println(new String(message.getBody()));
	}
}
