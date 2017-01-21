package wuxc.wisdomparty.MemberCenter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.Window;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundedImageView;

public class MemberCenterMyRank extends Activity implements OnClickListener {
	private ImageView ImageBack;
	// image_head_party
	// rounded_headimg
	// text_name
	private ImageView IamgeHeadParty;
	private RoundedImageView RoundedHeadimg;
	private TextView TextName;
	private LinearLayout LinContent;
	private int screenwidth;
	private int ScreenHeight = 0;
	private float scale = 0;
	private float scalepx = 0;
	private float dp = 0;
	private TextView TextVipDot1;
	private TextView TextVipDot2;
	private TextView TextVipDot3;
	private TextView TextVipDot4;
	private TextView TextVipDot5;
	private int myrank = 400;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_myrank);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		IamgeHeadParty = (ImageView) findViewById(R.id.image_head_party);
		RoundedHeadimg = (RoundedImageView) findViewById(R.id.rounded_headimg);
		TextName = (TextView) findViewById(R.id.text_name);
		LinContent = (LinearLayout) findViewById(R.id.lin_content);
		TextVipDot1 = (TextView) findViewById(R.id.text_vip_dot_1);
		TextVipDot2 = (TextView) findViewById(R.id.text_vip_dot_2);
		TextVipDot3 = (TextView) findViewById(R.id.text_vip_dot_3);
		TextVipDot4 = (TextView) findViewById(R.id.text_vip_dot_4);
		TextVipDot5 = (TextView) findViewById(R.id.text_vip_dot_5);

		ImageBack.setOnClickListener(this);
		initheight();
		SetRank(myrank);
	}

	private void SetRank(int rank) {
		// TODO Auto-generated method stub
		TextVipDot1.setVisibility(View.GONE);
		TextVipDot2.setVisibility(View.GONE);
		TextVipDot3.setVisibility(View.GONE);
		TextVipDot4.setVisibility(View.GONE);
		TextVipDot5.setVisibility(View.GONE);
		double length = (screenwidth - scalepx * 80) / 4.0 - 10 * scalepx;
		if (rank <= 500) {
			TextVipDot1.setVisibility(View.VISIBLE);
			length = length * rank / 500;
			RelativeLayout.LayoutParams LayoutParams = (android.widget.RelativeLayout.LayoutParams) TextVipDot1
					.getLayoutParams();
			LayoutParams.leftMargin = (int) length;
			TextVipDot1.setLayoutParams(LayoutParams);
		} else if (rank > 500 && rank <= 1000) {
			TextVipDot2.setVisibility(View.VISIBLE);
			length = length * (rank - 500) / 500;
			RelativeLayout.LayoutParams LayoutParams = (android.widget.RelativeLayout.LayoutParams) TextVipDot2
					.getLayoutParams();
			LayoutParams.leftMargin = (int) length;
			TextVipDot2.setLayoutParams(LayoutParams);
		} else if (rank > 1000 && rank <= 2000) {
			TextVipDot3.setVisibility(View.VISIBLE);
			length = length * (rank - 1000) / 1000;
			RelativeLayout.LayoutParams LayoutParams = (android.widget.RelativeLayout.LayoutParams) TextVipDot3
					.getLayoutParams();
			LayoutParams.leftMargin = (int) length;
			TextVipDot3.setLayoutParams(LayoutParams);
		} else if (rank > 2000 && rank <= 3500) {
			TextVipDot4.setVisibility(View.VISIBLE);
			length = length * (rank - 2000) / 1500;
			RelativeLayout.LayoutParams LayoutParams = (android.widget.RelativeLayout.LayoutParams) TextVipDot4
					.getLayoutParams();
			LayoutParams.leftMargin = (int) length;
			TextVipDot4.setLayoutParams(LayoutParams);
		} else if (rank > 3500) {
			TextVipDot5.setVisibility(View.VISIBLE);
			if (rank <= 8000) {
				length = length * (rank - 3500) / 4500;
			}

			RelativeLayout.LayoutParams LayoutParams = (android.widget.RelativeLayout.LayoutParams) TextVipDot5
					.getLayoutParams();
			LayoutParams.leftMargin = (int) length;
			TextVipDot5.setLayoutParams(LayoutParams);
		}

	}

	private void initheight() {
		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		DisplayMetrics mMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
		scale = getResources().getDisplayMetrics().density;
		Rect frame = new Rect();

		getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);

		int statusBarHeight = frame.top;
		dp = screenwidth / scale + 0.5f;
		scalepx = screenwidth / dp;
		ScreenHeight = (int) (screenwidth * 1);
		LinearLayout.LayoutParams LayoutParams = (android.widget.LinearLayout.LayoutParams) LinContent
				.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		LinContent.setLayoutParams(LayoutParams);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		default:
			break;
		}
	}

}
