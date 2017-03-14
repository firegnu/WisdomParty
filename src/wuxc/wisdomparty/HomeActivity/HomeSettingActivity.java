package wuxc.wisdomparty.HomeActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.StartPage.LoginAactivity;
import wuxc.wisdomparty.main.MainActivity;
import android.view.View.OnClickListener;

public class HomeSettingActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private Button BtnExit;
	private boolean IsExit = true;
	private MainActivity MainActivity;
	private SharedPreferences PreAccount;// 存储用户名和密码，用于自动登录

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_setting_activity);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageBack.setOnClickListener(this);
		BtnExit = (Button) findViewById(R.id.btn_exit);
		BtnExit.setOnClickListener(this);
		PreAccount = getSharedPreferences("Account", Context.MODE_PRIVATE);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.btn_exit:
			if (IsExit) {
				IsExit = false;
				Intent intent_test = new Intent();
				intent_test.setClass(getApplicationContext(), LoginAactivity.class);
				startActivity(intent_test);
				finish();
				MainActivity.activity.finish();
				WriteAccount();
			}

			break;
		default:
			break;
		}
	}

	private void WriteAccount() {
		// TODO Auto-generated method stub

		Editor edit = PreAccount.edit();
		edit.putString("LoginId", null);
		edit.putString("pwd", null);
		edit.commit();

	}
}
