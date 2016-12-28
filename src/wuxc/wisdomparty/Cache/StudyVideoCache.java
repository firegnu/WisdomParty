package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class StudyVideoCache {

	private View baseView;
	private TextView TextTime;
	private TextView TextTimeLong;
	private TextView TextNumberCollect;
	private ImageView ImageBackGround;
	private TextView TextNumberGreat;
	private TextView TextLabel1;
	private TextView TextLabel2;
	private TextView TextLabel3;
	private TextView TextTitle;
	private RelativeLayout RelaHalf;

	public StudyVideoCache(View baseView) {
		this.baseView = baseView;
	}

	public RelativeLayout getRelaHalf() {
		if (RelaHalf == null) {
			RelaHalf = (RelativeLayout) baseView.findViewById(R.id.rela_half);
		}
		return RelaHalf;
	}

	public TextView getTextTitle() {
		if (TextTitle == null) {
			TextTitle = (TextView) baseView.findViewById(R.id.text_title);
		}
		return TextTitle;
	}

	public TextView getTextLabel3() {
		if (TextLabel3 == null) {
			TextLabel3 = (TextView) baseView.findViewById(R.id.label_3);
		}
		return TextLabel3;
	}

	public TextView getTextLabel2() {
		if (TextLabel2 == null) {
			TextLabel2 = (TextView) baseView.findViewById(R.id.label_2);
		}
		return TextLabel2;
	}

	public TextView getTextLabel1() {
		if (TextLabel1 == null) {
			TextLabel1 = (TextView) baseView.findViewById(R.id.label_1);
		}
		return TextLabel1;
	}

	public TextView getTextNumberGreat() {
		if (TextNumberGreat == null) {
			TextNumberGreat = (TextView) baseView.findViewById(R.id.text_number_great);
		}
		return TextNumberGreat;
	}

	public ImageView getImageBackGround() {
		if (ImageBackGround == null) {
			ImageBackGround = (ImageView) baseView.findViewById(R.id.image_background);
		}
		return ImageBackGround;
	}

	public TextView getTextNumberCollect() {
		if (TextNumberCollect == null) {
			TextNumberCollect = (TextView) baseView.findViewById(R.id.text_number_collect);
		}
		return TextNumberCollect;
	}

	public TextView getTextTimeLong() {
		if (TextTimeLong == null) {
			TextTimeLong = (TextView) baseView.findViewById(R.id.text_timelong);
		}
		return TextTimeLong;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

}
