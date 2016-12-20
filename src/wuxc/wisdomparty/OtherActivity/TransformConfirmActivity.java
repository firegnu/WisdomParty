package wuxc.wisdomparty.OtherActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import android.view.Window;

public class TransformConfirmActivity extends Activity implements OnClickListener {
	private String BranchIntoName;
	private String BranchIntoAddress;
	private String BranchName;
	private String BranchAddress;
	private String Name;
	private Button BtnCancel;
	private Button BtnConfirm;
	private TextView TextName;
	private TextView TextFromName;
	private TextView TextFromAddress;
	private TextView TextIntoName;
	private TextView TextIntoAddress;
	private ImageView ImageBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.transform_confirm_activity);
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象
		BranchName = bundle.getString("BranchName");
		BranchAddress = bundle.getString("BranchAddress");
		Name = bundle.getString("Name");
		BranchIntoName = bundle.getString("BranchIntoName");
		BranchIntoAddress = bundle.getString("BranchIntoAddress");
		initview();
		setonclicklistener();
		setdata();
	}

	private void setdata() {
		// TODO Auto-generated method stub
		TextName.setText(Name);
		TextFromName.setText(BranchName);
		TextFromAddress.setText(BranchAddress);
		TextIntoName.setText(BranchIntoName);
		TextIntoAddress.setText(BranchIntoAddress);
	}

	private void initview() {
		// TODO Auto-generated method stub
		BtnCancel = (Button) findViewById(R.id.btn_transform_cancel);
		BtnConfirm = (Button) findViewById(R.id.btn_transform_confirm);
		TextName = (TextView) findViewById(R.id.transform_name);
		TextFromName = (TextView) findViewById(R.id.transform_party_from_name);
		TextFromAddress = (TextView) findViewById(R.id.transform_party_from_address);
		TextIntoName = (TextView) findViewById(R.id.transform_into_name);
		TextIntoAddress = (TextView) findViewById(R.id.transform_into_address);
		ImageBack = (ImageView) findViewById(R.id.image_back);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		BtnConfirm.setOnClickListener(this);
		BtnCancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.btn_transform_cancel:
			finish();
			break;
		case R.id.btn_transform_confirm:
			Toast.makeText(getApplicationContext(), "确认转接", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}

}
