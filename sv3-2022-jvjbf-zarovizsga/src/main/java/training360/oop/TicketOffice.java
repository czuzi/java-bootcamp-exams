package training360.oop;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TicketOffice {

	private Set<Ticket> tickets = new HashSet<>();

	public Set<Ticket> getTickets() {
		return new HashSet<>(tickets);
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public Ticket sellTicket(String event, int maxPrice) {

		Ticket result = tickets.stream()
				.filter(ticket -> ticket.getBasicTicket().getEvent().equals(event) && ticket.getPrice() <= maxPrice)
				.max(Comparator.comparing(Ticket::getPrice))
				.orElseThrow(() -> new NoTicketWithTheseParametersException("No ticket!"));

		tickets.remove(result);
		return result;
	}

	public Map<BasicTicket, Integer> collectTicketCountByEvent() {
		Map<BasicTicket, Integer> result = new HashMap<>();
		for (Ticket ticket: tickets) {
			result.put(ticket.getBasicTicket(), result.getOrDefault(ticket.getBasicTicket(), 0) + 1);
		}
		return result;
	}

	public Set<String> getEventsByDate(LocalDate date) {
		return tickets.stream()
				.map(Ticket::getBasicTicket)
				.filter(basicTicket -> basicTicket.getDate().toLocalDate().equals(date))
				.map(BasicTicket::getEvent)
				.collect(Collectors.toSet());
	}
}
