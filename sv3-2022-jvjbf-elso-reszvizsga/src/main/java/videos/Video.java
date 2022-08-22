package videos;

import java.time.LocalDate;

public class Video {

	private String title;
	private LocalDate uploadTime;
	private int length;
	private Type type;
	private int views;

	public Video(String title, LocalDate uploadDate, int videoLength, Type videoType) {
		this.title = title;
		this.uploadTime = uploadDate;
		this.length = videoLength;
		this.type = videoType;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getUploadTime() {
		return uploadTime;
	}

	public int getLength() {
		return length;
	}

	public Type getType() {
		return type;
	}

	public int getViews() {
		return views;
	}

	public void watchVideo() {
		views++;
	}
}
