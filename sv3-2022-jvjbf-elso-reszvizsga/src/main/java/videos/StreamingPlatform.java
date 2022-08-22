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
		int max = users.get(0).sumOfViews();
		for (int i = 1; i < users.size(); i++) {
			if (users.get(i).sumOfViews() > users.get(i-1).sumOfViews()){
				max = users.get(i).sumOfViews();
			}
		}
		return max;
	}
}
