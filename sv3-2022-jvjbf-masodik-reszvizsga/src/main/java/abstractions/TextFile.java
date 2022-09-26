package abstractions;

import java.util.ArrayList;
import java.util.List;

public class TextFile implements File {

	private String title;
	private List<String> lines = new ArrayList<>();

	public TextFile(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getLines() {
		return lines;
	}

	@Override
	public String getFullName() {
		return title + "." + "txt";
	}

	@Override
	public double calculateSize() {
		return KB_TO_MB * lines.size();
	}

	public void addLine(String line) {
		lines.add(line);
	}
}
