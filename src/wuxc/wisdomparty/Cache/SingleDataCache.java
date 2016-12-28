package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class SingleDataCache {

	private View baseView;

	private TextView TextData;

	public SingleDataCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextData() {
		if (TextData == null) {
			TextData = (TextView) baseView.findViewById(R.id.text_data);
		}
		return TextData;
	}

}
