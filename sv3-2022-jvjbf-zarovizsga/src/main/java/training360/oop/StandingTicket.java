package training360.oop;

public class StandingTicket implements Ticket {

	private BasicTicket basicTicket;
	private StandingTicketType ticketType;
	private int percentage = 0;

	public StandingTicket(BasicTicket basicTicket, StandingTicketType ticketType) {
		this.basicTicket = basicTicket;
		this.ticketType = ticketType;
		if (ticketType == StandingTicketType.FRONT_OF_STAGE) {
			percentage = 20;
		}
	}

	public StandingTicketType getTicketType() {
		return ticketType;
	}

	public int getPercentage() {
		return percentage;
	}

	@Override
	public BasicTicket getBasicTicket() {
		return basicTicket;
	}

	@Override
	public double getPrice() {
		double price = basicTicket.getPrice() * (1 + percentage / 100.0);
		return round(price, 1);
	}

	private static double round (double value, int precision) {
		int scale = (int) Math.pow(10, precision);
		return (double) Math.round(value * scale) / scale;
	}
}
