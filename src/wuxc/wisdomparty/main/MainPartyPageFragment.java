package wuxc.wisdomparty.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import single.wuxc.wisdomparty.R;

public class MainPartyPageFragment extends MainBaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mainpartypage, container, false);

		return view;
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		MainActivity.curFragmentTag = getString(R.string.str_party);

	}
}
