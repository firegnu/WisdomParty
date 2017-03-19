package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class NoticeCache {

	private View baseView;
	private TextView TextTime;
	private TextView TextStyle;
	private TextView TextRead;

	public NoticeCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextStyle() {
		if (TextStyle == null) {
			TextStyle = (TextView) baseView.findViewById(R.id.text_style);
		}
		return TextStyle;
	}

	public TextView getTextRead() {
		if (TextRead == null) {
			TextRead = (TextView) baseView.findViewById(R.id.text_is_read);
		}
		return TextRead;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

}
