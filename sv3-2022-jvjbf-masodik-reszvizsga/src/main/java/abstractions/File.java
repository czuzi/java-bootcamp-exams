package abstractions;

public interface File {

	double KB_TO_MB = 0.001;

	String getFullName();

	double calculateSize();
}
