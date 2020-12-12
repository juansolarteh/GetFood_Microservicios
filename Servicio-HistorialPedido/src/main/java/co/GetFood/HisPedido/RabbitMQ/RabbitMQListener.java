package co.GetFood.HisPedido.RabbitMQ;

import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import co.GetFood.HisPedido.domain.entity.Pedido;
import co.GetFood.HisPedido.domain.service.IHistorialPedidoService;
import co.GetFood.HisPedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.HisPedido.presentation.rest.exceptions.ResourceNotFoundException;

public class RabbitMQListener implements MessageListener{
	
	@Autowired
	private IHistorialPedidoService historialPedidoService;

	@Override
	public void onMessage(Message message) {
		
		System.out.println("[ListenerHistorialPedido] Mensaje recibido");
		try {
			processRequest(new String(message.getBody()));
		} catch (JsonSyntaxException | PedidoDomainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processRequest(String requestJson) throws JsonSyntaxException, PedidoDomainException, ResourceNotFoundException {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getAction()) {
            case "create":
            	// Agregar un pedido al historial
            	processCreateOrderHistory(protocolRequest);
                break;
            case "getByIdRest":
            	// Obtener pedidos historial de cierto restaurante
            	processGetOrderHistoryByIdRest(protocolRequest);
                break;
        }
    }
	
	private void processCreateOrderHistory(Protocol protocol) throws JsonSyntaxException, PedidoDomainException{
		historialPedidoService.create(new Gson().fromJson(protocol.getMessage(), Pedido.class));
    }
	
	private void processGetOrderHistoryByIdRest(Protocol protocol) throws JsonSyntaxException, ResourceNotFoundException{
    	List<Pedido> pedidos = historialPedidoService.findByIdRest(new Gson().fromJson(protocol.getMessage(), Long.class));
    	System.out.println(new Gson().toJson(pedidos));
    	//Toca quitar esta impresion
    	//opcion 1. publicar la lista de pedidos en otra cola para que el cliente obtenga la lista de pedidos de dicha cola y mostrarla
    	//opcion 2.publicar en la misma cola, pero tocaria aumentar logica en el proccessrequest y preguntar el artefacto 
    	//         que envio el mensaje, si el artefacto es "clientePublicador", pasa a procesar la peticion y envia la respuesta(lista pedidos)
    	//         con artefacto "historialPublicador"; si el artefacto es HistorialPublicador no hace nada en el backend,
    	//         pero el forntend si sabria que es una respuesta del artefacto "historialPublicador" y mostraria los pedidos,
    	//         pero entonces tocaria añadirle el atributo "artefacto" al protocolo
    	//
    	//La opcion 1 es mas sencilla, pero la opcion dos parece mejor para no tener que crear mas colas y solo trabajar con una.
    }
}
