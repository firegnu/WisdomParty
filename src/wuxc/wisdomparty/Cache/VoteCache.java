package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class VoteCache {

	private View baseView;
	private TextView TextDetail;
	private ImageView ImageHeadimg;
	private TextView TextTitle;

	public VoteCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextTitle() {
		if (TextTitle == null) {
			TextTitle = (TextView) baseView.findViewById(R.id.text_title);
		}
		return TextTitle;
	}

	public ImageView getImageHeadimg() {
		if (ImageHeadimg == null) {
			ImageHeadimg = (ImageView) baseView.findViewById(R.id.image_headimg);
		}
		return ImageHeadimg;
	}

	public TextView getTextDetail() {
		if (TextDetail == null) {
			TextDetail = (TextView) baseView.findViewById(R.id.text_detail);
		}
		return TextDetail;
	}

}
