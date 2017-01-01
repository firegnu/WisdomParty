package wuxc.wisdomparty.MemberCenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class MemberCenterMyResume extends Activity implements OnClickListener {
	private TextView text_change;
	private TextView text_changeimg;
	private TextView text_myrank;
	private ImageView image_back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_myresume);
		text_change = (TextView) findViewById(R.id.text_change);
		text_changeimg = (TextView) findViewById(R.id.text_changeimg);
		text_myrank = (TextView) findViewById(R.id.text_myrank);
		image_back = (ImageView) findViewById(R.id.image_back);
		text_change.setOnClickListener(this);
		text_changeimg.setOnClickListener(this);
		text_myrank.setOnClickListener(this);
		image_back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.text_change:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), MemberCenterChangeResume.class);
			startActivity(intent);
			break;
		case R.id.text_changeimg:
			Intent intent1 = new Intent();
			intent1.setClass(getApplicationContext(), MemberCenterMyHeadimg.class);
			startActivity(intent1);
			break;
		case R.id.text_myrank:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(), MemberCenterMyRank.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}

}
