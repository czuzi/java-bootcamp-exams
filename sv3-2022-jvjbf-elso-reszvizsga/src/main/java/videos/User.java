package videos;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String userName;
	private List<Video> videos = new ArrayList<>();

	public User(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void uploadVideo(Video video) {
		videos.add(video);
	}

	public int countVideosByType(Type type) {
		int count = 0;
		for (Video video : videos) {
			if (video.getType() == type) {
				count++;
			}
		}
		return count;
	}

	public int sumOfViews() {
		int count = 0;
		for (Video video : videos) {
			count += video.getViews();
		}
		return count;
	}
}
