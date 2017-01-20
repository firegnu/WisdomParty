package wuxc.wisdomparty.HomeOfHealth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import single.wuxc.wisdomparty.R;

public class yaodian extends Activity implements OnClickListener {
	private ImageView image_back;
	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	private ImageView image4;
	private ImageView image5;
	private ImageView image6;
	private ImageView image7;
	private ImageView image8;
	private ImageView image9;
	private ImageView image10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yaodian);
		image_back = (ImageView) findViewById(R.id.image_back);
		image1 = (ImageView) findViewById(R.id.image1);
		image2 = (ImageView) findViewById(R.id.image2);
		image3 = (ImageView) findViewById(R.id.image3);
		image4 = (ImageView) findViewById(R.id.image4);
		image5 = (ImageView) findViewById(R.id.image5);
		image6 = (ImageView) findViewById(R.id.image6);
		image7 = (ImageView) findViewById(R.id.image7);
		image8 = (ImageView) findViewById(R.id.image8);
		image9 = (ImageView) findViewById(R.id.image9);
		image10 = (ImageView) findViewById(R.id.image10);
		image1.setOnClickListener(this);
		image1.setOnClickListener(this);

		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		image6.setOnClickListener(this);
		image_back.setOnClickListener(this);
		image7.setOnClickListener(this);
		image8.setOnClickListener(this);
		image9.setOnClickListener(this);
		image10.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// Intent intent = new Intent();
		// intent.setClass(getApplicationContext(),
		// SpecialDetailActivity.class);
		// Bundle bundle = new Bundle();
		// bundle.putString("Title", "中央党史研究新成果");
		// bundle.putString("Time", "2016-11-23");
		// bundle.putString("Name", "小李");
		// intent.putExtras(bundle);

		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.image_back:
			finish();
			break;
		// case R.id.image1:
		// startActivity(intent);
		// break;
		// case R.id.image2:
		// startActivity(intent);
		// break;
		// case R.id.image3:
		// startActivity(intent);
		// break;
		// case R.id.image4:
		// startActivity(intent);
		// break;
		// case R.id.image5:
		// startActivity(intent);
		// break;
		// case R.id.image6:
		// startActivity(intent);
		// break;
		// case R.id.image7:
		// startActivity(intent);
		// break;
		// case R.id.image8:
		// startActivity(intent);
		// break;
		// case R.id.image9:
		// startActivity(intent);
		// break;
		// case R.id.image10:
		// startActivity(intent);
		// break;
		default:
			break;
		}
	}

}
