package wuxc.wisdomparty.HomeOfMember;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import android.view.Window;

public class LoginAactivity extends Activity implements OnClickListener {
	private boolean IsAutoLogin = true;
	private ImageView ImageFinish;
	private EditText EditAccount;
	private EditText EditPassword;
	private String StrAccount;
	private String StrPassword;
	private Button BtnLogin;
	private ImageView ImageCheck;
	private TextView TextAutoLogin;
	private TextView TextToRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login_activity);
		initview();
		setonclicklistener();
	}

	private void initview() {
		// TODO Auto-generated method stub
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
			StrAccount = EditAccount.getText().toString();
			StrPassword = EditPassword.getText().toString();
			if (StrAccount.equals("") || StrAccount == null) {
				Toast.makeText(getApplicationContext(), "账户名不可为空", Toast.LENGTH_SHORT).show();
			} else if (StrPassword.equals("") || StrPassword == null) {
				Toast.makeText(getApplicationContext(), "密码不可为空", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
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
				ImageCheck.setImageResource (R.drawable.check_no);
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
