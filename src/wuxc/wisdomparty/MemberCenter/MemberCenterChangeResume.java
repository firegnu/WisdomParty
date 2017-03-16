package wuxc.wisdomparty.MemberCenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Window;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Internet.GetBitmapFromServer;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.layout.RoundedImageView;
import wuxc.wisdomparty.layout.dialogtwo;

public class MemberCenterChangeResume extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private RoundedImageView RoundedHeadImg;
	private ImageView ImageHeadParty;
	private TextView TextName;
	private TextView TextSex;
	private TextView TextIfParty;
	private EditText EditName;
	private EditText EditPhoneNumber;
	private EditText EditAddress;
	private EditText EditPartyAge;
	private EditText EditMotto;
	private Button BtnChange;
	private String StrName;
	private String StrNameList;
	private String StrSex;
	private String StrPhoneNumber;
	private String StrAddress;
	private String StrIfParty;
	private String StrPartyAge;
	private String StrMotto;
	private String LoginId;
	private String ticket;
	private String userPhoto;
	private SharedPreferences PreUserInfo;// 存储个人信息
	private final static int GET_USER_HEAD_IMAGE = 6;
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
		setContentView(R.layout.member_center_changeresume);
		PreUserInfo = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		RoundedHeadImg = (RoundedImageView) findViewById(R.id.rounded_headimg);
		ImageHeadParty = (ImageView) findViewById(R.id.image_head_party);
		TextName = (TextView) findViewById(R.id.text_name);
		TextSex = (TextView) findViewById(R.id.text_sex);
		TextIfParty = (TextView) findViewById(R.id.text_ifparty);
		EditName = (EditText) findViewById(R.id.edit_name);
		EditPhoneNumber = (EditText) findViewById(R.id.edit_phonenumber);
		EditAddress = (EditText) findViewById(R.id.edit_address);
		EditPartyAge = (EditText) findViewById(R.id.edit_partyage);
		EditMotto = (EditText) findViewById(R.id.edit_motto);
		BtnChange = (Button) findViewById(R.id.btn_change);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageBack.setOnClickListener(this);
		BtnChange.setOnClickListener(this);
		TextSex.setOnClickListener(this);
		TextIfParty.setOnClickListener(this);
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

	private void ReadTicket() {
		// TODO Auto-generated method stub
		LoginId = PreUserInfo.getString("loginId", null);
		ticket = PreUserInfo.getString("ticket", null);
		userPhoto = PreUserInfo.getString("userPhoto", null);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;

		case R.id.btn_change:
			StrNameList = EditName.getText().toString();
			StrPhoneNumber = EditPhoneNumber.getText().toString();
			StrAddress = EditAddress.getText().toString();
			StrPartyAge = EditPartyAge.getText().toString();
			StrMotto = EditMotto.getText().toString();
			if (TextUtils.isEmpty(StrNameList)) {
				Toast.makeText(getApplicationContext(), "请输入姓名", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrAddress)) {
				Toast.makeText(getApplicationContext(), "请输入地址", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrPhoneNumber)) {
				Toast.makeText(getApplicationContext(), "请输入电话号码", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrPartyAge)) {
				Toast.makeText(getApplicationContext(), "请输入党龄", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrMotto)) {
				Toast.makeText(getApplicationContext(), "请输入个性签名", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrSex)) {
				Toast.makeText(getApplicationContext(), "请选择您的性别", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrIfParty)) {
				Toast.makeText(getApplicationContext(), "请选择是否是党员", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "完成", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.text_sex:
			showAlertDialog("请选择您的性别", "男", "女", 1);
			break;
		case R.id.text_ifparty:
			showAlertDialog("您是否是党员？", "是", "否", 2);
			break;
		default:
			break;

		}
	}

	public void showAlertDialog(String arg, final String firstlabel, final String secondlabel, final int type) {
		// 1-sex
		// 2-ifparty

		dialogtwo.Builder builder = new dialogtwo.Builder(this);
		builder.setMessage(arg);
		builder.setTitle("信息修改");
		builder.setPositiveButton(firstlabel, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				if (type == 1) {
					StrSex = firstlabel;
					TextSex.setText(StrSex);
				} else {
					StrIfParty = firstlabel;
					TextIfParty.setText(StrIfParty);
				}
			}
		});

		builder.setNegativeButton(secondlabel, new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				if (type == 1) {
					StrSex = secondlabel;
					TextSex.setText(StrSex);
				} else {
					StrIfParty = secondlabel;
					TextIfParty.setText(StrIfParty);
				}
			}
		});

		builder.create().show();

	}
}
