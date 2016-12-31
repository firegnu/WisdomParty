package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class MydueCache {

	private View baseView;
	private TextView TextMonth;
	private TextView TextTime;
	private TextView TextMoney;

	public MydueCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextMoney() {
		if (TextMoney == null) {
			TextMoney = (TextView) baseView.findViewById(R.id.text_money);
		}
		return TextMoney;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

	public TextView getTextMonth() {
		if (TextMonth == null) {
			TextMonth = (TextView) baseView.findViewById(R.id.text_month);
		}
		return TextMonth;
	}

}
