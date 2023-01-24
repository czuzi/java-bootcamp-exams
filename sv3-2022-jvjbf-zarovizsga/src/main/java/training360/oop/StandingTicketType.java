package training360.oop;

public enum StandingTicketType {

	FRONT_OF_STAGE(20), NORMAL(0);

	private int percentage;

	StandingTicketType(int percentage) {
		this.percentage = percentage;
	}

	public int getPercentage() {
		return percentage;
	}
}
