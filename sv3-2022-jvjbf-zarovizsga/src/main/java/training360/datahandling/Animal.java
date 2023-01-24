package training360.datahandling;

import java.time.LocalDate;

public class Animal {

	private Long id;
	private String animalType;
	private int countOfAnimal;
	private LocalDate dateOfObservation;

	public Animal(String animalType, int countOfAnimal, LocalDate dateOfObservation) {
		this.animalType = animalType;
		this.countOfAnimal = countOfAnimal;
		this.dateOfObservation = dateOfObservation;
	}

	public Animal(Long id, String animalType, int countOfAnimal, LocalDate dateOfObservation) {
		this.id = id;
		this.animalType = animalType;
		this.countOfAnimal = countOfAnimal;
		this.dateOfObservation = dateOfObservation;
	}

	public Long getId() {
		return id;
	}

	public String getAnimalType() {
		return animalType;
	}

	public int getCountOfAnimal() {
		return countOfAnimal;
	}

	public LocalDate getDateOfObservation() {
		return dateOfObservation;
	}
}
