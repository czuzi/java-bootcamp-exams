package videos;

import java.util.ArrayList;
import java.util.List;

public class StreamingPlatform {
	private List<User> users = new ArrayList<>();

	public List<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		users.add(user);
	}

	public int findMaxViews() {
		if (users.isEmpty()) {
			return 0;
		}
		int max = users.get(0).sumOfViews();
		for (User user : users) {
			if (user.sumOfViews() > max) {
				max = user.sumOfViews();
			}
		}
		return max;
	}
}
