package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class MyActivityCache {

	private View baseView;
	private TextView TextMark;
	private TextView TextTitle;
	private TextView TextTime;

	public MyActivityCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextMark() {
		if (TextMark == null) {
			TextMark = (TextView) baseView.findViewById(R.id.text_mark);
		}
		return TextMark;
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

}
