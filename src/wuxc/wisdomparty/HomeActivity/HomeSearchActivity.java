package wuxc.wisdomparty.HomeActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import single.wuxc.wisdomparty.R.string;
import wuxc.wisdomparty.HomeOfMember.SearchDataListActivity;
import android.view.View.OnClickListener;

public class HomeSearchActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private EditText EditSearch;
	private TextView TextSearch;
	private TextView TextSearchShortCutLabel1;
	private TextView TextSearchShortCutLabel2;
	private TextView TextSearchShortCutLabel3;
	private TextView TextSearchShortCutLabel4;
	private TextView TextSearchShortCutLabel5;
	private TextView TextSearchShortCutLabel6;
	private TextView TextSearchShortCutLabel7;
	private TextView TextSearchShortCutLabel8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_search_activity);
		initview();
		setonclicklistener();
	}

	private void initview() {
		// TODO Auto-generated method stub
		ImageBack = (ImageView) findViewById(R.id.image_back);
		TextSearch = (TextView) findViewById(R.id.text_search);
		EditSearch = (EditText) findViewById(R.id.edit_search);
		TextSearchShortCutLabel1 = (TextView) findViewById(R.id.search_shortcutkey_label1);
		TextSearchShortCutLabel2 = (TextView) findViewById(R.id.search_shortcutkey_label2);
		TextSearchShortCutLabel3 = (TextView) findViewById(R.id.search_shortcutkey_label3);
		TextSearchShortCutLabel4 = (TextView) findViewById(R.id.search_shortcutkey_label4);
		TextSearchShortCutLabel5 = (TextView) findViewById(R.id.search_shortcutkey_label5);
		TextSearchShortCutLabel6 = (TextView) findViewById(R.id.search_shortcutkey_label6);
		TextSearchShortCutLabel7 = (TextView) findViewById(R.id.search_shortcutkey_label7);
		TextSearchShortCutLabel8 = (TextView) findViewById(R.id.search_shortcutkey_label8);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		TextSearch.setOnClickListener(this);
		TextSearchShortCutLabel1.setOnClickListener(this);
		TextSearchShortCutLabel2.setOnClickListener(this);
		TextSearchShortCutLabel3.setOnClickListener(this);
		TextSearchShortCutLabel4.setOnClickListener(this);
		TextSearchShortCutLabel5.setOnClickListener(this);
		TextSearchShortCutLabel6.setOnClickListener(this);
		TextSearchShortCutLabel7.setOnClickListener(this);
		TextSearchShortCutLabel8.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.text_search:
			String temp = EditSearch.getText().toString();
			if (!(temp == null || temp.equals(""))) {
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), SearchDataListActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("search_text", temp);
				intent.putExtras(bundle);
				startActivity(intent);
			} else {
				Toast.makeText(getApplicationContext(), "«Î ‰»Î≤È’“ƒ⁄»›", Toast.LENGTH_SHORT).show();
			}

			break;
		case R.id.search_shortcutkey_label1:
			Intent intent1 = new Intent();
			intent1.setClass(getApplicationContext(), SearchDataListActivity.class);
			Bundle bundle1 = new Bundle();
			bundle1.putString("search_text", TextSearchShortCutLabel1.getText().toString());
			intent1.putExtras(bundle1);
			startActivity(intent1);
			break;
		case R.id.search_shortcutkey_label2:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(), SearchDataListActivity.class);
			Bundle bundle2 = new Bundle();
			bundle2.putString("search_text", TextSearchShortCutLabel2.getText().toString());
			intent2.putExtras(bundle2);
			startActivity(intent2);
			break;
		case R.id.search_shortcutkey_label3:
			Intent intent3 = new Intent();
			intent3.setClass(getApplicationContext(), SearchDataListActivity.class);
			Bundle bundle3 = new Bundle();
			bundle3.putString("search_text", TextSearchShortCutLabel3.getText().toString());
			intent3.putExtras(bundle3);
			startActivity(intent3);
			break;
		case R.id.search_shortcutkey_label4:
			Intent intent4 = new Intent();
			intent4.setClass(getApplicationContext(), SearchDataListActivity.class);
			Bundle bundle4 = new Bundle();
			bundle4.putString("search_text", TextSearchShortCutLabel4.getText().toString());
			intent4.putExtras(bundle4);
			startActivity(intent4);
			break;
		case R.id.search_shortcutkey_label5:
			Intent intent5 = new Intent();
			intent5.setClass(getApplicationContext(), SearchDataListActivity.class);
			Bundle bundle5 = new Bundle();
			bundle5.putString("search_text", TextSearchShortCutLabel5.getText().toString());
			intent5.putExtras(bundle5);
			startActivity(intent5);
			break;
		case R.id.search_shortcutkey_label6:
			Intent intent6 = new Intent();
			intent6.setClass(getApplicationContext(), SearchDataListActivity.class);
			Bundle bundle6 = new Bundle();
			bundle6.putString("search_text", TextSearchShortCutLabel6.getText().toString());
			intent6.putExtras(bundle6);
			startActivity(intent6);
			break;
		case R.id.search_shortcutkey_label7:
			Intent intent7 = new Intent();
			intent7.setClass(getApplicationContext(), SearchDataListActivity.class);
			Bundle bundle7 = new Bundle();
			bundle7.putString("search_text", TextSearchShortCutLabel7.getText().toString());
			intent7.putExtras(bundle7);
			startActivity(intent7);
			break;
		case R.id.search_shortcutkey_label8:
			Intent intent8 = new Intent();
			intent8.setClass(getApplicationContext(), SearchDataListActivity.class);
			Bundle bundle8 = new Bundle();
			bundle8.putString("search_text", TextSearchShortCutLabel8.getText().toString());
			intent8.putExtras(bundle8);
			startActivity(intent8);
			break;
		default:
			break;
		}
	}

}
