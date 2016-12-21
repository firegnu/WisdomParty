package wuxc.wisdomparty.PartyManage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import single.wuxc.wisdomparty.R;
import android.view.Window;

public class MemberEducationActivity extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_education_activity);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
