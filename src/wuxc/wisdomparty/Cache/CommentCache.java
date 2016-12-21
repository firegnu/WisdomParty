package wuxc.wisdomparty.Cache;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class CommentCache {

	private View baseView;
	private RoundImageView RoundImageview;
	private TextView TextName;
	private TextView TextTime;
	private TextView TextComment;

	public CommentCache(View baseView) {
		this.baseView = baseView;
	}

	public RoundImageView getRoundImageview() {
		if (RoundImageview == null) {
			RoundImageview = (RoundImageView) baseView.findViewById(R.id.round_headimg);
		}
		return RoundImageview;
	}

	public TextView getTextComment() {
		if (TextComment == null) {
			TextComment = (TextView) baseView.findViewById(R.id.text_comment);
		}
		return TextComment;
	}

	public TextView getTextTime() {
		if (TextTime == null) {
			TextTime = (TextView) baseView.findViewById(R.id.text_time);
		}
		return TextTime;
	}

	public TextView getTextName() {
		if (TextName == null) {
			TextName = (TextView) baseView.findViewById(R.id.text_name);
		}
		return TextName;
	}

}
