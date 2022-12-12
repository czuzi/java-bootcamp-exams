package training360.oop;

import java.time.LocalDateTime;

public class BasicTicket {

	private String event;
	private LocalDateTime date;
	private int price;

	public BasicTicket(String event, LocalDateTime date, int price) {
		this.event = event;
		this.date = date;
		this.price = price;
	}

	public String getEvent() {
		return event;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public int getPrice() {
		return price;
	}
}
