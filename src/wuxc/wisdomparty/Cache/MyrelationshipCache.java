package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class MyrelationshipCache {

	private View baseView;
	private TextView TextOut;
	private TextView TextTime;
	private TextView TextIn;
	private LinearLayout LinAll;

	public MyrelationshipCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextIn() {
		if (TextIn == null) {
			TextIn = (TextView) baseView.findViewById(R.id.text_in);
		}
		return TextIn;
	}

	public LinearLayout getLinAll() {
		if (LinAll == null) {
			LinAll = (LinearLayout) baseView.findViewById(R.id.lin_all);
		}
		return LinAll;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

	public TextView getTextOut() {
		if (TextOut == null) {
			TextOut = (TextView) baseView.findViewById(R.id.text_out);
		}
		return TextOut;
	}

}
