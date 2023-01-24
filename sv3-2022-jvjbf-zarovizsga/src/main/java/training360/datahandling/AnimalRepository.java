package training360.datahandling;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

public class AnimalRepository {

	JdbcTemplate jdbcTemplate;

	public AnimalRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void saveAnimal(Animal animal) {
		jdbcTemplate.update("insert into animals (animal_type, animal_count, observation_date) values (?, ?, ?)",
				animal.getAnimalType(), animal.getCountOfAnimal(), Date.valueOf(animal.getDateOfObservation()));
	}

	public List<Animal> findAllAnimals() {
		return jdbcTemplate.query("select * from animals",
				(rs, rowNum) -> new Animal(
						rs.getLong("id"),
						rs.getString("animal_type"),
						rs.getInt("animal_count"),
						rs.getDate("observation_date").toLocalDate()
				));
	}

	public Integer countAllByAnimalType(String animalType) {
		Integer result;
		result = jdbcTemplate.queryForObject("select sum(animal_count) as animal_sum from animals where animal_type = ?;",
				(rs, rowNum) -> rs.getInt("animal_sum"), animalType);
		if (result == null) {
			throw new IllegalArgumentException("No animal found!");
		}
		return result;
	}
}
