package guinness;

public enum RecordType {

	TIME("s"), QUANTITY("quantity unit");

	private final String type;
	RecordType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
