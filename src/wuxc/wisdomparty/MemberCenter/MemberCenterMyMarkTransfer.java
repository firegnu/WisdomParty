package wuxc.wisdomparty.MemberCenter;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.umeng.socialize.utils.Log;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.view.Window;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Adapter.MyfundAdapter;
import wuxc.wisdomparty.Internet.HttpGetData;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.Model.MyfundModel;
import wuxc.wisdomparty.layout.dialogtwo;

public class MemberCenterMyMarkTransfer extends Activity
		implements OnTouchListener, OnClickListener, OnItemClickListener {
	private ListView ListData;
	private ImageView ImageBack;
	List<MyfundModel> list = new ArrayList<MyfundModel>();
	private static MyfundAdapter mAdapter;
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
	private TextView TextMarkNumber;
	private String MarkNumber;
	private LinearLayout LinTransferRule;
	private RelativeLayout RelaTransferRule;
	private TextView TextTransferRule;
	private TextView TextTransferIn;
	private TextView TextTransferOut;
	private TextView TextTransfer;
	private ImageView ImageTimeClose;
	private RelativeLayout RelaTime;
	private TextView TextTimeAll;
	private TextView TextTimeThree;
	private TextView TextTimeSix;
	private TextView TextTimeOneYear;
	private String StrTime = "全部转换记录";
	private String ticket;
	private SharedPreferences PreUserInfo;// 存储个人信息
	private static final String GET_SUCCESS_RESULT = "success";
	private static final int GET_DUE_DATA = 6;
	private static final int GET_CONVERT_DATA = 9;
	private int status;
	int first = 1;
	private EditText EditMark;
	private boolean UploadMark = false;
	public Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_DUE_DATA:
				GetDataDueData(msg.obj);
				break;
			case GET_CONVERT_DATA:
				GetConvertData(msg.obj);
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
		setContentView(R.layout.membercentermymarktransfer);
		initview();
		setonclicklistener();
		setheadtextview();
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象
		MarkNumber = bundle.getString("mark");
		TextMarkNumber.setText(MarkNumber);
		settimelayout();
		settextinORout();
		TextTransferRule.setText(StrTime);
		GetData(first);
	}

	protected void GetConvertData(Object obj) {

		// TODO Auto-generated method stub
		String Type = null;
		int useScore = 0;
		try {
			JSONObject demoJson = new JSONObject(obj.toString());
			Type = demoJson.getString("type");
			useScore = demoJson.getInt("useScore");
			if (Type.equals(GET_SUCCESS_RESULT)) {
				UploadMark = true;
				Toast.makeText(getApplicationContext(), "转换成功", Toast.LENGTH_SHORT).show();
				int totalnumber = Integer.parseInt(MarkNumber);
				TextMarkNumber.setText("" + (totalnumber - useScore));

				Editor edit = PreUserInfo.edit();
				edit.putString("credits", "" + (totalnumber - useScore));
				edit.commit();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void GetDataDueData(Object obj) {

		// TODO Auto-generated method stub
		String Type = null;
		String Data = null;
		String pager = null;
		try {
			JSONObject demoJson = new JSONObject(obj.toString());
			Type = demoJson.getString("type");
			pager = demoJson.getString("pager");
			Data = demoJson.getString("datas");
			if (Type.equals(GET_SUCCESS_RESULT)) {
				GetPager(pager);
				GetDataList(Data, curPage);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void GetDataList(String data, int arg) {

		if (arg == 1) {
			list.clear();
		}
		JSONArray jArray = null;
		try {
			jArray = new JSONArray(data);
			JSONObject json_data = null;
			for (int i = 0; i < jArray.length(); i++) {
				json_data = jArray.getJSONObject(i);
				Log.e("json_data", "" + json_data);
				JSONObject jsonObject = json_data.getJSONObject("data");
				MyfundModel listinfo = new MyfundModel();
				int inout = jsonObject.getInt("inOut");
				String Sign = "";
				if (inout == 1) {
					Sign = "+";
				} else {
					Sign = "-";
				}
				listinfo.setChange(Sign + jsonObject.getString("amount"));
				listinfo.setDetail(jsonObject.getString("reason"));
				listinfo.setTime(jsonObject.getString("createTime"));
				list.add(listinfo);

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (arg == 1) {
			go();
		} else {
			mAdapter.notifyDataSetChanged();
		}

	}

	private void GetPager(String pager) {
		// TODO Auto-generated method stub
		try {
			JSONObject demoJson = new JSONObject(pager);

			totalPage = demoJson.getInt("totalPage");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void ReadTicket() {
		// TODO Auto-generated method stub
		ticket = PreUserInfo.getString("ticket", null);
	}

	private void GetData(int first) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		final ArrayList ArrayValues = new ArrayList();
		ArrayValues.add(new BasicNameValuePair("ticket", ticket));
		ArrayValues.add(new BasicNameValuePair("curPage", "" + curPage));
		ArrayValues.add(new BasicNameValuePair("pageSize", "" + pageSize));
		if (first != 1) {
			ArrayValues.add(new BasicNameValuePair("userScoreDto.inOut", "" + status));
		}

		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				String DueData = "";
				DueData = HttpGetData.GetData(URLcontainer.userScoregetListJsonData, ArrayValues);
				Message msg = new Message();
				msg.obj = DueData;
				msg.what = GET_DUE_DATA;
				uiHandler.sendMessage(msg);
			}
		}).start();

	}

	private void settimelayout() {
		// TODO Auto-generated method stub
		RelaTime.setVisibility(View.GONE);
	}

	private void settextinORout() {
		// TODO Auto-generated method stub
		TextTransferIn.setTextColor(Color.BLACK);
		TextTransferOut.setTextColor(Color.BLACK);

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

	protected void go() {
		ListData.setPadding(0, -100, 0, 0);
		mAdapter = new MyfundAdapter(this, list, ListData);
		ListData.setAdapter(mAdapter);
	}

	private void initview() {
		// TODO Auto-generated method stub
		EditMark = (EditText) findViewById(R.id.edit_mark);
		ListData = (ListView) findViewById(R.id.list_data);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		TextMarkNumber = (TextView) findViewById(R.id.text_number);
		LinTransferRule = (LinearLayout) findViewById(R.id.lin_transfer_rule);
		RelaTransferRule = (RelativeLayout) findViewById(R.id.rela_transfer_rule);
		TextTransferRule = (TextView) findViewById(R.id.text_transfer_rule);
		TextTransferIn = (TextView) findViewById(R.id.text_transfer_in);
		TextTransferOut = (TextView) findViewById(R.id.text_transfer_out);
		TextTransfer = (TextView) findViewById(R.id.text_transfer);
		ImageTimeClose = (ImageView) findViewById(R.id.image_time_close);
		RelaTime = (RelativeLayout) findViewById(R.id.rela_time);
		TextTimeAll = (TextView) findViewById(R.id.text_time_all);
		TextTimeThree = (TextView) findViewById(R.id.text_time_three);
		TextTimeSix = (TextView) findViewById(R.id.text_time_six);
		TextTimeOneYear = (TextView) findViewById(R.id.text_time_oneyear);
		PreUserInfo = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		ReadTicket();
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		ListData.setOnItemClickListener(this);
		LinTransferRule.setOnClickListener(this);
		RelaTransferRule.setOnClickListener(this);
		TextTransferRule.setOnClickListener(this);
		TextTransferIn.setOnClickListener(this);
		TextTransferOut.setOnClickListener(this);
		TextTransfer.setOnClickListener(this);
		ImageTimeClose.setOnClickListener(this);
		RelaTime.setOnClickListener(this);
		TextTimeAll.setOnClickListener(this);
		TextTimeThree.setOnClickListener(this);
		TextTimeSix.setOnClickListener(this);
		TextTimeOneYear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.lin_transfer_rule:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), MemberCenterMyMarkTransferRule.class);
			startActivity(intent);
			break;
		case R.id.rela_transfer_rule:
			RelaTime.setVisibility(View.GONE);
			break;
		case R.id.text_transfer_rule:
			RelaTime.setVisibility(View.GONE);
			break;
		case R.id.text_transfer_in:
			settextinORout();
			status = 1;
			curPage = 1;
			first = 2;
			GetData(first);
			TextTransferIn.setTextColor(Color.BLUE);
			break;
		case R.id.text_transfer_out:
			settextinORout();
			status = 2;
			curPage = 1;
			first = 2;
			GetData(first);
			TextTransferOut.setTextColor(Color.BLUE);
			break;
		case R.id.image_time_close:
			RelaTime.setVisibility(View.GONE);
			break;
		case R.id.rela_time:
			RelaTime.setVisibility(View.GONE);
			break;
		case R.id.text_time_all:
			StrTime = "全部转换记录";
			TextTransferRule.setText(StrTime);
			RelaTime.setVisibility(View.GONE);
			break;
		case R.id.text_time_three:
			StrTime = "最近三个月转换记录";
			TextTransferRule.setText(StrTime);
			RelaTime.setVisibility(View.GONE);
			break;
		case R.id.text_time_six:
			StrTime = "最近六个月转换记录";
			TextTransferRule.setText(StrTime);
			RelaTime.setVisibility(View.GONE);
			break;
		case R.id.text_time_oneyear:
			StrTime = "最近一年转换记录";
			TextTransferRule.setText(StrTime);
			RelaTime.setVisibility(View.GONE);
			break;
		case R.id.image_back:
			Intent intentresult = new Intent();

			intentresult.putExtra("UploadMark", UploadMark);

			setResult(0, intentresult);
			finish();
			break;
		case R.id.text_transfer:
			String ChangeNumber = EditMark.getText().toString();
			if (!(ChangeNumber.equals("") || ChangeNumber == null)) {
				try {
					int totalnumber = Integer.parseInt(MarkNumber);
					int number = Integer.parseInt(ChangeNumber);
					if (totalnumber > number) {
						if (number >= 5) {
							showAlertDialog(number);
						} else {
							Toast.makeText(getApplicationContext(), "转换积分应大于5", Toast.LENGTH_SHORT).show();
						}

					} else {
						Toast.makeText(getApplicationContext(), "转换积分大于所有积分", Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				Toast.makeText(getApplicationContext(), "请输入转换数据", Toast.LENGTH_SHORT).show();
			}

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

			intentresult.putExtra("UploadMark", UploadMark);

			setResult(0, intentresult);
			finish();
		}
		return false;
	}

	public void showAlertDialog(final int number) {

		dialogtwo.Builder builder = new dialogtwo.Builder(this);
		builder.setMessage("您的所有积分都将转换为基金,请确认");
		builder.setTitle("积分转换确认");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				try {
					GetConvert(number);
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		});

		builder.setNegativeButton("取消", new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		builder.create().show();

	}

	protected void GetConvert(int score) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		final ArrayList ArrayValues = new ArrayList();
		ArrayValues.add(new BasicNameValuePair("ticket", ticket));
		ArrayValues.add(new BasicNameValuePair("score", "" + score));

		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				String DueData = "";
				DueData = HttpGetData.GetData(URLcontainer.convertScore, ArrayValues);
				Message msg = new Message();
				msg.obj = DueData;
				msg.what = GET_CONVERT_DATA;
				uiHandler.sendMessage(msg);
			}
		}).start();

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
				GetData(first);
			}
			int temp = 1;
			temp = (lastItemIndex) % pageSize;
			if (temp == 0 && (startYfoot - tempyfoot > 400)) {
				curPage++;
				if (curPage > totalPage) {
					Toast.makeText(getApplicationContext(), " 没有更多了", Toast.LENGTH_SHORT).show();
					// // listinfoagain();
				} else {
					GetData(first);
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
