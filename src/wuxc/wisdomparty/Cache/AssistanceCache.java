package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class AssistanceCache {

	private View baseView;
	private TextView TextNumber;
	private RelativeLayout RelaHalf;
	private RelativeLayout RelaOneOfTen;
	private TextView TextAim;
	private TextView TextDetail;
	private ImageView ImageBackGround;
	private TextView TextTitle;

	public AssistanceCache(View baseView) {
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

	public TextView getTextAim() {
		if (TextAim == null) {
			TextAim = (TextView) baseView.findViewById(R.id.text_aim);
		}
		return TextAim;
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

	public TextView getTextNumber() {
		if (TextNumber == null) {
			TextNumber = (TextView) baseView.findViewById(R.id.text_number);
		}
		return TextNumber;
	}

}
