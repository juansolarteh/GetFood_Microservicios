package co.GetFood.Pedido.RabbitMQ;

public class Protocol {
	public String action;
	public String message;
	
	public Protocol(String action, String message) {
		this.action=action;
		this.message=message;
	}
	
}