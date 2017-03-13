package wuxc.wisdomparty.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeActivity.HomeOfEmployeeActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfHealthActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfMemberActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfStudyActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfVolunteerActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfYouthActivity;
import wuxc.wisdomparty.HomeActivity.HomeSearchActivity;
import wuxc.wisdomparty.HomeActivity.HomeSettingActivity;
import wuxc.wisdomparty.MemberCenter.NoticeDetailActivity;
import wuxc.wisdomparty.StartPage.LoginAactivity;
import wuxc.wisdomparty.layout.CircleLayout;
import wuxc.wisdomparty.layout.CircleLayout.OnItemClickListener;

public class MainHomePageFragment extends MainBaseFragment implements OnItemClickListener, OnClickListener {
	private CircleLayout CircleMenu;
	private LinearLayout LinCircle;
	private LinearLayout LinCircleBackground;
	private LinearLayout Left;
	private ImageView ImageSearch;
	private ImageView ImageSetting;
	private static String TAG = "MainHomePageFragment";
	private FrameLayout FrameCircle;
	private LinearLayout Right;
	private TextView TextNotice;
	private TextView TextTest;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mainhomepage, container, false);
		initview(view);
		setclicklistener();
		setlayoutdistance();
		return view;
	}

	private void setlayoutdistance() {
		// TODO Auto-generated method stub
		int screenwidth = 0;
		int circleheight = 0;
		int circlesmall = 0;
		screenwidth = getActivity().getWindow().getWindowManager().getDefaultDisplay().getWidth();
		circleheight = (int) (1.19 * 2 * screenwidth / 3);
		RelativeLayout.LayoutParams layoutParams1 = (android.widget.RelativeLayout.LayoutParams) LinCircleBackground
				.getLayoutParams();
		layoutParams1.height = circleheight;
		LinCircleBackground.setLayoutParams(layoutParams1);
		circlesmall = (int) (1.10 * 2 * screenwidth / 3);
		layoutParams1 = (android.widget.RelativeLayout.LayoutParams) LinCircle.getLayoutParams();
		layoutParams1.height = circlesmall;

		LinCircle.setLayoutParams(layoutParams1);
		LinearLayout.LayoutParams layoutParams3 = (android.widget.LinearLayout.LayoutParams) Left.getLayoutParams();
		layoutParams3.height = circleheight;
		Left.setLayoutParams(layoutParams3);
		FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) CircleMenu.getLayoutParams();
		layoutParams.width = circlesmall;
		CircleMenu.setLayoutParams(layoutParams);
		LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) FrameCircle
				.getLayoutParams();
		layoutParams2.width = circlesmall;

		FrameCircle.setLayoutParams(layoutParams2);
		layoutParams2 = (android.widget.LinearLayout.LayoutParams) Right.getLayoutParams();

		layoutParams2.leftMargin = (int) (0.044 * screenwidth);

		Right.setLayoutParams(layoutParams2);

	}

	private void setclicklistener() {
		// TODO Auto-generated method stub
		CircleMenu.setOnItemClickListener(this);
		ImageSearch.setOnClickListener(this);
		ImageSetting.setOnClickListener(this);
		TextNotice.setOnClickListener(this);
		TextTest.setOnClickListener(this);
	}

	private void initview(View view) {
		// TODO Auto-generated method stub
		CircleMenu = (CircleLayout) view.findViewById(R.id.main_circle_layout);
		LinCircle = (LinearLayout) view.findViewById(R.id.lin_circle);
		LinCircleBackground = (LinearLayout) view.findViewById(R.id.lin_circle_background);
		Left = (LinearLayout) view.findViewById(R.id.left);
		ImageSearch = (ImageView) view.findViewById(R.id.image_search);
		ImageSetting = (ImageView) view.findViewById(R.id.image_setting);
		FrameCircle = (FrameLayout) view.findViewById(R.id.frame_circle);
		Right = (LinearLayout) view.findViewById(R.id.right);
		TextNotice = (TextView) view.findViewById(R.id.text_notice);
		TextTest = (TextView) view.findViewById(R.id.text_test);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		MainActivity.curFragmentTag = getString(R.string.str_homepage);

	}

	@Override
	public void onItemClick(View view, int position, long id, String name) {
		// TODO Auto-generated method stub
		if (position > -1) {

			if (this.getString(R.string.str_home_employee).equals(name)) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), HomeOfEmployeeActivity.class);
				startActivity(intent);
			} else if (this.getString(R.string.str_home_youth).equals(name)) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), HomeOfYouthActivity.class);
				startActivity(intent);
			} else if (this.getString(R.string.str_home_health).equals(name)) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), HomeOfHealthActivity.class);
				startActivity(intent);
			} else if (this.getString(R.string.str_home_volunteer).equals(name)) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), HomeOfVolunteerActivity.class);
				startActivity(intent);
			} else if (this.getString(R.string.str_home_member).equals(name)) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), HomeOfMemberActivity.class);
				startActivity(intent);
			} else if (this.getString(R.string.str_home_study).equals(name)) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), HomeOfStudyActivity.class);
				startActivity(intent);
			}
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_search:
			Intent intent_search = new Intent();
			intent_search.setClass(getActivity(), HomeSearchActivity.class);
			startActivity(intent_search);
			break;
		case R.id.image_setting:
			Intent intent_setting = new Intent();
			intent_setting.setClass(getActivity(), HomeSettingActivity.class);
			startActivity(intent_setting);
			break;
		case R.id.text_notice:
			Intent intent_notice = new Intent();
			intent_notice.setClass(getActivity(), NoticeDetailActivity.class);
			startActivity(intent_notice);
			break;
		case R.id.text_test:
			Intent intent_test = new Intent();
			intent_test.setClass(getActivity(), LoginAactivity.class);
			startActivity(intent_test);
			break;
		default:
			break;
		}
	}
}
