package co.GetFood.HisPedido.RabbitMQ;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

@Configuration
public class RabbitMQConfig {
	
	@Value("${RabbitMQ.rabbitmq.queue}")
	String queueName;
	
	@Value("${spring.rabbitmq.username}")
	String userName;
	
	@Value("${spring.rabbitmq.password}")
	private String password;
	
	@Bean
	Queue queue() {
		return new Queue(queueName,false);
	}
	
	@Bean
	MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setQueues(queue());
		simpleMessageListenerContainer.setMessageListener(new RabbitMQListener());
		return simpleMessageListenerContainer;
	}

	@Bean
	CachingConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername("GetFood");
		cachingConnectionFactory.setPassword("GetFood");
		return cachingConnectionFactory;
	}
	
	@Bean
	MessageListenerContainer messageListenerContainer(){
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setQueues(queue());
		simpleMessageListenerContainer.setMessageListener(new RabbitMQListener());
		return simpleMessageListenerContainer;
	}
}
