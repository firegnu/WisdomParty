package wuxc.wisdomparty.HomeActivity;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Internet.APPVersion;
import wuxc.wisdomparty.Internet.HttpGetData;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.StartPage.LoginAactivity;
import wuxc.wisdomparty.layout.dialogtwo;
import wuxc.wisdomparty.main.MainActivity;
import android.view.View.OnClickListener;

public class HomeSettingActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private Button BtnExit;
	private boolean IsExit = true;
	private MainActivity MainActivity;
	private SharedPreferences PreAccount;// 存储用户名和密码，用于自动登录
	private LinearLayout LinGetNewVersion;
	private boolean IsGetNewVersion = true;
	private String ticket;
	private SharedPreferences PreUserInfo;// 存储个人信息
	private static final int GET_VERSION_RESULT = 1;
	private Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_VERSION_RESULT:
				GetDataDetailFromVersion(msg.obj);
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
		setContentView(R.layout.home_setting_activity);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageBack.setOnClickListener(this);
		BtnExit = (Button) findViewById(R.id.btn_exit);
		BtnExit.setOnClickListener(this);
		LinGetNewVersion = (LinearLayout) findViewById(R.id.lin_getnewversion);
		LinGetNewVersion.setOnClickListener(this);
		PreUserInfo = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		PreAccount = getSharedPreferences("Account", Context.MODE_PRIVATE);
		ReadTicket();
	}

	protected void GetDataDetailFromVersion(Object obj) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String versionId = null;
		String versionNum = null;
		String versionPath = null;
		IsGetNewVersion = true;
		try {
			JSONObject demoJson = new JSONObject(obj.toString());
			versionId = demoJson.getString("versionId");
			versionNum = demoJson.getString("versionNum");
			versionPath = demoJson.getString("versionPath");
			if (versionId.equals(APPVersion.APPVersion)) {
				Toast.makeText(getApplicationContext(), "已是最新版本", Toast.LENGTH_SHORT).show();
			} else {
				showAlertDialog(versionNum, versionPath);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void showAlertDialog(String versionNum, final String versionPath) {

		dialogtwo.Builder builder = new dialogtwo.Builder(this);
		builder.setMessage("是否更新新版本？\n" + "版本号：" + versionNum);
		builder.setTitle("版本更新");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Intent intent = new Intent();
				intent.setAction("android.intent.action.VIEW");
				String path = URLcontainer.urlip + URLcontainer.GetFile + versionPath;
				Uri content_url = Uri.parse(path);
				intent.setData(content_url);
				startActivity(intent);

			}
		});

		builder.setNegativeButton("取消", new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		builder.create().show();

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
		case R.id.lin_getnewversion:
			if (IsGetNewVersion) {
				final ArrayList ArrayValues = new ArrayList();
				ArrayValues.add(new BasicNameValuePair("ticket", ticket));
				new Thread(new Runnable() { // 开启线程上传文件
					@Override
					public void run() {
						String LoginResultData = "";
						LoginResultData = HttpGetData.GetData(URLcontainer.GetLatestVersion, ArrayValues);
						Message msg = new Message();
						msg.obj = LoginResultData;
						msg.what = GET_VERSION_RESULT;
						uiHandler.sendMessage(msg);
					}
				}).start();
				IsGetNewVersion = false;
			}
			break;
		default:
			break;
		}
	}

	private void ReadTicket() {
		// TODO Auto-generated method stub
		ticket = PreUserInfo.getString("ticket", null);
	}

	private void WriteAccount() {
		// TODO Auto-generated method stub

		Editor edit = PreAccount.edit();
		edit.putString("LoginId", null);
		edit.putString("pwd", null);
		edit.commit();

	}
}
