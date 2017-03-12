package wuxc.wisdomparty.HomeOfMember;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;

import com.umeng.socialize.utils.Log;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Internet.HttpGetData;
import wuxc.wisdomparty.Internet.URLcontainer;

public class LoginAactivity extends Activity implements OnClickListener {
	private boolean IsAutoLogin = true;// 自动登录标志字
	private boolean IsLogin = true;// 防止重复点击
	private ImageView ImageFinish;
	private EditText EditAccount;
	private EditText EditPassword;
	private Button BtnLogin;
	private ImageView ImageCheck;
	private TextView TextAutoLogin;
	private TextView TextToRegister;
	private SharedPreferences PreAccount;// 存储用户名和密码，用于自动登录
	private SharedPreferences PreUserInfo;// 存储个人信息
	private static final String ERROR_CODE = "0204";
	private static final int GET_LOGININ_RESULT_DATA = 1;
	private Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_LOGININ_RESULT_DATA:
				GetDataDetailFromLoginResultData(msg.obj);
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_activity);
		initview();
		setonclicklistener();
	}

	public void GetDataDetailFromLoginResultData(Object obj) {
		// TODO Auto-generated method stub
		Log.e("LoginAactivity.HttpGetData", obj.toString());
	}

	private void initview() {
		// TODO Auto-generated method stub
		PreUserInfo = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		PreAccount = getSharedPreferences("Account", Context.MODE_PRIVATE);
		ImageFinish = (ImageView) findViewById(R.id.image_finish);
		EditAccount = (EditText) findViewById(R.id.edit_account);
		EditPassword = (EditText) findViewById(R.id.edit_password);
		BtnLogin = (Button) findViewById(R.id.btn_login);
		ImageCheck = (ImageView) findViewById(R.id.image_check);
		TextAutoLogin = (TextView) findViewById(R.id.text_auto_login);
		TextToRegister = (TextView) findViewById(R.id.text_toregister);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageFinish.setOnClickListener(this);
		BtnLogin.setOnClickListener(this);
		ImageCheck.setOnClickListener(this);
		TextAutoLogin.setOnClickListener(this);
		TextToRegister.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_finish:
			finish();
			break;
		case R.id.btn_login:
			String StrAccount;
			String StrPassword;
			StrAccount = EditAccount.getText().toString();
			StrPassword = EditPassword.getText().toString();
			if (StrAccount.equals("") || StrAccount == null) {
				Toast.makeText(getApplicationContext(), "账户名不可为空", Toast.LENGTH_SHORT).show();
			} else if (StrPassword.equals("") || StrPassword == null) {
				Toast.makeText(getApplicationContext(), "密码不可为空", Toast.LENGTH_SHORT).show();
			} else {
				if (IsAutoLogin) {
					final ArrayList ArrayValues = new ArrayList();
					ArrayValues.add(new BasicNameValuePair("login_id", StrAccount));
					ArrayValues.add(new BasicNameValuePair("pwd", StrPassword));
					new Thread(new Runnable() { // 开启线程上传文件
						@Override
						public void run() {
							String LoginResultData = "";
							LoginResultData = HttpGetData.GetData(URLcontainer.LoginIn, ArrayValues);
							Message msg = new Message();
							msg.obj = LoginResultData;
							msg.what = GET_LOGININ_RESULT_DATA;
							uiHandler.sendMessage(msg);
						}
					}).start();

				}
				// Toast.makeText(getApplicationContext(), "登陆成功",
				// Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.text_toregister:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), RegisterActivity.class);
			startActivity(intent);
			break;
		case R.id.image_check:
			if (IsAutoLogin) {
				IsAutoLogin = false;
				ImageCheck.setImageResource(R.drawable.check_no);
			} else {
				IsAutoLogin = true;
				ImageCheck.setImageResource(R.drawable.check_yes);
			}
			break;
		case R.id.text_auto_login:
			if (IsAutoLogin) {
				IsAutoLogin = false;
				ImageCheck.setImageResource(R.drawable.check_no);
			} else {
				IsAutoLogin = true;
				ImageCheck.setImageResource(R.drawable.check_yes);
			}
			break;
		default:
			break;
		}
	}

}
