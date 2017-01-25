package wuxc.wisdomparty.MemberCenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Window;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeOfMember.MemberPartyBranchDetailActivity;

public class MemberCenterMyBranch extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private LinearLayout LinBranchBack;
	private int screenwidth;
	private int ScreenHeight = 0;
	private TextView TextDetail;
	private TextView TextPhoneNumber;
	private TextView TextCharge;
	private TextView TextAddress;
	private TextView TextTime;
	private TextView TextBranch;
	private TextView TextName;
	private String StrPhoneNumber = "18710861689";
	private String StrCharge = "薛飞";
	private String StrAddress = "三门峡市政府大院";
	private String StrTime = "2016-11-23";
	private String StrBranch = "三门峡支部";
	private String StrName = "薛飞";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_mybranch);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		LinBranchBack = (LinearLayout) findViewById(R.id.lin_branch_info);
		TextDetail = (TextView) findViewById(R.id.text_branch_detail);
		TextPhoneNumber = (TextView) findViewById(R.id.text_branch_phonenumber);
		TextCharge = (TextView) findViewById(R.id.text_branch_charge);
		TextAddress = (TextView) findViewById(R.id.text_branch_address);
		TextTime = (TextView) findViewById(R.id.text_branch_transfer_time);
		TextBranch = (TextView) findViewById(R.id.text_branch);
		TextName = (TextView) findViewById(R.id.text_name);
		ImageBack.setOnClickListener(this);
		TextDetail.setOnClickListener(this);
		setlayoutheight();
		settext();
	}

	private void settext() {
		// TODO Auto-generated method stub
		TextPhoneNumber.setText("支部联系电话：" + StrPhoneNumber);
		TextCharge.setText("支部负责人：" + StrCharge);
		TextAddress.setText("支部所在地：" + StrAddress);
		TextTime.setText("何时转到本支部：" + StrTime);
		TextBranch.setText("所属支部：" + StrBranch);
		TextName.setText("姓名：" + StrName);
	}

	private void setlayoutheight() {
		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		ScreenHeight = screenwidth;
		LinearLayout.LayoutParams LayoutParams = (android.widget.LinearLayout.LayoutParams) LinBranchBack
				.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		LinBranchBack.setLayoutParams(LayoutParams);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.text_branch_detail:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), MemberPartyBranchDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("Name", "西安交大党支部");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
