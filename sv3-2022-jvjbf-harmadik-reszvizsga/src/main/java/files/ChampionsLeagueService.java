package files;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ChampionsLeagueService {

	private Map<String, List<LocalDate>> schedule = new TreeMap<>();

	public Map<String, List<LocalDate>> getSchedule() {
		return schedule;
	}

	public void readFromFile(Path path) {
		try (Scanner sc = new Scanner(path)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				processLines(line);
			}
		} catch (IOException ioe) {
			throw new IllegalStateException("Cannot read the file", ioe);
		}
	}

	private void processLines(String line) {
		String[] temp = line.split(";");
		LocalDate date = LocalDate.parse(temp[0]);
		String[] teams = temp[1].split("-");
		fillMap(date, teams);
	}

	private void fillMap(LocalDate date, String[] teams) {
		for (String team: teams) {
			if (!schedule.containsKey(team)) {
				schedule.put(team, new ArrayList<>());
				schedule.get(team).add(date);
			} else {
				schedule.get(team).add(date);
			}
	   }
	}

	public Set<LocalDate> collectPlayDays() {
		Set<LocalDate> result = new HashSet<>();
		for (List<LocalDate> dates: schedule.values()) {
			result.addAll(dates);
		}
		return result;
	}

	public Set<String> findTeamsByDay(LocalDate date) {
		return schedule.entrySet().stream()
				.filter(e -> e.getValue().contains(date))
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
	}

	public String findTeamWithMostPlayedMatches() {
		return schedule.entrySet().stream()
				.max(Comparator.comparing(o -> o.getValue().size()))
				.orElseThrow(IllegalStateException::new)
				.getKey();
	}
}
