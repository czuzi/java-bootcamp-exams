package training360.oop;

import java.text.DecimalFormat;

public interface Ticket {

	DecimalFormat df = new DecimalFormat("#.#");
	BasicTicket getBasicTicket();
	double getPrice();
}
