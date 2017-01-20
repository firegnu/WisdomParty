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
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.PartyManage.SpecialDetailActivity;

public class HealthTenFragment extends Fragment implements OnClickListener {
	private static Bitmap pic = null;
	private String imageuri = "";
	private String picpath = "";
	private ImageView two_one_text;
	private SharedPreferences picinfo;
	private TextView text_title_two;
	private String url = "";

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
		View view = inflater.inflate(R.layout.homeofhealthtop, container, false);
		two_one_text = (ImageView) view.findViewById(R.id.two_one_text);
		picinfo = getActivity().getSharedPreferences("picinfo", Context.MODE_PRIVATE);

		text_title_two = (TextView) view.findViewById(R.id.text_title_two);

		two_one_text.setOnClickListener(this);
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
		case R.id.two_one_text:
			Intent intent = new Intent();
			intent.setClass(getActivity(), SpecialDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("Title", "±êÌâ");
			bundle.putString("Time", "2016-10-31");
			bundle.putString("Name", "Ãû×Ö");
			intent.putExtras(bundle);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
