package wuxc.wisdmparty.HomeOfYouth;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Model.AppearanceModel;
import wuxc.wisdomparty.PartyManage.SpecialDetailActivity;
import wuxc.wisdomparty.WaterFallFlow.Helper;
import wuxc.wisdomparty.WaterFallFlow.ImageFetcher;
import wuxc.wisdomparty.WaterFallFlow.PLA_AdapterView;
import wuxc.wisdomparty.WaterFallFlow.PLA_AdapterView.OnItemClickListener;
import wuxc.wisdomparty.WaterFallFlow.ScaleImageView;
import wuxc.wisdomparty.WaterFallFlow.XListView;
import wuxc.wisdomparty.WaterFallFlow.XListView.IXListViewListener;

public class AppearanceOfMember extends FragmentActivity
		implements OnClickListener, IXListViewListener, OnItemClickListener {
	private ImageView image_back;
	private ImageFetcher mImageFetcher;
	private XListView mAdapterView = null;
	private StaggeredAdapter mAdapter = null;
	private int currentPage = 0;
	ContentTask task = new ContentTask(this, 2);
	private String[] pic = { "one", "", "two", "one", "two", "one", "two", "two", "one", "two" };
	private int[] height = { 14, 20, 23, 14, 23, 14, 23, 23, 14, 23 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.appearanceofmember);
		image_back = (ImageView) findViewById(R.id.image_back);
		image_back.setOnClickListener(this);
		mAdapterView = (XListView) findViewById(R.id.list);
		mAdapterView.setPullLoadEnable(true);
		mAdapterView.setXListViewListener(this);
		mAdapterView.setOnItemClickListener(this);
		mAdapter = new StaggeredAdapter(this, mAdapterView);
		mImageFetcher = new ImageFetcher(this, 240);
		mImageFetcher.setLoadingImage(R.drawable.empty_photo);

	}

	private class ContentTask extends AsyncTask<String, Integer, List<AppearanceModel>> {

		private Context mContext;
		private int mType = 1;

		public ContentTask(Context context, int type) {
			super();
			mContext = context;
			mType = type;
		}

		@Override
		protected List<AppearanceModel> doInBackground(String... params) {
			try {
				return parseNewsJSON(params[0]);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(List<AppearanceModel> result) {
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

		public List<AppearanceModel> parseNewsJSON(String url) throws IOException {
			List<AppearanceModel> Appearance = new ArrayList<AppearanceModel>();
			String json = "";
			if (Helper.checkConnection(mContext)) {
				try {
					json = Helper.getStringFromUrl(url);

				} catch (IOException e) {
					Log.e("IOException is : ", e.toString());
					e.printStackTrace();
					return Appearance;
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
				// AppearanceModel newsInfo1 = new AppearanceModel();
				// newsInfo1.setAlbid(
				// newsInfoLeftObject.isNull("albid") ? "" :
				// newsInfoLeftObject.getString("albid"));
				// newsInfo1
				// .setIsrc(newsInfoLeftObject.isNull("isrc") ? "" :
				// newsInfoLeftObject.getString("isrc"));
				// newsInfo1.setMsg(newsInfoLeftObject.isNull("msg") ? "" :
				// newsInfoLeftObject.getString("msg"));
				// newsInfo1.setHeight(200);
				// Appearance.add(newsInfo1);
				// }
				// }
				for (int i = 0; i < 10; i++) {
					AppearanceModel appearancemodel = new AppearanceModel();
					appearancemodel.setImageUrl(pic[i]);
					appearancemodel.setWidth(20);
					appearancemodel.setHeight(height[i]);
					Appearance.add(appearancemodel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Appearance;
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
		private LinkedList<AppearanceModel> mInfos;
		private XListView mListView;

		public StaggeredAdapter(Context context, XListView xListView) {
			mContext = context;
			mInfos = new LinkedList<AppearanceModel>();
			mListView = xListView;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder;
			AppearanceModel appearancemodel = mInfos.get(position);

			if (convertView == null) {
				LayoutInflater layoutInflator = LayoutInflater.from(parent.getContext());
				convertView = layoutInflator.inflate(R.layout.item_appearance, null);
				holder = new ViewHolder();
				holder.imageheadimg = (ScaleImageView) convertView.findViewById(R.id.image_headimg);
				holder.texttitle = (TextView) convertView.findViewById(R.id.text_title);
				holder.textlabel = (TextView) convertView.findViewById(R.id.text_label);
				holder.imagecollect = (ImageView) convertView.findViewById(R.id.image_collect);
				holder.imagegreat = (ImageView) convertView.findViewById(R.id.image_great);
				convertView.setTag(holder);
			}

			holder = (ViewHolder) convertView.getTag();
			holder.imageheadimg.setImageWidth(appearancemodel.getWidth());
			holder.imageheadimg.setImageHeight(appearancemodel.getHeight());
			if (appearancemodel.getImageUrl().equals("one")) {
				holder.imageheadimg.setImageResource(R.drawable.appearance_one);
			} else if (appearancemodel.getImageUrl().equals("two")) {
				holder.imageheadimg.setImageResource(R.drawable.appearance_two);
			} else if (!TextUtils.isEmpty(appearancemodel.getImageUrl())) {
				mImageFetcher.loadImage(appearancemodel.getImageUrl(), holder.imageheadimg);
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

		public void addItemLast(List<AppearanceModel> datas) {
			mInfos.addAll(datas);
		}

		public void addItemTop(List<AppearanceModel> datas) {
			for (AppearanceModel info : datas) {
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
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), SpecialDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("Title", "中央党史研究新成果");
		bundle.putString("Time", "2016-11-23");
		bundle.putString("Name", "小李");
		intent.putExtras(bundle);

		// TODO Auto-generated method stub
		switch (v.getId()) {

		case R.id.image_back:
			finish();
			break;
		case R.id.image1:
			startActivity(intent);
			break;
		case R.id.image2:
			startActivity(intent);
			break;
		case R.id.image3:
			startActivity(intent);
			break;
		case R.id.image4:
			startActivity(intent);
			break;
		case R.id.image5:
			startActivity(intent);
			break;
		case R.id.image6:
			startActivity(intent);
			break;
		case R.id.image7:
			startActivity(intent);
			break;
		case R.id.image8:
			startActivity(intent);
			break;
		case R.id.image9:
			startActivity(intent);
			break;
		case R.id.image10:
			startActivity(intent);
			break;
		default:
			break;
		}
	}

}
