package files;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IncomeManager {

	private List<Income> incomes = new ArrayList<>();

	public List<Income> getIncomes() {
		return incomes;
	}


	public void readIncomesFromFile(Path path) {
		try {
			readFile(path);
		} catch (IOException ioe) {
			throw new IllegalArgumentException("Cannot read file!", ioe);
		}
	}

	private void readFile(Path path) throws IOException {
		Scanner sc = new Scanner(path);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			processLines(line);
		}
	}

	private void processLines(String line) {
		LocalDate actualDate = LocalDate.parse(line.split(";")[0]);
		int actualAmount = Integer.parseInt(line.split(";")[1]);
		fillList(actualDate, actualAmount);
	}

	private void fillList(LocalDate actualDate, int actualAmount) {
		validate(actualDate);
		incomes.add(new Income(actualDate, actualAmount));
	}

	private void validate(LocalDate actualDate) {
		if (incomes.size() > 0 && incomes.get(incomes.size()-1).getDate().isAfter(actualDate)) {
			throw new IllegalArgumentException("Income date is not valid: " + actualDate);
		}
	}
}
