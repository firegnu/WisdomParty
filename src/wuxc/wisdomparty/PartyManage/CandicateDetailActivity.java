package wuxc.wisdomparty.PartyManage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;
import android.view.Window;

public class CandicateDetailActivity extends Activity implements OnClickListener {
	private RoundImageView RoundHeadimg;
	private ImageView ImageBack;
	private ImageView ImageSymbol;
	private ImageView ImageSelected;
	private TextView TextName;
	private TextView TextPartyMember;
	private TextView TextNumber;
	private TextView TextDetail;
	private String Name;
	private String Number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.candicate_detail_activity);
		initview();
		setonclick();
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象
		Name = bundle.getString("Name");
		Number = bundle.getString("Number");
		TextName.setText(Name);
		TextNumber.setText("当前票数：" + Number);
	}

	private void initview() {
		// TODO Auto-generated method stub
		RoundHeadimg = (RoundImageView) findViewById(R.id.round_headimg);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageSymbol = (ImageView) findViewById(R.id.image_symbol);
		ImageSelected = (ImageView) findViewById(R.id.image_selected);
		TextName = (TextView) findViewById(R.id.text_name);
		TextPartyMember = (TextView) findViewById(R.id.text_party_member);
		TextNumber = (TextView) findViewById(R.id.text_number);
		TextDetail = (TextView) findViewById(R.id.text_detail);
	}

	private void setonclick() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		ImageSelected.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.image_selected:
			Toast.makeText(getApplicationContext(), "选举", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}

}
