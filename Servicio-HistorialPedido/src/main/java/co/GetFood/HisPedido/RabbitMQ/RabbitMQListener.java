package co.GetFood.HisPedido.RabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import com.google.gson.Gson;

public class RabbitMQListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		Gson gson = new Gson();
		System.out.println("[CONSUMIDOR] accion: " + gson.fromJson(message.getBody().toString(), Protocol.class).getAction());
		System.out.println("[CONSUMIDOR] mensaje: " + gson.fromJson(message.getBody().toString(), Protocol.class).getMessage());
	}
}
