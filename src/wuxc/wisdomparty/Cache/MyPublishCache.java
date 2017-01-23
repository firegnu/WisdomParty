package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class MyPublishCache {

	private View baseView;
	private TextView TextTime;
	private TextView TextBigTime;
	private TextView TextTitle;
	private ImageView ImageDelete;

	public MyPublishCache(View baseView) {
		this.baseView = baseView;
	}

	public ImageView getImageDelete() {
		if (ImageDelete == null) {
			ImageDelete = (ImageView) baseView.findViewById(R.id.image_delete);
		}
		return ImageDelete;
	}

	public TextView getTextTitle() {
		if (TextTitle == null) {
			TextTitle = (TextView) baseView.findViewById(R.id.text_title);
		}
		return TextTitle;
	}

	public TextView getTextBigTime() {
		if (TextBigTime == null) {
			TextBigTime = (TextView) baseView.findViewById(R.id.text_big_time);
		}
		return TextBigTime;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

}
