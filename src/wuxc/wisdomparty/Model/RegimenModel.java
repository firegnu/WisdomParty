package wuxc.wisdomparty.Model;

public class RegimenModel {
	private String ImageUrl;
	private String Title;
	private String Label;
	private boolean collect;
	private boolean great;
	private String Collect;
	private String Great;
	private int Width;
	private int height;

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

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public boolean isCollect() {
		return collect;
	}

	public void setCollect(boolean collect) {
		this.collect = collect;
	}

	public boolean isGreat() {
		return great;
	}

	public void setGreat(boolean great) {
		this.great = great;
	}

}
