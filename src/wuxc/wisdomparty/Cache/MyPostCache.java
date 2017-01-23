package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;
import wuxc.wisdomparty.layout.RoundedImageView;

public class MyPostCache {

	private View baseView;
	private TextView TextTime;
	private TextView TextName;
	private TextView TextTitle;
	private TextView TextMyReBack;
	private ImageView ImageDelete;
	private RoundedImageView HeadImg;

	public MyPostCache(View baseView) {
		this.baseView = baseView;
	}

	public RoundedImageView getHeadImg() {
		if (HeadImg == null) {
			HeadImg = (RoundedImageView) baseView.findViewById(R.id.rounded_headimg);
		}
		return HeadImg;
	}

	public ImageView getImageDelete() {
		if (ImageDelete == null) {
			ImageDelete = (ImageView) baseView.findViewById(R.id.image_delete);
		}
		return ImageDelete;
	}

	public TextView getTextMyReBack() {
		if (TextMyReBack == null) {
			TextMyReBack = (TextView) baseView.findViewById(R.id.text_myreback);
		}
		return TextMyReBack;
	}

	public TextView getTextTitle() {
		if (TextTitle == null) {
			TextTitle = (TextView) baseView.findViewById(R.id.text_title);
		}
		return TextTitle;
	}

	public TextView getTextName() {
		if (TextName == null) {
			TextName = (TextView) baseView.findViewById(R.id.text_name);
		}
		return TextName;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

}
