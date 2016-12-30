package wuxc.wisdomparty.MemberCenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import single.wuxc.wisdomparty.R;

public class MemberCenterMyCollect extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_mycollect);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
