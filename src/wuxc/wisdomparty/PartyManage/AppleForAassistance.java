package wuxc.wisdomparty.PartyManage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import single.wuxc.wisdomparty.R;

public class AppleForAassistance extends Activity implements OnClickListener {
	private EditText EditName;
	private EditText EditAim;
	private EditText EditDetail;
	private TextView TextType;
	private TextView TextParty;
	private TextView TextTime;
	private ImageView ImageBack;
	private ImageView ImageTime;
	private ImageView ImageType;
	private ImageView ImageParty;
	private Button BtnConfirm;
	private String Name;
	private String Aim;
	private String Detail;
	private String Type;
	private String Party;
	private String Time;
	private static final int REQUEST_TYPE_CODE = 0;
	private static final int REQUEST_TIME_CODE = 1;
	private static final int REQUEST_BRANCH_CODE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.apply_for_assistance);
		initview();
		setonclicklistener();
	}

	private void initview() {
		// TODO Auto-generated method stub
		EditName = (EditText) findViewById(R.id.edit_name);
		EditAim = (EditText) findViewById(R.id.edit_aim);
		EditDetail = (EditText) findViewById(R.id.edit_detail);
		TextType = (TextView) findViewById(R.id.text_type);
		TextParty = (TextView) findViewById(R.id.text_party);
		TextTime = (TextView) findViewById(R.id.text_time);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageTime = (ImageView) findViewById(R.id.image_time);
		ImageType = (ImageView) findViewById(R.id.image_type);
		ImageParty = (ImageView) findViewById(R.id.image_party);
		BtnConfirm = (Button) findViewById(R.id.btn_apply_confirm);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		TextType.setOnClickListener(this);
		TextParty.setOnClickListener(this);
		TextTime.setOnClickListener(this);
		ImageBack.setOnClickListener(this);
		ImageTime.setOnClickListener(this);
		ImageType.setOnClickListener(this);
		ImageParty.setOnClickListener(this);
		BtnConfirm.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_apply_confirm:
			Name = EditName.getText().toString();
			Aim = EditAim.getText().toString();
			Detail = EditDetail.getText().toString();
			if (TextUtils.isEmpty(Name)) {
				Toast.makeText(getApplicationContext(), "姓名不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(Aim)) {
				Toast.makeText(getApplicationContext(), "申请目标不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(Detail)) {
				Toast.makeText(getApplicationContext(), "申请理由不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(Party)) {
				Toast.makeText(getApplicationContext(), "党员所属组织不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(Type)) {
				Toast.makeText(getApplicationContext(), "补助类型不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(Time)) {
				Toast.makeText(getApplicationContext(), "申请期限不可为空", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "申请", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.image_back:
			finish();
			break;
		case R.id.text_time:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), AssistanceTimeChooseActivity.class);
			startActivityForResult(intent, REQUEST_TIME_CODE);
			break;
		case R.id.text_type:
			Intent intent1 = new Intent();
			intent1.setClass(getApplicationContext(), AssistanceTypeChooseActivity.class);
			startActivityForResult(intent1, REQUEST_TYPE_CODE);
			break;
		case R.id.text_party:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(), PartyBranchChooseActivity.class);
			startActivityForResult(intent2, REQUEST_BRANCH_CODE);
			break;
		case R.id.image_time:
			Intent intent3 = new Intent();
			intent3.setClass(getApplicationContext(), AssistanceTimeChooseActivity.class);
			startActivityForResult(intent3, REQUEST_TIME_CODE);
			break;
		case R.id.image_type:
			Intent intent4 = new Intent();
			intent4.setClass(getApplicationContext(), AssistanceTypeChooseActivity.class);
			startActivityForResult(intent4, REQUEST_TYPE_CODE);
			break;
		case R.id.image_party:
			Intent intent5 = new Intent();
			intent5.setClass(getApplicationContext(), PartyBranchChooseActivity.class);
			startActivityForResult(intent5, REQUEST_BRANCH_CODE);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (data == null)
			return;
		Bundle bundle = data.getExtras();
		switch (requestCode) {
		case REQUEST_BRANCH_CODE:
			Party = bundle.getString("Branch");
			TextParty.setText(Party);
			break;
		case REQUEST_TIME_CODE:
			Time = bundle.getString("Time");
			TextTime.setText(Time);
			break;
		case REQUEST_TYPE_CODE:
			Type = bundle.getString("Type");
			TextType.setText(Type);
			break;
		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
}
