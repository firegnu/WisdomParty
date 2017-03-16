package wuxc.wisdomparty.HomeOfMember;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Adapter.PartyBranchDataListAdapter;
import wuxc.wisdomparty.Internet.HttpGetData;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.Model.PartyBranchDataListModel;

public class MemberPartyBranchActivity extends Activity implements OnClickListener, OnItemClickListener {
	private ListView ListData;
	private PartyBranchDataListAdapter mAdapter;
	List<PartyBranchDataListModel> list = new ArrayList<PartyBranchDataListModel>();
	List<PartyBranchDataListModel> initList = new ArrayList<PartyBranchDataListModel>();
	List<PartyBranchDataListModel> ShowList = new ArrayList<PartyBranchDataListModel>();
	private RelativeLayout RelativeNextPage;
	private RelativeLayout RelativeLastPage;
	private int Page = 1;
	private int TotalPage = 0;
	private int initTotalPage = 0;
	private int TotalItem = 0;
	private TextView TextPage;
	private EditText EditSearch;
	private ImageView ImageBack;
	private String ticket;
	private SharedPreferences PreUserInfo;// 存储个人信息
	private static final int GET_BRANCH_RESULT = 1;
	private static final String GET_SUCCESS_RESULT = "success";
	private Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_BRANCH_RESULT:
				GetData(msg.obj);
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
		setContentView(R.layout.member_party_branch_activity);
		initview();
		setonclicklistener();
		ReadTicket();
		getinfo();

		EditSearch.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				Searchlist(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void GetData(Object obj) {

		// TODO Auto-generated method stub
		String Type = null;
		String Data = null;
		try {
			JSONObject demoJson = new JSONObject(obj.toString());
			Type = demoJson.getString("type");
			Data = demoJson.getString("datas");
			if (Type.equals(GET_SUCCESS_RESULT)) {
				Toast.makeText(getApplicationContext(), "数据加载成功！", Toast.LENGTH_SHORT).show();
				GetDataDetailFromBranch(Data);
			} else {
				Toast.makeText(getApplicationContext(), "数据加载失败！", Toast.LENGTH_SHORT).show();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void GetDataDetailFromBranch(String Data) {
		// TODO Auto-generated method stub
		JSONArray jArray;
		try {
			jArray = new JSONArray(Data);

			JSONObject json_data = null;
			for (int i = 0; i < jArray.length(); i++) {
				json_data = jArray.getJSONObject(i);
				String name = json_data.getString("name");
				String id = json_data.getString("id");
				PartyBranchDataListModel data = new PartyBranchDataListModel();
				data.setIsSelected(false);
				data.setPartyAddress("陕西省渭南市临渭区");
				data.setPartyName(name);
				data.setId(id);
				data.setPartyPhonenumber("13022889658");
				list.add(data);
				initList.add(data);
			}
			initTotalPage = jArray.length();
			TotalItem = jArray.length();
			TotalPage = TotalItem / 6;
			if (TotalPage * 6 < TotalItem) {
				TotalPage++;
			}
			go(Page);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ReadTicket() {
		// TODO Auto-generated method stub
		ticket = PreUserInfo.getString("ticket", null);
	}

	protected void Searchlist(String string) {
		list.clear();

		Page = 1;
		int temptotalitem = 0;
		// Toast.makeText(getApplicationContext(), "这"+string,
		// Toast.LENGTH_SHORT).show();
		// TODO Auto-generated method stub
		if (TextUtils.isEmpty(string)) {
			for (int i = 0; i < initTotalPage; i++) {
				PartyBranchDataListModel data = initList.get(i);
				temptotalitem++;
				list.add(data);
			}
		} else {
			for (int i = 0; i < initTotalPage; i++) {
				PartyBranchDataListModel data = initList.get(i);
				if ((data.getPartyAddress()).indexOf(string) != -1 || (data.getPartyPhonenumber()).indexOf(string) != -1
						|| (data.getPartyName()).indexOf(string) != -1) {
					temptotalitem++;
					list.add(data);
				}

			}
		}
		TotalItem = temptotalitem;
		TotalPage = TotalItem / 6;
		if (TotalPage * 6 < TotalItem) {
			TotalPage++;
		}
		go(Page);
	}

	private void getinfo() {
		// TODO Auto-generated method stub

		final ArrayList ArrayValues = new ArrayList();
		ArrayValues.add(new BasicNameValuePair("ticket", ticket));
		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				String BranchResultData = "";
				BranchResultData = HttpGetData.GetData(URLcontainer.GetAllOrg, ArrayValues);
				Message msg = new Message();
				msg.obj = BranchResultData;
				msg.what = GET_BRANCH_RESULT;
				uiHandler.sendMessage(msg);
			}
		}).start();

		// }

	}

	protected void go(int page) {
		// TODO Auto-generated method stub

		mAdapter = new PartyBranchDataListAdapter(this, this, getData(page));
		ListData.setAdapter(mAdapter);
		TextPage.setText(Page + "/" + TotalPage);
		// Toast.makeText(choosemember.this, "go", Toast.LENGTH_SHORT).show();
	}

	private List<PartyBranchDataListModel> getData(int page) {
		ShowList.clear();
		for (int i = 0; i < 6; i++) {
			if (i + (page - 1) * 6 >= TotalItem) {
				break;
			} else {

				try {
					PartyBranchDataListModel data = list.get(i + (page - 1) * 6);

					data.setIsSelected(false);

					ShowList.add(data);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;

			}

		}
		// }
		return ShowList;
	}

	private void initview() {
		// TODO Auto-generated method stub
		PreUserInfo = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		ListData = (ListView) findViewById(R.id.list_data);
		RelativeLastPage = (RelativeLayout) findViewById(R.id.realative_last_page);
		RelativeNextPage = (RelativeLayout) findViewById(R.id.realative_next_page);
		TextPage = (TextView) findViewById(R.id.text_page);
		EditSearch = (EditText) findViewById(R.id.edit_search);
		ImageBack = (ImageView) findViewById(R.id.image_back);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		RelativeLastPage.setOnClickListener(this);
		RelativeNextPage.setOnClickListener(this);
		ListData.setOnItemClickListener(this);
		ImageBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.realative_last_page:
			if (Page == 1) {
				Toast.makeText(getApplicationContext(), "这已经是第一页了", Toast.LENGTH_SHORT).show();
			} else {
				Page = Page - 1;
				go(Page);
			}
			break;
		case R.id.realative_next_page:
			if (Page == TotalPage || Page > TotalPage) {
				Toast.makeText(getApplicationContext(), "这已经是最后一页了", Toast.LENGTH_SHORT).show();
			} else {
				Page = Page + 1;
				go(Page);
			}
			break;
		case R.id.image_back:
			finish();
			break;

		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		PartyBranchDataListModel data = list.get((Page - 1) * 6 + position);
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), MemberPartyBranchDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("Name", data.getPartyName());
		intent.putExtras(bundle);
		startActivity(intent);
	}

}
