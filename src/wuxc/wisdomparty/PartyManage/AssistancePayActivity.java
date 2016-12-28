package wuxc.wisdomparty.PartyManage;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.dialogtwo;

public class AssistancePayActivity extends Activity implements OnClickListener {

	private Button btn_10yuan;
	private Button btn_20yuan;
	private Button btn_30yuan;
	private Button btn_40yuan;
	private Button btn_50yuan;
	private Button btn_100yuan;
	private Button btn_200yuan;
	private Button btn_300yuan;
	private Button btn_400yuan;
	private Button btn_500yuan;
	private Button btn_submit;
	private int rechargemoney = 0;
	private String othermaney;
	private EditText edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.assistance_pay_detail);
		btn_10yuan = (Button) findViewById(R.id.btn_10yuan);
		btn_20yuan = (Button) findViewById(R.id.btn_20yuan);
		btn_30yuan = (Button) findViewById(R.id.btn_30yuan);
		btn_40yuan = (Button) findViewById(R.id.btn_40yuan);
		btn_50yuan = (Button) findViewById(R.id.btn_50yuan);
		btn_100yuan = (Button) findViewById(R.id.btn_100yuan);
		btn_200yuan = (Button) findViewById(R.id.btn_200yuan);
		btn_300yuan = (Button) findViewById(R.id.btn_300yuan);
		btn_400yuan = (Button) findViewById(R.id.btn_400yuan);
		btn_500yuan = (Button) findViewById(R.id.btn_500yuan);
		btn_submit = (Button) findViewById(R.id.btn_submit);
		btn_10yuan.setOnClickListener(this);
		btn_20yuan.setOnClickListener(this);
		btn_30yuan.setOnClickListener(this);
		btn_40yuan.setOnClickListener(this);
		btn_50yuan.setOnClickListener(this);
		btn_100yuan.setOnClickListener(this);
		btn_200yuan.setOnClickListener(this);
		btn_300yuan.setOnClickListener(this);
		btn_400yuan.setOnClickListener(this);
		btn_500yuan.setOnClickListener(this);
		btn_submit.setOnClickListener(this);
		edit = (EditText) findViewById(R.id.edit);
		edit.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				rechargemoney = 0;
				btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
				btn_10yuan.setTextColor(0xff000000);
				btn_20yuan.setTextColor(0xff000000);
				btn_30yuan.setTextColor(0xff000000);
				btn_40yuan.setTextColor(0xff000000);
				btn_50yuan.setTextColor(0xff000000);
				btn_100yuan.setTextColor(0xff000000);
				btn_200yuan.setTextColor(0xff000000);
				btn_300yuan.setTextColor(0xff000000);
				btn_400yuan.setTextColor(0xff000000);
				btn_500yuan.setTextColor(0xff000000);
				othermaney = s.toString();
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.btn_10yuan:
			rechargemoney = 10;
			btn_10yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xffffffff);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_20yuan:
			rechargemoney = 20;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xffffffff);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_30yuan:
			rechargemoney = 30;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xffffffff);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_40yuan:
			rechargemoney = 40;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xffffffff);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_50yuan:
			rechargemoney = 50;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xffffffff);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_100yuan:
			rechargemoney = 100;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xffffffff);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_200yuan:
			rechargemoney = 200;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xffffffff);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_300yuan:
			rechargemoney = 300;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xffffffff);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_400yuan:
			rechargemoney = 400;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_500yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xffffffff);
			btn_500yuan.setTextColor(0xff000000);
			break;
		case R.id.btn_500yuan:
			rechargemoney = 500;
			btn_10yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_20yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_30yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_40yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_50yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_100yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_200yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_300yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_400yuan.setBackgroundResource(R.drawable.shapestroke);
			btn_500yuan.setBackgroundResource(R.drawable.shapestrokered);
			btn_10yuan.setTextColor(0xff000000);
			btn_20yuan.setTextColor(0xff000000);
			btn_30yuan.setTextColor(0xff000000);
			btn_40yuan.setTextColor(0xff000000);
			btn_50yuan.setTextColor(0xff000000);
			btn_100yuan.setTextColor(0xff000000);
			btn_200yuan.setTextColor(0xff000000);
			btn_300yuan.setTextColor(0xff000000);
			btn_400yuan.setTextColor(0xff000000);
			btn_500yuan.setTextColor(0xffffffff);
			break;
		case R.id.btn_submit:
			if (rechargemoney != 0) {
				PayConfirm("" + rechargemoney);
			} else if (!TextUtils.isEmpty(othermaney)) {
				PayConfirm(othermaney);
			} else {
				Toast.makeText(getApplicationContext(), "请选择或输入金额", Toast.LENGTH_SHORT).show();
			}
			break;
		default:
			break;
		}
	}

	public void PayConfirm(String arg) {

		dialogtwo.Builder builder = new dialogtwo.Builder(this);
		builder.setMessage("您将支付" + arg + "元用于捐助");
		builder.setTitle("缴费确认");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();

			}
		});

		builder.setNegativeButton("取消", new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		builder.create().show();

	}
}
