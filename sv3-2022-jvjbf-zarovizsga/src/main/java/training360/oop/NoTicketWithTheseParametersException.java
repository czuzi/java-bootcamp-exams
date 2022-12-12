package training360.oop;

public class NoTicketWithTheseParametersException extends RuntimeException {

	public NoTicketWithTheseParametersException(String message) {
		super(message);
	}

	public NoTicketWithTheseParametersException(String message, Throwable cause) {
		super(message, cause);
	}
}
