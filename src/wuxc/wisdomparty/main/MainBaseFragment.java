package wuxc.wisdomparty.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import single.wuxc.wisdomparty.R;

public class MainBaseFragment extends Fragment {

	public FragmentManager mFragmentManager;
	public FragmentTransaction mFragmentTransaction;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		return super.onCreateView(inflater, container, savedInstanceState);

	}

	public static MainBaseFragment newInstance(Context context, String tag) {
		MainBaseFragment mainbaseFragment = null;
		if (TextUtils.equals(tag, context.getString(R.string.str_homepage))) {
			mainbaseFragment = new MainHomePageFragment();
		} else if (TextUtils.equals(tag, context.getString(R.string.str_public))) {
			mainbaseFragment = new MainPublicPageFragment();
		} else if (TextUtils.equals(tag, context.getString(R.string.str_party))) {
			mainbaseFragment = new MainPartyPageFragment();
		} else if (TextUtils.equals(tag, context.getString(R.string.str_member))) {
			mainbaseFragment = new MainMemberPageFragment();
		}

		return mainbaseFragment;

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}

}
