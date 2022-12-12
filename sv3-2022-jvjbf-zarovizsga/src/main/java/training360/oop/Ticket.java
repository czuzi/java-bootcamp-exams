package training360.oop;

import java.text.DecimalFormat;

public interface Ticket {

	public static final DecimalFormat df = new DecimalFormat("#.#");
	BasicTicket getBasicTicket();
	double getPrice();
}
