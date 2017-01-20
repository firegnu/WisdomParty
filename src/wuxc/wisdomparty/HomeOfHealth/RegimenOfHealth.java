package wuxc.wisdomparty.HomeOfHealth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeOfYouth.YouthDetailActivity;
import wuxc.wisdomparty.Model.RegimenModel;
import wuxc.wisdomparty.PartyManage.SpecialDetailActivity;
import wuxc.wisdomparty.WaterFallFlow.Helper;
import wuxc.wisdomparty.WaterFallFlow.ImageFetcher;
import wuxc.wisdomparty.WaterFallFlow.PLA_AdapterView;
import wuxc.wisdomparty.WaterFallFlow.PLA_AdapterView.OnItemClickListener;
import wuxc.wisdomparty.WaterFallFlow.ScaleImageView;
import wuxc.wisdomparty.WaterFallFlow.XListView;
import wuxc.wisdomparty.WaterFallFlow.XListView.IXListViewListener;

public class RegimenOfHealth extends FragmentActivity
		implements OnClickListener, IXListViewListener, OnItemClickListener {
	private ImageView image_back;
	private ImageFetcher mImageFetcher;
	private XListView mAdapterView = null;
	private StaggeredAdapter mAdapter = null;
	private int currentPage = 0;
	ContentTask task = new ContentTask(this, 2);
	private String[] pic = { "one", "two", "two", "two", "two", "two", "two", "two", "two", "two" };
	private int[] height = { 14, 26, 26, 26, 26, 26, 26, 26, 26, 26 };
	private TextView TextSearch;
	private EditText EditSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.regimenofhealth);
		image_back = (ImageView) findViewById(R.id.image_back);
		image_back.setOnClickListener(this);
		mAdapterView = (XListView) findViewById(R.id.list);
		mAdapterView.setPullLoadEnable(true);
		mAdapterView.setXListViewListener(this);
		mAdapterView.setOnItemClickListener(this);
		mAdapter = new StaggeredAdapter(this, mAdapterView);
		mImageFetcher = new ImageFetcher(this, 240);
		mImageFetcher.setLoadingImage(R.drawable.empty_photo);
		TextSearch = (TextView) findViewById(R.id.text_search);
		EditSearch = (EditText) findViewById(R.id.edit_search);
		TextSearch.setOnClickListener(this);
	}

	private class ContentTask extends AsyncTask<String, Integer, List<RegimenModel>> {

		private Context mContext;
		private int mType = 1;

		public ContentTask(Context context, int type) {
			super();
			mContext = context;
			mType = type;
		}

		@Override
		protected List<RegimenModel> doInBackground(String... params) {
			try {
				return parseNewsJSON(params[0]);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<RegimenModel> result) {
			if (mType == 1) {

				mAdapter.addItemTop(result);
				mAdapter.notifyDataSetChanged();
				mAdapterView.stopRefresh();

			} else if (mType == 2) {
				mAdapterView.stopLoadMore();
				mAdapter.addItemLast(result);
				mAdapter.notifyDataSetChanged();
			}

		}

		@Override
		protected void onPreExecute() {
		}

		public List<RegimenModel> parseNewsJSON(String url) throws IOException {
			List<RegimenModel> Regimen = new ArrayList<RegimenModel>();
			String json = "";
			if (Helper.checkConnection(mContext)) {
				try {
					json = Helper.getStringFromUrl(url);

				} catch (IOException e) {
					Log.e("IOException is : ", e.toString());
					e.printStackTrace();
					return Regimen;
				}
			}
			Log.d("MainActiivty", "json:" + json);

			try {
				// if (null != json) {
				// JSONObject newsObject = new JSONObject(json);
				// JSONObject jsonObject = newsObject.getJSONObject("data");
				// JSONArray blogsJson = jsonObject.getJSONArray("blogs");
				//
				// for (int i = 0; i < blogsJson.length(); i++) {
				// JSONObject newsInfoLeftObject = blogsJson.getJSONObject(i);
				// RegimenModel newsInfo1 = new RegimenModel();
				// newsInfo1.setAlbid(
				// newsInfoLeftObject.isNull("albid") ? "" :
				// newsInfoLeftObject.getString("albid"));
				// newsInfo1
				// .setIsrc(newsInfoLeftObject.isNull("isrc") ? "" :
				// newsInfoLeftObject.getString("isrc"));
				// newsInfo1.setMsg(newsInfoLeftObject.isNull("msg") ? "" :
				// newsInfoLeftObject.getString("msg"));
				// newsInfo1.setHeight(200);
				// Regimen.add(newsInfo1);
				// }
				// }
				for (int i = 0; i < 10; i++) {
					RegimenModel regimenmodel = new RegimenModel();
					regimenmodel.setTitle("补血顺气");
					regimenmodel.setLabel("中医养生");
					regimenmodel.setCollect("34");
					regimenmodel.setGreat("78");
					regimenmodel.setCollect(true);
					regimenmodel.setGreat(false);
					regimenmodel.setImageUrl(pic[i]);
					regimenmodel.setWidth(20);
					regimenmodel.setHeight(height[i]);
					Regimen.add(regimenmodel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Regimen;
		}
	}

	/**
	 * 添加内容
	 * 
	 * @param pageindex
	 * @param type
	 *            1为下拉刷新 2为加载更多
	 */
	private void AddItemToContainer(int pageindex, int type) {
		if (task.getStatus() != Status.RUNNING) {
			String url = "http://www.duitang.com/album/1733789/masn/p/" + pageindex + "/5/";
			Log.d("MainActivity", "current url:" + url);
			ContentTask task = new ContentTask(this, type);
			task.execute(url);

		}
	}

	public class StaggeredAdapter extends BaseAdapter {
		private Context mContext;
		private LinkedList<RegimenModel> mInfos;
		private XListView mListView;

		public StaggeredAdapter(Context context, XListView xListView) {
			mContext = context;
			mInfos = new LinkedList<RegimenModel>();
			mListView = xListView;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder;
			RegimenModel regimenmodel = mInfos.get(position);

			if (convertView == null) {
				LayoutInflater layoutInflator = LayoutInflater.from(parent.getContext());
				convertView = layoutInflator.inflate(R.layout.item_regimen, null);
				holder = new ViewHolder();
				holder.imageheadimg = (ScaleImageView) convertView.findViewById(R.id.image_headimg);
				holder.texttitle = (TextView) convertView.findViewById(R.id.text_title);
				holder.textlabel = (TextView) convertView.findViewById(R.id.text_label);
				holder.imagecollect = (ImageView) convertView.findViewById(R.id.image_collect);
				holder.imagegreat = (ImageView) convertView.findViewById(R.id.image_great);
				holder.TextCollect = (TextView) convertView.findViewById(R.id.text_collect);
				holder.TextGreat = (TextView) convertView.findViewById(R.id.text_great);
				convertView.setTag(holder);
			}

			holder = (ViewHolder) convertView.getTag();
			holder.imageheadimg.setImageWidth(regimenmodel.getWidth());
			holder.imageheadimg.setImageHeight(regimenmodel.getHeight());
			holder.texttitle.setText(regimenmodel.getTitle());
			holder.textlabel.setText(regimenmodel.getLabel());
			holder.TextCollect.setText(regimenmodel.getCollect());
			holder.TextGreat.setText(regimenmodel.getGreat());
			if (regimenmodel.isCollect()) {
				holder.imagecollect.setImageResource(R.drawable.collect);
			} else {
				holder.imagecollect.setImageResource(R.drawable.no_collect);
			}
			if (regimenmodel.isGreat()) {
				holder.imagegreat.setImageResource(R.drawable.great);
			} else {
				holder.imagegreat.setImageResource(R.drawable.no_great);
			}
			if (regimenmodel.getImageUrl().equals("one")) {
				holder.imageheadimg.setImageResource(R.drawable.regimen_one);
			} else if (regimenmodel.getImageUrl().equals("two")) {
				holder.imageheadimg.setImageResource(R.drawable.regimen_two);
			} else if (!TextUtils.isEmpty(regimenmodel.getImageUrl())) {
				mImageFetcher.loadImage(regimenmodel.getImageUrl(), holder.imageheadimg);
			} else {
				holder.imageheadimg.setImageResource(R.drawable.empty_photo);
			}

			return convertView;
		}

		class ViewHolder {
			ScaleImageView imageheadimg;
			TextView texttitle;
			TextView textlabel;
			ImageView imagecollect;
			ImageView imagegreat;
			TextView TextCollect;
			TextView TextGreat;
		}

		@Override
		public int getCount() {
			return mInfos.size();
		}

		@Override
		public Object getItem(int arg0) {
			return mInfos.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		public void addItemLast(List<RegimenModel> datas) {
			mInfos.addAll(datas);
		}

		public void addItemTop(List<RegimenModel> datas) {
			for (RegimenModel info : datas) {
				mInfos.addFirst(info);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		mImageFetcher.setExitTasksEarly(false);
		mAdapterView.setAdapter(mAdapter);
		AddItemToContainer(currentPage, 2);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

	@Override
	public void onRefresh() {
		AddItemToContainer(++currentPage, 1);

	}

	@Override
	public void onLoadMore() {
		AddItemToContainer(++currentPage, 2);

	}

	@Override
	public void onItemClick(PLA_AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), position + "页", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), RegimenDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("PageTitle", "中医养生");
		bundle.putString("Time", "2016-11-26");
		bundle.putString("Name", "新华社");
		bundle.putString("Title", "补血顺气");
		bundle.putString("Detail",
				"中医学以阴阳五行作为理论基础，将人体看成是气、形、神的统一体，通过望闻问切四诊合参的方法，探求病因、病性、病位、分析病机及人体内五脏六腑、经络关节、气血津液的变化、判断邪正消长，进而得出病名，归纳出证型，以辨证论治原则，制定汗、吐、下、和、温、清、补、消等治法，使用中药、针灸、推拿、按摩、拔罐、气功、食疗等多种治疗手段，使人体达到阴阳调和而康复。");
		intent.putExtras(bundle);
		startActivity(intent);
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
		default:
			break;
		}
	}

}
