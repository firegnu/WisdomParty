package wuxc.wisdomparty.main;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeActivity.HomeOfEmployeeActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfHealthActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfMemberActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfVolunteerActivity;
import wuxc.wisdomparty.HomeActivity.HomeOfYouthActivity;
import wuxc.wisdomparty.HomeActivity.HomeSearchActivity;
import wuxc.wisdomparty.HomeActivity.HomeSettingActivity;
import wuxc.wisdomparty.layout.CircleLayout;
import wuxc.wisdomparty.layout.CircleLayout.OnItemClickListener;

public class MainHomePageFragment extends MainBaseFragment implements OnItemClickListener, OnClickListener {
	private CircleLayout CircleMenu;
	private ImageView ImageSearch;
	private ImageView ImageSetting;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mainhomepage, container, false);
		initview(view);
		setclicklistener();
		return view;
	}

	private void setclicklistener() {
		// TODO Auto-generated method stub
		CircleMenu.setOnItemClickListener(this);
		ImageSearch.setOnClickListener(this);
		ImageSetting.setOnClickListener(this);
	}

	private void initview(View view) {
		// TODO Auto-generated method stub
		CircleMenu = (CircleLayout) view.findViewById(R.id.main_circle_layout);
		ImageSearch = (ImageView) view.findViewById(R.id.image_search);
		ImageSetting = (ImageView) view.findViewById(R.id.image_setting);
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

		default:
			break;
		}
	}
}
