package co.GetFood.HisPedido;

import java.util.Queue;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServicioHistorialPedidoApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServicioHistorialPedidoApplication.class, args);
	}

}
