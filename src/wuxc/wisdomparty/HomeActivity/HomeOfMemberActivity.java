package wuxc.wisdomparty.HomeActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeOfMember.MemberDiscussionActivity;
import wuxc.wisdomparty.HomeOfMember.MemberPartyBranchActivity;
import wuxc.wisdomparty.HomeOfMember.MemberPartyDuesActivity;
import wuxc.wisdomparty.HomeOfMember.MemberPartyTransformActivity;
import wuxc.wisdomparty.HomeOfMember.MemberRespondActivity;
import wuxc.wisdomparty.HomeOfMember.MemberRulesActivity;
import wuxc.wisdomparty.MemberCenter.NoticeDatalistActivity;

public class HomeOfMemberActivity extends Activity implements OnClickListener {

	private LinearLayout LinMemberRespond;
	private LinearLayout LinMemberPartyTransform;
	private LinearLayout LinMemberRules;
	private LinearLayout LinMemberPartyDues;
	private LinearLayout LinMemberDiscussion;
	private LinearLayout LinMemberPartyBranch;
	private LinearLayout LinPlaceHolderRight2;
	private LinearLayout LinPlaceHolderRight3;
	private LinearLayout LinPlaceHolderLeft2;
	private LinearLayout LinPlaceHolderLeft3;
	private LinearLayout LinPlaceHolderMiddle3;
	private TextView TextNotice;
	private ImageView ImageBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_member_activity);
		initview();
		setonclicklistener();
		setlayoutheight();
	}

	private void setlayoutheight() {
		// TODO Auto-generated method stub
		int screenwidth = 0;
		int height = 0;
		int height2 = 0;
		int height3 = 0;
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		height = screenwidth / 5;
		height2 = height / 3;
		height3 = height / 2;
		LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) LinMemberDiscussion
				.getLayoutParams();
		layoutParams.height = height;
		LinMemberDiscussion.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinMemberRespond.getLayoutParams();
		layoutParams.height = height;
		LinMemberRespond.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinMemberPartyTransform.getLayoutParams();
		layoutParams.height = height;
		LinMemberPartyTransform.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinMemberRules.getLayoutParams();
		layoutParams.height = height;
		LinMemberRules.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinMemberPartyDues.getLayoutParams();
		layoutParams.height = height;
		LinMemberPartyDues.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinMemberPartyBranch.getLayoutParams();
		layoutParams.height = height;
		LinMemberPartyBranch.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinPlaceHolderRight3.getLayoutParams();
		layoutParams.height = height3;
		LinPlaceHolderRight3.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinPlaceHolderLeft3.getLayoutParams();
		layoutParams.height = height3;
		LinPlaceHolderLeft3.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinPlaceHolderMiddle3.getLayoutParams();
		layoutParams.height = height3;
		LinPlaceHolderMiddle3.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinPlaceHolderRight2.getLayoutParams();
		layoutParams.height = height2;
		LinPlaceHolderRight2.setLayoutParams(layoutParams);

		layoutParams = (android.widget.LinearLayout.LayoutParams) LinPlaceHolderLeft2.getLayoutParams();
		layoutParams.height = height2;
		LinPlaceHolderLeft2.setLayoutParams(layoutParams);

	}

	private void initview() {
		// TODO Auto-generated method stub
		LinMemberRespond = (LinearLayout) findViewById(R.id.lin_member_respond);
		LinMemberPartyTransform = (LinearLayout) findViewById(R.id.lin_member_party_transform);
		LinMemberRules = (LinearLayout) findViewById(R.id.lin_member_rules);
		LinMemberPartyDues = (LinearLayout) findViewById(R.id.lin_member_party_dues);
		LinMemberDiscussion = (LinearLayout) findViewById(R.id.lin_member_discussion);
		LinMemberPartyBranch = (LinearLayout) findViewById(R.id.lin_member_party_branch);
		LinPlaceHolderRight2 = (LinearLayout) findViewById(R.id.lin_placeholder_right_2);
		LinPlaceHolderRight3 = (LinearLayout) findViewById(R.id.lin_placeholder_right_3);
		LinPlaceHolderLeft2 = (LinearLayout) findViewById(R.id.lin_placeholder_left_2);
		LinPlaceHolderLeft3 = (LinearLayout) findViewById(R.id.lin_placeholder_left_3);
		LinPlaceHolderMiddle3 = (LinearLayout) findViewById(R.id.lin_placeholder_middle_3);
		TextNotice = (TextView) findViewById(R.id.text_notice);
		ImageBack = (ImageView) findViewById(R.id.image_back);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		LinMemberRespond.setOnClickListener(this);
		LinMemberPartyTransform.setOnClickListener(this);
		LinMemberRules.setOnClickListener(this);
		LinMemberPartyDues.setOnClickListener(this);
		LinMemberDiscussion.setOnClickListener(this);
		LinMemberPartyBranch.setOnClickListener(this);
		TextNotice.setOnClickListener(this);
		ImageBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.text_notice:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), NoticeDatalistActivity.class);
			startActivity(intent);
			break;
		case R.id.lin_member_discussion:
			Intent intent1 = new Intent();
			intent1.setClass(getApplicationContext(), MemberDiscussionActivity.class);
			startActivity(intent1);
			break;
		case R.id.lin_member_party_branch:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(), MemberPartyBranchActivity.class);
			startActivity(intent2);
			break;
		case R.id.lin_member_party_dues:
			Intent intent3 = new Intent();
			intent3.setClass(getApplicationContext(), MemberPartyDuesActivity.class);
			startActivity(intent3);
			break;
		case R.id.lin_member_party_transform:
			Intent intent4 = new Intent();
			intent4.setClass(getApplicationContext(), MemberPartyTransformActivity.class);
			startActivity(intent4);
			break;
		case R.id.lin_member_respond:
			Intent intent5 = new Intent();
			intent5.setClass(getApplicationContext(), MemberRespondActivity.class);
			startActivity(intent5);
			break;
		case R.id.lin_member_rules:
			Intent intent6 = new Intent();
			intent6.setClass(getApplicationContext(), MemberRulesActivity.class);
			startActivity(intent6);
			break;
		default:
			break;
		}
	}

}
