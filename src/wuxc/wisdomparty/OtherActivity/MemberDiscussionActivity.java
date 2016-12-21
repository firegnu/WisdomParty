package wuxc.wisdomparty.OtherActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import single.wuxc.wisdomparty.R;
import android.view.View.OnClickListener;

public class MemberDiscussionActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private ListView ListData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_discussion_activity);
		initview();
		setonclicklistener();
	}

	private void initview() {
		// TODO Auto-generated method stub
		ImageBack = (ImageView) findViewById(R.id.image_back);

	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		default:
			break;
		}
	}

}
