package guinness;

import java.util.*;

public class GuinnessRecord {

	private String recordName;
	private RecordType recordType;
	private int bestAttempt;
	private Map<Recorder, List<Integer>> attempts = new HashMap<>();

	private GuinnessRecord(String recordName, RecordType recordType, int bestAttempt) {
		this.recordName = recordName;
		this.recordType = recordType;
		this.bestAttempt = bestAttempt;
	}

	public static GuinnessRecord createGuinnessRecord(String recordName, RecordType recordType) {
		if (recordType == RecordType.QUANTITY) {
			return new GuinnessRecord(recordName, recordType, 0);
		} else {
			return new GuinnessRecord(recordName, recordType, Integer.MAX_VALUE);
		}
	}

	public boolean tryBeatRecord(int amount, Recorder recorder) {
		List<Integer> records = new ArrayList<>();
		boolean result = false;

		addRecord(amount, recorder);
		getRecords(records);

		for (int current: records) {
			if (amount >= current) {
				bestAttempt = amount;
				result = true;
			}
		}
		return result;
	}

	private void getRecords(List<Integer> temp) {
		for (List<Integer> current: attempts.values()) {
			temp.addAll(current);
		}
	}

	private void addRecord(int amount, Recorder recorder) {
		if (!attempts.containsKey(recorder)) {
			attempts.put(recorder, new ArrayList<>());
			attempts.get(recorder).add(amount);
		} else {
			attempts.get(recorder).add(amount);
		}
	}

	public List<String> getOrderedRecorderNames() {
		return attempts.keySet().stream()
				.sorted(Comparator.comparing(Recorder::getName))
				.map(Recorder::getName)
				.toList();
	}

	public Recorder findRecordHolder() {
		return attempts.entrySet().stream()
				.max((o1, o2) -> o1.getValue().stream().max(Integer::compare).get().compareTo(o2.getValue().stream().max(Integer::compare).get()))
				.get().getKey();
	}

	public String getRecordName() {
		return recordName;
	}

	public RecordType getRecordType() {
		return recordType;
	}

	public int getBestAttempt() {
		return bestAttempt;
	}

	public Map<Recorder, List<Integer>> getAttempts() {
		return attempts;
	}

	@Override
	public String toString() {
		return "GuinnessRecord{recordName='" + recordName + "', recordType=" + recordType + ", maxAmount=" + bestAttempt + " " + recordType.getType();
	}
}
