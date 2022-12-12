package training360.datahandling;

import java.time.LocalDate;

public class Animal {

	private Long id;
	private String animalType;
	private int count;
	private LocalDate date;

	public Animal(String animalType, int count, LocalDate date) {
		this.animalType = animalType;
		this.count = count;
		this.date = date;
	}

	public Animal(Long id, String animalType, int count, LocalDate date) {
		this.id = id;
		this.animalType = animalType;
		this.count = count;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public String getAnimalType() {
		return animalType;
	}

	public int getCount() {
		return count;
	}

	public LocalDate getDate() {
		return date;
	}
}
