package co.GetFood.Pedido.RabbitMQ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import co.GetFood.Pedido.domain.entity.Pedido;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class OrderPublisher {
	
	/**
	 * Establecimiento de los atributos que utilizan los nombres de la cola y la ruta a utilizar.
	 */
	private final String QUEUE_NAME = "HisPedido_Queue";
	private final String PATH_PEDIDO = "localhost";
	
	/**
	 * Logica de publicación a la cola de HisPedidos
	 * @param message, mensaje enviado
	 * @throws IOException
	 * @throws TimeoutException
	 */
	private void publicarEnCola(String message) throws IOException, TimeoutException  {
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(PATH_PEDIDO);
        try (Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            	channel.queueDeclare(QUEUE_NAME, true, false, false, null);
	            channel.basicPublish("", QUEUE_NAME,MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("UTF-8"));
	            System.out.println(" [x] Pedido Publicado en la Cola "+ QUEUE_NAME);
        }
	}
	
	private String toJson(Object objeto) {
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(objeto);
	}
	
	public void publicar(Pedido pedido) throws IOException, TimeoutException {
		String message = toJson(pedido);
		Protocol proto = new Protocol("create",message);
		publicarEnCola(toJson(proto));
	}
}