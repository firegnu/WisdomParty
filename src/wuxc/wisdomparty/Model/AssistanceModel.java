package wuxc.wisdomparty.Model;

public class AssistanceModel {
	private String BackGround;

	private String Number;
	private String Title;
	private String Detail;
	private String Aim;

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}

	public String getAim() {
		return Aim;
	}

	public void setAim(String aim) {
		Aim = aim;
	}

	public String getBackGround() {
		return BackGround;
	}

	public void setBackGround(String imageUrl) {
		BackGround = imageUrl;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String name) {
		Title = name;
	}
}
