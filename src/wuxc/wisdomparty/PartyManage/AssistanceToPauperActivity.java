package wuxc.wisdomparty.PartyManage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import single.wuxc.wisdomparty.R;
import android.view.Window;

public class AssistanceToPauperActivity extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.assistance_to_pauper_activity);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
