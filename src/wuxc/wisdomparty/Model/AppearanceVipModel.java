package wuxc.wisdomparty.Model;

public class AppearanceVipModel {
	private String ImageUrl;
	private int Width;
	private int height;
	private String Title;
	private String Department;
	private String Collect;
	private String Great;
	private boolean IsCollect;
	private boolean IsGreat;

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public int getWidth() {
		return Width;
	}

	public void setWidth(int width) {
		Width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getCollect() {
		return Collect;
	}

	public void setCollect(String collect) {
		Collect = collect;
	}

	public String getGreat() {
		return Great;
	}

	public void setGreat(String great) {
		Great = great;
	}

	public boolean isIsCollect() {
		return IsCollect;
	}

	public void setIsCollect(boolean isCollect) {
		IsCollect = isCollect;
	}

	public boolean isIsGreat() {
		return IsGreat;
	}

	public void setIsGreat(boolean isGreat) {
		IsGreat = isGreat;
	}

}
