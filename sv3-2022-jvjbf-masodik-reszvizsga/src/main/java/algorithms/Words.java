package algorithms;

import java.util.List;

public class Words {

	public int countWordsStartsWithUpperCase(List<String> words) {
		int count = 0;
		for (String word: words) {
			String actual = Character.toString(word.charAt(0));
			if (actual.equals(actual.toUpperCase())) {
				count++;
			}
		}
		return count;
	}
}
