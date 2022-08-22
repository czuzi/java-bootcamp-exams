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
}
