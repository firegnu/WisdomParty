package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class HealthCache {

	private View baseView;
	private TextView TextLabel;
	private TextView TextCollect;
	private ImageView ImageHeadimg;
	private TextView TextGreat;
	private TextView TextTitle;
	private ImageView ImageCollect;
	private ImageView ImageGreat;

	public HealthCache(View baseView) {
		this.baseView = baseView;
	}

	public ImageView getImageCollect() {
		if (ImageCollect == null) {
			ImageCollect = (ImageView) baseView.findViewById(R.id.image_collect);
		}
		return ImageCollect;
	}

	public ImageView getImageGreat() {
		if (ImageGreat == null) {
			ImageGreat = (ImageView) baseView.findViewById(R.id.image_great);
		}
		return ImageGreat;
	}

	public TextView getTextTitle() {
		if (TextTitle == null) {
			TextTitle = (TextView) baseView.findViewById(R.id.text_title);
		}
		return TextTitle;
	}

	public TextView getTextGreat() {
		if (TextGreat == null) {
			TextGreat = (TextView) baseView.findViewById(R.id.text_number_great);
		}
		return TextGreat;
	}

	public ImageView getImageHeadimg() {
		if (ImageHeadimg == null) {
			ImageHeadimg = (ImageView) baseView.findViewById(R.id.image_headimg);
		}
		return ImageHeadimg;
	}

	public TextView getTextCollect() {
		if (TextCollect == null) {
			TextCollect = (TextView) baseView.findViewById(R.id.text_number_collect);
		}
		return TextCollect;
	}

	public TextView getTextLabel() {
		if (TextLabel == null) {
			TextLabel = (TextView) baseView.findViewById(R.id.text_label);
		}
		return TextLabel;
	}

}
