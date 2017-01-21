package wuxc.wisdomparty.MemberCenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_myresume);
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
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
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
			startActivity(intent1);
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

}
