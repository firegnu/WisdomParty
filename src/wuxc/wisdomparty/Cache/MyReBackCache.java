package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class MyReBackCache {

	private View baseView;
	private TextView TextTime;
	private TextView TextReBack;
	private TextView TextTitle;
	private ImageView ImageDelete;

	public MyReBackCache(View baseView) {
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

	public TextView getTextReBack() {
		if (TextReBack == null) {
			TextReBack = (TextView) baseView.findViewById(R.id.text_reback);
		}
		return TextReBack;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

}
