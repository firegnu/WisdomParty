package wuxc.wisdomparty.OtherActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import single.wuxc.wisdomparty.R;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MemberPartyTransformActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private TextView TextTransformName;
	private TextView TextTransformPartyName;
	private TextView TextTransformPartyAddress;
	private TextView TextTransformTime;
	private Button BtnTransformConfirm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_party_transform_activity);
		initview();
		setonclicklistener();
		setdata();
	}

	private void setdata() {
		// TODO Auto-generated method stub
		TextTransformName.setText("张三");
		TextTransformPartyName.setText("高新区区政府");
		TextTransformPartyAddress.setText("陕西省西安市高新区");
		TextTransformTime.setText("2016-11-12");
	}

	private void initview() {
		// TODO Auto-generated method stub
		TextTransformName = (TextView) findViewById(R.id.transform_name);
		TextTransformPartyName = (TextView) findViewById(R.id.transform_party_name);
		TextTransformPartyAddress = (TextView) findViewById(R.id.transform_party_address);
		TextTransformTime = (TextView) findViewById(R.id.transform_time);
		BtnTransformConfirm = (Button) findViewById(R.id.btn_transform_confirm);
		ImageBack = (ImageView) findViewById(R.id.image_back);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		BtnTransformConfirm.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.btn_transform_confirm:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), PartyBranchDataListActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
