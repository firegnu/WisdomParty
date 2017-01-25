package wuxc.wisdomparty.MemberCenter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.view.Window;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Adapter.MydueAdapter;
import wuxc.wisdomparty.Model.MydueModel;

public class MemberCenterMyCheck extends Activity implements OnTouchListener, OnClickListener, OnItemClickListener {
	private ListView ListData;
	private ImageView ImageBack;
	List<MydueModel> list = new ArrayList<MydueModel>();
	private static MydueAdapter mAdapter;
	private int firstItemIndex = 0;
	private int lastItemIndex = 0;
	private float startY = 0;
	private float startYfoot = 0;
	private boolean isRecored;
	private boolean isRecoredfoot;
	private int pageSize = 10;
	private int totalPage = 5;
	private int curPage = 1;
	private final static int RATIO = 2;
	private TextView headTextView = null;
	private TextView TextSearch;
	private EditText EditSearch;
	private TextView TextClass;
	private ImageView ImageClass;
	private ImageView ImageClassClose;
	private TextView TextClassAll;
	private TextView TextClassWorm;
	private TextView TextClassSpecial;
	private TextView TextClassVolunteer;
	private Button BtnClassConfirm;
	private RelativeLayout RelaClass;
	private String StrClass = "全部";
	private int IntClass = 0;
	private int ConfirmClass = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_mycheck);
		initview();
		setonclicklistener();
		setheadtextview();
		setclass();
		TextClass.setText(StrClass);
		changeclass(IntClass);
		getdatalist(curPage);
	}

	private void setheadtextview() {
		headTextView = new TextView(this);
		headTextView.setGravity(Gravity.CENTER);
		headTextView.setMinHeight(100);
		headTextView.setText("正在刷新...");
		headTextView.setTypeface(Typeface.DEFAULT_BOLD);
		headTextView.setTextSize(15);
		headTextView.setBackgroundColor(Color.WHITE);
		headTextView.invalidate();
		ListData.addHeaderView(headTextView, null, false);
		ListData.setPadding(0, -100, 0, 0);
		ListData.setOnTouchListener(this);
	}

	private void getdatalist(int arg) {
		if (arg == 1) {
			list.clear();
		}
		// TODO Auto-generated method stub

		try {

			for (int i = 0; i < 10; i++) {

				MydueModel listinfo = new MydueModel();
				listinfo.setMoney("未通过");
				listinfo.setMonth("补助申请");
				listinfo.setTime("2016-11-03");
				list.add(listinfo);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (arg == 1) {
			go();
		} else {
			mAdapter.notifyDataSetChanged();
		}

	}

	protected void go() {
		ListData.setPadding(0, -100, 0, 0);
		mAdapter = new MydueAdapter(this, list, ListData);
		ListData.setAdapter(mAdapter);
	}

	private void initview() {
		// TODO Auto-generated method stub
		ListData = (ListView) findViewById(R.id.list_data);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		TextSearch = (TextView) findViewById(R.id.text_search);
		EditSearch = (EditText) findViewById(R.id.edit_search);
		RelaClass = (RelativeLayout) findViewById(R.id.rela_class);
		TextClass = (TextView) findViewById(R.id.text_class);
		ImageClass = (ImageView) findViewById(R.id.image_class);
		ImageClassClose = (ImageView) findViewById(R.id.image_class_close);
		TextClassAll = (TextView) findViewById(R.id.text_class_all);
		TextClassWorm = (TextView) findViewById(R.id.text_class_worm);
		TextClassSpecial = (TextView) findViewById(R.id.text_class_special);
		TextClassVolunteer = (TextView) findViewById(R.id.text_class_volunteer);
		BtnClassConfirm = (Button) findViewById(R.id.btn_class_confirm);
		RelaClass.setVisibility(View.GONE);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		ListData.setOnItemClickListener(this);
		TextSearch.setOnClickListener(this);
		TextClass.setOnClickListener(this);
		ImageClass.setOnClickListener(this);
		ImageClassClose.setOnClickListener(this);
		TextClassAll.setOnClickListener(this);
		TextClassWorm.setOnClickListener(this);
		TextClassSpecial.setOnClickListener(this);
		TextClassVolunteer.setOnClickListener(this);
		BtnClassConfirm.setOnClickListener(this);
		RelaClass.setOnClickListener(this);
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
			if (TextUtils.isEmpty(temp)) {
				Toast.makeText(getApplicationContext(), "请输入关键词", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "正在搜索...", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.image_class:
			changeclass(ConfirmClass);
			RelaClass.setVisibility(View.VISIBLE);
			break;
		case R.id.text_class:
			changeclass(ConfirmClass);
			RelaClass.setVisibility(View.VISIBLE);
			break;
		case R.id.btn_class_confirm:
			TextClass.setText(StrClass);
			ConfirmClass = IntClass;
			RelaClass.setVisibility(View.GONE);
			break;
		case R.id.image_class_close:

			RelaClass.setVisibility(View.GONE);
			break;
		case R.id.rela_class:

			RelaClass.setVisibility(View.GONE);
			break;
		case R.id.text_class_all:
			StrClass = "全部";
			IntClass = 0;
			changeclass(IntClass);

			break;
		case R.id.text_class_worm:
			StrClass = "暖心活动";
			IntClass = 1;
			changeclass(IntClass);

			break;
		case R.id.text_class_special:
			StrClass = "志愿者活动";
			IntClass = 2;
			changeclass(IntClass);

			break;
		case R.id.text_class_volunteer:
			StrClass = "在线入党审批";
			IntClass = 3;
			changeclass(IntClass);

			break;
		default:
			break;
		}
	}

	private void setclass() {
		// TODO Auto-generated method stub

		TextClassAll.setBackgroundResource(R.drawable.shape_10_stroke);
		TextClassWorm.setBackgroundResource(R.drawable.shape_10_stroke);
		TextClassSpecial.setBackgroundResource(R.drawable.shape_10_stroke);
		TextClassVolunteer.setBackgroundResource(R.drawable.shape_10_stroke);
		TextClassAll.setTextColor(Color.parseColor("#c2c2c2"));
		TextClassWorm.setTextColor(Color.parseColor("#c2c2c2"));
		TextClassSpecial.setTextColor(Color.parseColor("#c2c2c2"));
		TextClassVolunteer.setTextColor(Color.parseColor("#c2c2c2"));
	}

	private void changeclass(int arg) {
		setclass();
		if (arg == 0) {
			TextClassAll.setBackgroundResource(R.drawable.shape_10_red_grey_stroke);
			TextClassAll.setTextColor(Color.parseColor("#ffffff"));
		} else if (arg == 1) {
			TextClassWorm.setBackgroundResource(R.drawable.shape_10_red_grey_stroke);
			TextClassWorm.setTextColor(Color.parseColor("#ffffff"));
		} else if (arg == 2) {
			TextClassSpecial.setBackgroundResource(R.drawable.shape_10_red_grey_stroke);
			TextClassSpecial.setTextColor(Color.parseColor("#ffffff"));
		} else {
			TextClassVolunteer.setBackgroundResource(R.drawable.shape_10_red_grey_stroke);
			TextClassVolunteer.setTextColor(Color.parseColor("#ffffff"));
		}

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		float tempY = event.getY();
		float tempyfoot = event.getY();
		firstItemIndex = ListData.getFirstVisiblePosition();
		lastItemIndex = ListData.getLastVisiblePosition();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_MOVE:
			if (!isRecored && (firstItemIndex == 0)) {
				isRecored = true;
				startY = tempY;
			}
			int temp = 1;
			temp = (lastItemIndex) % pageSize;
			if (!isRecoredfoot && (temp == 0)) {
				isRecoredfoot = true;
				startYfoot = tempyfoot;
			}
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			isRecored = false;
			isRecoredfoot = false;
			break;

		default:
			break;
		}

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			break;
		case MotionEvent.ACTION_UP:
		case MotionEvent.ACTION_CANCEL:
			ListData.setPadding(0, 0, 0, 0);
			if (tempY - startY < 400) {
				ListData.setPadding(0, -100, 0, 0);
			} else {
				curPage = 1;
				Toast.makeText(getApplicationContext(), "正在刷新", Toast.LENGTH_SHORT).show();
				getdatalist(curPage);
			}
			int temp = 1;
			temp = (lastItemIndex) % pageSize;
			if (temp == 0 && (startYfoot - tempyfoot > 400)) {
				curPage++;
				if (curPage > totalPage) {
					Toast.makeText(getApplicationContext(), " 没有更多了", Toast.LENGTH_SHORT).show();
					// // listinfoagain();
				} else {
					getdatalist(curPage);
					Toast.makeText(getApplicationContext(), "正在加载下一页", Toast.LENGTH_SHORT).show();
				}
			} else {

			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (isRecored && tempY > startY) {
				ListData.setPadding(0, (int) ((tempY - startY) / RATIO - 100), 0, 0);
			}
			if (isRecoredfoot && startYfoot > tempyfoot) {
				// footTextView.setVisibility(View.VISIBLE);
				ListData.setPadding(0, -100, 0, (int) ((startYfoot - tempyfoot) / RATIO));
			}
			break;

		default:
			break;
		}
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
	}

}
