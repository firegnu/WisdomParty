package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class MemberEducationCache {

	private View baseView;
	private ImageView ImageHeadimg;

	private TextView TextTitle;
	private TextView TextTime;

	public MemberEducationCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextTitle() {
		if (TextTitle == null) {
			TextTitle = (TextView) baseView.findViewById(R.id.text_title);
		}
		return TextTitle;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

	public ImageView getImageView() {
		if (ImageHeadimg == null) {
			ImageHeadimg = (ImageView) baseView.findViewById(R.id.image_headimg);
		}
		return ImageHeadimg;
	}

}
