package training360.algorithms;

import java.util.List;

public class Algorithms {


	public boolean isChainOfWords(List<String> words) {
		for (int i = 0; i < words.size() - 1; i++) {
			if (words.get(i).toLowerCase().charAt(words.get(i).length() - 1) != words.get(i + 1).toLowerCase().charAt(0)) {
				return false;
			}
		}
		return true;
	}
}
