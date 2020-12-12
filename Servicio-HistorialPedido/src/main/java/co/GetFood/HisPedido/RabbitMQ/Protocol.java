package co.GetFood.HisPedido.RabbitMQ;

public class Protocol {
	private String action;
	private String message;
	
	public Protocol(String action, String message) {
		this.action=action;
		this.message=message;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}