package wuxc.wisdomparty.MemberCenter;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Internet.HttpGetData;
import wuxc.wisdomparty.Internet.URLcontainer;

public class NoticeDetailActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private String Keyid;
	private String ticket;
	private static final int GET_NOTICE_DATA = 6;
	private TextView TextContent;
	private TextView TextTitle;
	private TextView TextFrom;
	private TextView TextTime;
	private String sendUserName;
	private static final String GET_SUCCESS_RESULT = "success";
	public Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_NOTICE_DATA:
				GetDataNoticeData(msg.obj);
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
		setContentView(R.layout.noticedetailactivity);
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象
		Keyid = bundle.getString("Keyid");
		ticket = bundle.getString("ticket");
		sendUserName = bundle.getString("sendUserName");
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageBack.setOnClickListener(this);
		TextContent = (TextView) findViewById(R.id.text_content);
		TextTitle = (TextView) findViewById(R.id.text_title);
		TextFrom = (TextView) findViewById(R.id.text_from);
		TextTime = (TextView) findViewById(R.id.text_time);
		GetNoticeDataDetail();
		Toast.makeText(getApplicationContext(), "正在加载数据", Toast.LENGTH_SHORT).show();
	}

	protected void GetDataNoticeData(Object obj) {
		String Type = null;
		String Data = null;
		try {
			JSONObject demoJson = new JSONObject(obj.toString());
			Type = demoJson.getString("type");
			Data = demoJson.getString("data");
			if (Type.equals(GET_SUCCESS_RESULT)) {
				GetData(Data);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void GetData(String data) {
		// TODO Auto-generated method stub
		String title = null;
		String content = "无内容";
		String sendDate = null;
		try {
			JSONObject demoJson = new JSONObject(data);

			title = demoJson.getString("title");
			try {
				content = demoJson.getString("content");
			} catch (Exception e) {
				// TODO: handle exception
			}

			sendDate = demoJson.getString("sendDate");
			TextContent.setText(content);
			TextTime.setText("时间：" + sendDate);
			TextFrom.setText("发件人：" + sendUserName);
			TextTitle.setText(title);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void GetNoticeDataDetail() {
		// TODO Auto-generated method stub
		final ArrayList ArrayValues = new ArrayList();
		ArrayValues.add(new BasicNameValuePair("ticket", ticket));
		ArrayValues.add(new BasicNameValuePair("datakey", Keyid));
		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				String NoticeData = "";
				NoticeData = HttpGetData.GetData(URLcontainer.GetJsonData_2, ArrayValues);
				Message msg = new Message();
				msg.obj = NoticeData;
				msg.what = GET_NOTICE_DATA;
				uiHandler.sendMessage(msg);
			}
		}).start();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intentresult = new Intent();
			setResult(0, intentresult);
			finish();
		}
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			Intent intentresult = new Intent();
			setResult(0, intentresult);
			finish();
			break;

		default:
			break;
		}
	}
}
