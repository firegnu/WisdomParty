package wuxc.wisdomparty.ChildFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeOfMember.NoticeDatalistActivity;
import wuxc.wisdomparty.PartyManage.SpecialDetailActivity;
import wuxc.wisdomparty.PartyManage.SpecialProjectActivity;

public class EmployeeOrganizationFragment extends Fragment implements OnClickListener {
	private TextView text_3;
	private TextView text_more_notice;
	private LinearLayout lin_recommend_demand;
	private TextView text_more_special;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.employee_organization, container, false);
		text_3 = (TextView) view.findViewById(R.id.text_3);
		text_more_notice = (TextView) view.findViewById(R.id.text_more_notice);
		lin_recommend_demand = (LinearLayout) view.findViewById(R.id.lin_recommend_demand);
		text_more_special = (TextView) view.findViewById(R.id.text_more_special);
		text_3.setOnClickListener(this);
		text_more_notice.setOnClickListener(this);
		lin_recommend_demand.setOnClickListener(this);
		text_more_special.setOnClickListener(this);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.text_3:
			Intent intent = new Intent();
			intent.setClass(getActivity(), SpecialDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("Title", "标题");
			bundle.putString("Time", "2016-10-31");
			bundle.putString("Name", "名字");
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		case R.id.lin_recommend_demand:
			Intent intent2 = new Intent();
			intent2.setClass(getActivity(), SpecialDetailActivity.class);
			Bundle bundle2 = new Bundle();
			bundle2.putString("Title", "标题");
			bundle2.putString("Time", "2016-10-31");
			bundle2.putString("Name", "名字");
			intent2.putExtras(bundle2);
			startActivity(intent2);
			break;
		case R.id.text_more_notice:
			Intent intent3 = new Intent();
			intent3.setClass(getActivity(), NoticeDatalistActivity.class);
			startActivity(intent3);
			break;
		case R.id.text_more_special:
			Intent intent4 = new Intent();
			intent4.setClass(getActivity(), SpecialProjectActivity.class);
			startActivity(intent4);
			break;
		default:
			break;
		}
	}
}
