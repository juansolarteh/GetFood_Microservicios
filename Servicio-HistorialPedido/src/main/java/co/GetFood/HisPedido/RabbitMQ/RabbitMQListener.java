package co.GetFood.HisPedido.RabbitMQ;

import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import co.GetFood.HisPedido.presentation.rest.exceptions.PedidoDomainException;
import co.GetFood.HisPedido.presentation.rest.exceptions.ResourceNotFoundException;

public class RabbitMQListener implements MessageListener{
	

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
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processRequest(String requestJson) throws JsonSyntaxException, PedidoDomainException, ResourceNotFoundException, IOException {
        // Convertir la solicitud a objeto Protocol para poderlo procesar
        Gson gson = new Gson();
        Protocol protocolRequest = gson.fromJson(requestJson, Protocol.class);

        switch (protocolRequest.getAction()) {
            case "create":
            	// Agregar un pedido al historial
            	processCreateOrderHistory(protocolRequest);
                break;
        }
    }
	
	
	private void processCreateOrderHistory(Protocol protocol) throws JsonSyntaxException, PedidoDomainException, IOException{
		BufferedReader rd = null;
		String workURL= "http://localhost:8011/historial";
		URL url = new URL(workURL);
		
		byte[] dataBytes = protocol.getMessage().getBytes("UTF-8");
		
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("POST");
		conexion.setRequestProperty("Content-Type", "application/json");
		conexion.setDoOutput(true);
		conexion.getOutputStream().write(dataBytes);
		System.out.println("Conexion establecida");
		
		try {
			rd = new BufferedReader(new InputStreamReader(conexion.getInputStream(),"UTF-8"));
			System.out.println("[BufferReader] creado exitosamente");
			rd.close();
			System.out.println("[BufferReader] cerrado exitosamente");
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	
    }


}
