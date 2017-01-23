package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class CollectCache {

	private View baseView;
	private ImageView ImageHeadimg;
	private TextView TextTitle;
	private TextView TextTime;
	private ImageView Imageselected;
	private LinearLayout LinDelete;

	public CollectCache(View baseView) {
		this.baseView = baseView;
	}

	public LinearLayout getLinDelete() {
		if (LinDelete == null) {
			LinDelete = (LinearLayout) baseView.findViewById(R.id.lin_delete);
		}
		return LinDelete;
	}

	public ImageView getImageselected() {
		if (Imageselected == null) {
			Imageselected = (ImageView) baseView.findViewById(R.id.image_selected);
		}
		return Imageselected;
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
