package wuxc.wisdomparty.Model;

public class CommentModel {
	private String RoundUrl;
	private String Name;
	private String Comment;
	private String Time;

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public String getRoundUrl() {
		return RoundUrl;
	}

	public void setRoundUrl(String roundUrl) {
		RoundUrl = roundUrl;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}
}
