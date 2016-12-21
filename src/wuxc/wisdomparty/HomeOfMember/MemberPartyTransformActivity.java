package wuxc.wisdomparty.HomeOfMember;

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
	private String BranchName;
	private String BranchAddress;
	private String Name;
	private String BranchTime;

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
		BranchName = "高新区区政府";
		BranchAddress = "陕西省西安市高新区";
		BranchTime = "2016-11-12";
		Name = "张志志";
		TextTransformName.setText(Name);
		TextTransformPartyName.setText(BranchName);
		TextTransformPartyAddress.setText(BranchAddress);
		TextTransformTime.setText(BranchTime);
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
			Bundle bundle = new Bundle();
			bundle.putString("BranchName", BranchName);
			bundle.putString("BranchAddress", BranchAddress);
			bundle.putString("Name", Name);
			intent.putExtras(bundle);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
