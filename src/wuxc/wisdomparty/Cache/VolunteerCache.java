package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class VolunteerCache {

	private View baseView;
	private RelativeLayout RelaHalf;
	private RelativeLayout RelaOneOfTen;
	private TextView TextDetail;
	private ImageView ImageBackGround;
	private TextView TextTitle;

	public VolunteerCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextTitle() {
		if (TextTitle == null) {
			TextTitle = (TextView) baseView.findViewById(R.id.text_title);
		}
		return TextTitle;
	}

	public ImageView getImageBackGround() {
		if (ImageBackGround == null) {
			ImageBackGround = (ImageView) baseView.findViewById(R.id.image_background);
		}
		return ImageBackGround;
	}

	public TextView getTextDetail() {
		if (TextDetail == null) {
			TextDetail = (TextView) baseView.findViewById(R.id.text_detail);
		}
		return TextDetail;
	}

	public RelativeLayout getRelaOneOfTen() {
		if (RelaOneOfTen == null) {
			RelaOneOfTen = (RelativeLayout) baseView.findViewById(R.id.rela_oneoften);
		}
		return RelaOneOfTen;
	}

	public RelativeLayout getRelaHalf() {
		if (RelaHalf == null) {
			RelaHalf = (RelativeLayout) baseView.findViewById(R.id.rela_half);
		}
		return RelaHalf;
	}

}
