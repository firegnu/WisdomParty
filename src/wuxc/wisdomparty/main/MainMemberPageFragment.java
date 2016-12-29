package wuxc.wisdomparty.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import single.wuxc.wisdomparty.R;

public class MainMemberPageFragment extends MainBaseFragment {
	// lin_top_back
	// rela_headimg
	private LinearLayout LinTopBack;
	private RelativeLayout RelaHeadimg;
	private int screenwidth;
	private int ScreenHeight = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mainmemberpage, container, false);
		initview(view);
		setonclicklistener();
		setlayoutheight();
		return view;
	}

	private void initview(View view) {
		// TODO Auto-generated method stub
		LinTopBack = (LinearLayout) view.findViewById(R.id.lin_top_back);
		RelaHeadimg = (RelativeLayout) view.findViewById(R.id.rela_headimg);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub

	}

	private void setlayoutheight() {
		// TODO Auto-generated method stub
		screenwidth = getActivity().getWindow().getWindowManager().getDefaultDisplay().getWidth();
		ScreenHeight = (int) (screenwidth / 1.8);
		LinearLayout.LayoutParams LayoutParams = (android.widget.LinearLayout.LayoutParams) LinTopBack
				.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		LinTopBack.setLayoutParams(LayoutParams);
		LayoutParams = (android.widget.LinearLayout.LayoutParams) RelaHeadimg.getLayoutParams();
		LayoutParams.width = 16 * ScreenHeight / 33;
		RelaHeadimg.setLayoutParams(LayoutParams);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		MainActivity.curFragmentTag = getString(R.string.str_member);

	}
}
