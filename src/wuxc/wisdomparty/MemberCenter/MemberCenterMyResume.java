package wuxc.wisdomparty.MemberCenter;

import android.R.bool;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Internet.GetBitmapFromServer;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.Internet.getImageAbsolutePath;
import wuxc.wisdomparty.layout.RoundedImageView;

public class MemberCenterMyResume extends Activity implements OnClickListener {
	private TextView TextChange;
	private TextView TextChangeImg;
	private TextView TextMyRank;
	private ImageView ImageBack;
	private RoundedImageView RoundedHeadImg;
	private ImageView ImageHeadParty;
	private TextView TextName;
	private TextView TextNameList;
	private TextView TextSex;
	private TextView TextPhoneNumber;
	private TextView TextAddress;
	private TextView TextIfParty;
	private TextView TextPartyAge;
	private TextView TextMotto;
	private String StrName;
	private String StrNameList;
	private String StrSex;
	private String StrPhoneNumber;
	private String StrAddress;
	private String StrIfParty;
	private String StrPartyAge;
	private String StrMotto;
	private SharedPreferences PreUserInfo;// 存储个人信息
	private String LoginId;
	private String ticket;
	private String userPhoto;
	private final static int GET_USER_HEAD_IMAGE = 6;
	private final static int GO_CHANGE_HEADIMG = 8;
	private boolean UploadImage = false;
	private Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_USER_HEAD_IMAGE:
				ShowHeadImage(msg.obj);
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
		setContentView(R.layout.member_center_myresume);
		PreUserInfo = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		RoundedHeadImg = (RoundedImageView) findViewById(R.id.rounded_headimg);
		ImageHeadParty = (ImageView) findViewById(R.id.image_head_party);
		TextName = (TextView) findViewById(R.id.text_name);
		TextNameList = (TextView) findViewById(R.id.text_name_list);
		TextSex = (TextView) findViewById(R.id.text_sex);
		TextPhoneNumber = (TextView) findViewById(R.id.text_phonenumber);
		TextAddress = (TextView) findViewById(R.id.text_address);
		TextIfParty = (TextView) findViewById(R.id.text_ifparty);
		TextPartyAge = (TextView) findViewById(R.id.text_partyage);
		TextMotto = (TextView) findViewById(R.id.text_motto);
		TextChange = (TextView) findViewById(R.id.text_change);
		TextChangeImg = (TextView) findViewById(R.id.text_changeimg);
		TextMyRank = (TextView) findViewById(R.id.text_myrank);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		TextChange.setOnClickListener(this);
		TextChangeImg.setOnClickListener(this);
		TextMyRank.setOnClickListener(this);
		ImageBack.setOnClickListener(this);
		ReadTicket();
		GetHeadPic();
	}

	protected void ShowHeadImage(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj == null)) {
			try {
				Bitmap HeadImage = (Bitmap) obj;
				RoundedHeadImg.setImageBitmap(HeadImage);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void GetHeadPic() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				Bitmap HeadImage = null;
				HeadImage = GetBitmapFromServer
						.getBitmapFromServer(URLcontainer.urlip + URLcontainer.GetFile + userPhoto);
				Message msg = new Message();
				msg.what = GET_USER_HEAD_IMAGE;
				msg.obj = HeadImage;
				uiHandler.sendMessage(msg);
			}
		}).start();
	}

	private void ReadTicket() {
		// TODO Auto-generated method stub
		LoginId = PreUserInfo.getString("loginId", null);
		ticket = PreUserInfo.getString("ticket", null);
		userPhoto = PreUserInfo.getString("userPhoto", null);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data == null)
			return;
		Bundle bundle = data.getExtras();
		switch (requestCode) {
		case GO_CHANGE_HEADIMG:
			if (!(data == null)) {
				boolean Result = bundle.getBoolean("UploadImage", false);
				UploadImage = Result;
				if (Result) {
					ReadTicket();

					GetHeadPic();
				}
			}

			break;

		default:
			break;

		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			Intent intentresult = new Intent();

			intentresult.putExtra("UploadImage", UploadImage);

			setResult(0, intentresult);
			finish();
			break;
		case R.id.text_change:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), MemberCenterChangeResume.class);
			startActivity(intent);
			break;
		case R.id.text_changeimg:
			Intent intent1 = new Intent();
			intent1.setClass(getApplicationContext(), MemberCenterMyHeadimg.class);
			startActivityForResult(intent1, GO_CHANGE_HEADIMG);
			break;
		case R.id.text_myrank:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(), MemberCenterMyRank.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intentresult = new Intent();

			intentresult.putExtra("UploadImage", UploadImage);

			setResult(0, intentresult);
			finish();
		}
		return false;
	}
}
