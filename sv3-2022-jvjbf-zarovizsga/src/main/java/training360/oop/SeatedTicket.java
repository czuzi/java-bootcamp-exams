package training360.oop;

import java.util.Objects;

public class SeatedTicket implements Ticket {

	private BasicTicket basicTicket;
	private int row;
	private int seat;

	public SeatedTicket(BasicTicket basicTicket, int row, int seat) {
		this.basicTicket = basicTicket;
		this.row = row;
		this.seat = seat;
	}

	public int getRow() {
		return row;
	}

	public int getSeat() {
		return seat;
	}

	@Override
	public BasicTicket getBasicTicket() {
		return basicTicket;
	}

	@Override
	public double getPrice() {
		int percentageCounter = 0;
		for (int i = 10; i <= row; i += 10) {
			percentageCounter += 10;
		}
		double price = basicTicket.getPrice() * (1 - percentageCounter / 100.0);
		if (price < 2000) {
			return 2000.0;
		}
		return price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SeatedTicket that = (SeatedTicket) o;
		return row == that.row && seat == that.seat && Objects.equals(basicTicket, that.basicTicket);
	}

	@Override
	public int hashCode() {
		return Objects.hash(basicTicket, row, seat);
	}
}
