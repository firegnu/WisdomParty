package wuxc.wisdomparty.MemberCenter;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.umeng.socialize.utils.Log;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Adapter.NoticeAdapter;
import wuxc.wisdomparty.Internet.HttpGetData;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.Model.NoticeModel;
import android.view.Window;

public class NoticeDatalistActivity extends Activity implements OnTouchListener, OnClickListener, OnItemClickListener {
	private ListView ListData;
	private ImageView ImageBack;
	List<NoticeModel> list = new ArrayList<NoticeModel>();
	private static NoticeAdapter mAdapter;
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
	private static final String GET_SUCCESS_RESULT = "success";
	private static final int GET_NOTICE_DATA = 6;
	private static final int INTENT_GO_DETAIL_NOTICE = 6;
	private String ticket;
	private SharedPreferences PreUserInfo;// 存储个人信息
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
		setContentView(R.layout.notice_datalist_activity);
		initview();
		setonclicklistener();
		setheadtextview();
		GetData();
		Toast.makeText(getApplicationContext(), "正在加载数据", Toast.LENGTH_SHORT).show();
	}

	protected void GetDataNoticeData(Object obj) {

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

	private void GetData() {
		// TODO Auto-generated method stub
		final ArrayList ArrayValues = new ArrayList();
		ArrayValues.add(new BasicNameValuePair("ticket", ticket));
		ArrayValues.add(new BasicNameValuePair("curPage", "" + curPage));
		ArrayValues.add(new BasicNameValuePair("pageSize", "" + pageSize));
		ArrayValues.add(new BasicNameValuePair("systemMessageDto.receiveSendType", "receive"));
		ArrayValues.add(new BasicNameValuePair("systemMessageDto.readState", ""));
		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				String NoticeData = "";
				NoticeData = HttpGetData.GetData(URLcontainer.GetListJsonData_2, ArrayValues);
				Message msg = new Message();
				msg.obj = NoticeData;
				msg.what = GET_NOTICE_DATA;
				uiHandler.sendMessage(msg);
			}
		}).start();
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

	private void GetDataList(String data, int arg) {
		if (arg == 1) {
			list.clear();
		}
		// TODO Auto-generated method stub
		JSONArray jArray = null;
		try {
			Log.e("data", "" + data);
			jArray = new JSONArray(data);
			JSONObject json_data = null;
			for (int i = 0; i < jArray.length(); i++) {
				json_data = jArray.getJSONObject(i);
				Log.e("json_data", "" + json_data);
				JSONObject jsonObject = json_data.getJSONObject("data");
				NoticeModel listinfo = new NoticeModel();
				listinfo.setStyle(jsonObject.getString("title"));
				listinfo.setKeyID(jsonObject.getString("keyid"));
				listinfo.setTime(jsonObject.getString("sendDate"));
				listinfo.setSendUserName(jsonObject.getString("sendUserName"));
				listinfo.setReadState(jsonObject.getInt("readState"));
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

	protected void go() {
		ListData.setPadding(0, -100, 0, 0);
		mAdapter = new NoticeAdapter(this, list, ListData);
		ListData.setAdapter(mAdapter);
	}

	private void initview() {
		// TODO Auto-generated method stub
		ListData = (ListView) findViewById(R.id.list_data);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		PreUserInfo = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		ReadTicket();
	}

	private void ReadTicket() {
		// TODO Auto-generated method stub
		ticket = PreUserInfo.getString("ticket", null);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		ListData.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		default:
			break;
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
				GetData();
			}
			int temp = 1;
			temp = (lastItemIndex) % pageSize;
			if (temp == 0 && (startYfoot - tempyfoot > 400)) {
				curPage++;
				if (curPage > totalPage) {
					Toast.makeText(getApplicationContext(), " 没有更多了", Toast.LENGTH_SHORT).show();
					// // listinfoagain();
				} else {
					GetData();
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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (data == null)
			return;
		Bundle bundle = data.getExtras();
		switch (requestCode) {
		case INTENT_GO_DETAIL_NOTICE:
			mAdapter.notifyDataSetChanged();
			Log.e("mAdapter","mAdapter.notifyDataSetChanged");
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		NoticeModel data = list.get(position - 1);
		Intent intent_notice = new Intent();
		intent_notice.setClass(this, NoticeDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("Keyid", data.getKeyID());
		bundle.putString("sendUserName", data.getSendUserName());
		bundle.putString("ticket", ticket);
		data.setReadState(1);
		intent_notice.putExtras(bundle);
		startActivityForResult(intent_notice, INTENT_GO_DETAIL_NOTICE);
	}

}
