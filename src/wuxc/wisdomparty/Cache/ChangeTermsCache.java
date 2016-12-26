package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class ChangeTermsCache {

	private View baseView;

	private TextView TextTitle;
	private TextView TextNumber;
	private TextView TextIsSelecting;
	private TextView TextIsSelected;

	public ChangeTermsCache(View baseView) {
		this.baseView = baseView;
	}

	public TextView getTextIsSelected() {
		if (TextIsSelected == null) {
			TextIsSelected = (TextView) baseView.findViewById(R.id.text_is_selected);
		}
		return TextIsSelected;
	}

	public TextView getTextIsSelecting() {
		if (TextIsSelecting == null) {
			TextIsSelecting = (TextView) baseView.findViewById(R.id.text_is_selecting);
		}
		return TextIsSelecting;
	}

	public TextView getTextNumber() {
		if (TextNumber == null) {
			TextNumber = (TextView) baseView.findViewById(R.id.text_number);
		}
		return TextNumber;
	}

	public TextView getTextTitle() {
		if (TextTitle == null) {
			TextTitle = (TextView) baseView.findViewById(R.id.text_title);
		}
		return TextTitle;
	}

}
