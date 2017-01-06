package wuxc.wisdomparty.Model;

public class StudyArticleModel {
	private String BackGround;
	private String Title;
	private String Detail;
	private String Time;

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}

	public String getBackGround() {
		return BackGround;
	}

	public void setBackGround(String imageUrl) {
		BackGround = imageUrl;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String name) {
		Title = name;
	}
}
