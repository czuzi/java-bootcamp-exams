package training360.datahandling;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AnimalService {

	AnimalRepository animalRepository;

	public AnimalService(AnimalRepository animalRepository) {
		this.animalRepository = animalRepository;
	}

	public void saveAnimals(Path path) {
		try (Scanner sc = new Scanner(path)) {
			sc.nextLine();
			while (sc.hasNextLine()) {
				processLines(sc);
			}
		}
		catch (IOException ioe) {
			throw new IllegalStateException("Cannot reach file!");
		}
	}

	private void processLines(Scanner sc) {
		String[] splitted = sc.nextLine().split(";");
		Animal animal = new Animal(splitted[0], Integer.parseInt(splitted[1]), LocalDate.parse(splitted[2]));
		animalRepository.saveAnimal(animal);
	}

	public List<Animal> findAllAnimals() {
		return animalRepository.findAllAnimals();
	}

	public int countAllByAnimalType(String animalType) {
		return animalRepository.countAllByAnimalType(animalType);
	}
}
