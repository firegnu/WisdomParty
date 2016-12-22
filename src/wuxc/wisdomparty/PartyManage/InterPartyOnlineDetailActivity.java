package wuxc.wisdomparty.PartyManage;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;

public class InterPartyOnlineDetailActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private ImageView ImagePhoto;
	private LinearLayout LinPhoto;
	private LinearLayout LinFile;
	private LinearLayout LinPhotoWarning;
	private Button BtnInterConfirm;
	private EditText EditName;
	private EditText EditNation;
	private EditText EditSpecial;
	private EditText EditLocation;
	private EditText EditPosition;
	private EditText EditDegree;
	private EditText EditEducation;
	private EditText EditBornPlace;
	private EditText EditNativePlace;
	private EditText EditIDnumber;
	private EditText EditSex;
	private TextView TextFilePath;
	private TextView TextFileWarning;
	private int screenwidth = 0;
	private float scale = 0;
	private float scalepx = 0;
	private float dp = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.inter_party_online_detail_activity);
		initview();
		setonclicklistener();
		setheight();
	}

	private void setheight() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		DisplayMetrics mMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
		scale = getResources().getDisplayMetrics().density;
		dp = screenwidth / scale + 0.5f;
		scalepx = screenwidth / dp;
		int height = (int) ((int) (screenwidth - 55 * scalepx) / 2 / 1.2);
		LinearLayout.LayoutParams layoutParams1 = (android.widget.LinearLayout.LayoutParams) LinPhoto.getLayoutParams();
		layoutParams1.height = height;
		LinPhoto.setLayoutParams(layoutParams1);
	  layoutParams1 = (android.widget.LinearLayout.LayoutParams) LinFile.getLayoutParams();
		layoutParams1.height = height;
		LinFile.setLayoutParams(layoutParams1);

	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		ImagePhoto.setOnClickListener(this);
		LinPhoto.setOnClickListener(this);
		LinFile.setOnClickListener(this);
		LinPhotoWarning.setOnClickListener(this);
		BtnInterConfirm.setOnClickListener(this);
	}

	private void initview() {
		// TODO Auto-generated method stub
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImagePhoto = (ImageView) findViewById(R.id.image_photo);
		LinPhoto = (LinearLayout) findViewById(R.id.lin_photo);
		LinFile = (LinearLayout) findViewById(R.id.lin_file);
		LinPhotoWarning = (LinearLayout) findViewById(R.id.lin_photo_warning);
		BtnInterConfirm = (Button) findViewById(R.id.btn_inter_confirm);
		EditName = (EditText) findViewById(R.id.edit_name);
		EditNation = (EditText) findViewById(R.id.edit_nation);
		EditSpecial = (EditText) findViewById(R.id.edit_special);
		EditLocation = (EditText) findViewById(R.id.edit_location);
		EditPosition = (EditText) findViewById(R.id.edit_position);
		EditDegree = (EditText) findViewById(R.id.edit_degree);
		EditEducation = (EditText) findViewById(R.id.edit_education);
		EditBornPlace = (EditText) findViewById(R.id.edit_born_place);
		EditNativePlace = (EditText) findViewById(R.id.edit_native_place);
		EditIDnumber = (EditText) findViewById(R.id.edit_idnumber);
		EditSex = (EditText) findViewById(R.id.edit_sex);
		TextFilePath = (TextView) findViewById(R.id.text_file_path);
		TextFileWarning = (TextView) findViewById(R.id.text_file_warning);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
