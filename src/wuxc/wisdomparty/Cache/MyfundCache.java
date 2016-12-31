package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class MyfundCache {

	private View baseView;
	private TextView TextChange;
	private TextView TextTime;
	private TextView TextDetail;

	public MyfundCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextDetail() {
		if (TextDetail == null) {
			TextDetail = (TextView) baseView.findViewById(R.id.text_detail);
		}
		return TextDetail;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

	public TextView getTextChange() {
		if (TextChange == null) {
			TextChange = (TextView) baseView.findViewById(R.id.text_change);
		}
		return TextChange;
	}

}
