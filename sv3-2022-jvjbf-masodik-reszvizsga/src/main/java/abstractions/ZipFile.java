package abstractions;

import java.util.List;

public class ZipFile implements File {

	private String title;
	private List<File> files;

	public ZipFile(String title, List<File> files) {
		this.title = title;
		this.files = files;
	}

	public String getTitle() {
		return title;
	}

	public List<File> getFiles() {
		return files;
	}

	@Override
	public String getFullName() {
		return title + "." + "zip";
	}

	@Override
	public double calculateSize() {
		double sum = 0.0;
		for (File file: files) {
			sum += file.calculateSize() * 0.2;
		}
		return sum;
	}

	public File findBiggestFile() {
		if (files.isEmpty()) {
			throw new IllegalStateException("Zip is empty!");
		}
		File largest = null;
		for (File file: files) {
			if (largest == null || largest.calculateSize() < file.calculateSize()) {
				largest = file;
			}
		}
		return largest;
	}
}
