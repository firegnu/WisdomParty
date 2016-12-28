package wuxc.wisdomparty.ChildFragment;

import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Adapter.RewardsAdapter;
import wuxc.wisdomparty.Adapter.StudyVideoAadapter;
import wuxc.wisdomparty.Model.RewardsModel;
import wuxc.wisdomparty.Model.StudyVideoModel;
import wuxc.wisdomparty.PartyManage.RewardsDetailActivity;
import wuxc.wisdomparty.PartyManage.StudyArticleDetailActivity;
import wuxc.wisdomparty.PartyManage.StudyVideoDetailActivity;

public class MainPublicPageStudyFragment extends Fragment
		implements OnTouchListener, OnClickListener, OnItemClickListener {
	private TextView text_list_title;
	private ListView ListData;
	List<RewardsModel> list = new ArrayList<RewardsModel>();
	private static RewardsAdapter mAdapter;
	List<StudyVideoModel> listVideo = new ArrayList<StudyVideoModel>();
	private static StudyVideoAadapter VAdapter;
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
	private int type = 0;// 0=article 1=video
	private TextView TextArticle;
	private TextView TextVideo;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// startpicturefly();
		// changetime();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.main_publicpage_study_fragment, container, false);
		text_list_title = (TextView) view.findViewById(R.id.text_list_title);
		initview(view);
		setonclicklistener();
		setheadtextview();
		getdatalist(curPage);
		return view;
	}

	private void setheadtextview() {
		headTextView = new TextView(getActivity());
		headTextView.setGravity(Gravity.CENTER);
		headTextView.setMinHeight(100);
		headTextView.setText("正在刷新...");
		headTextView.setTypeface(Typeface.DEFAULT_BOLD);
		headTextView.setTextSize(15);
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
			if (type == 0) {
				for (int i = 0; i < 10; i++) {

					RewardsModel listinfo = new RewardsModel();
					listinfo.setTime("2016-12-14");
					listinfo.setDetail(
							"中共十八大习近平总书记的讲话中共十八大习近平总书记的讲话中共十八大习近平总书记的讲话中共十八大习近平总书记的讲话中共十八大习近平总书记的讲话中共十八大习近平总书记的讲话");
					listinfo.setTitle("中共十八大习近平总书记的讲话" + arg);
					listinfo.setBackGround("");
					;
					list.add(listinfo);

				}
			} else {
				for (int i = 0; i < 10; i++) {
					StudyVideoModel listinfo = new StudyVideoModel();
					listinfo.setTime("2016-12-14");
					listinfo.setTitle("中共十八大习近平总书记的讲话" + arg);
					listinfo.setTimeLong("23:10");
					listinfo.setNumberCollect("12");
					listinfo.setNumberGreat("23");
					listinfo.setLabel1("扶贫");
					listinfo.setLabel2("共产党");
					listinfo.setLabel3("一家亲");
					listinfo.setImageUrl("");
					listVideo.add(listinfo);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (arg == 1) {
			go();
		} else {
			if (type == 0) {
				mAdapter.notifyDataSetChanged();
			} else {
				VAdapter.notifyDataSetChanged();
			}

		}

	}

	protected void go() {
		ListData.setPadding(0, -100, 0, 0);
		if (type == 0) {
			mAdapter = new RewardsAdapter(getActivity(), list, ListData);
			ListData.setAdapter(mAdapter);
		} else {
			VAdapter = new StudyVideoAadapter(getActivity(), listVideo, ListData);
			ListData.setAdapter(VAdapter);
		}

	}

	private void initview(View view) {
		// TODO Auto-generated method stub
		ListData = (ListView) view.findViewById(R.id.list_data);
		TextArticle = (TextView) view.findViewById(R.id.text_article);
		TextVideo = (TextView) view.findViewById(R.id.text_video);
		TextArticle.setTextColor(Color.RED);
		TextVideo.setTextColor(Color.BLACK);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ListData.setOnItemClickListener(this);
		TextArticle.setOnClickListener(this);
		TextVideo.setOnClickListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		float tempY = event.getY();
		float tempyfoot = event.getY();
		firstItemIndex = ListData.getFirstVisiblePosition();
		lastItemIndex = ListData.getLastVisiblePosition();
		// Toast.makeText(getActivity(), " lastItemIndex" +
		// lastItemIndex, Toast.LENGTH_SHORT).show();
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
				Toast.makeText(getActivity(), "正在刷新", Toast.LENGTH_SHORT).show();
				getdatalist(curPage);
			}
			int temp = 1;
			temp = (lastItemIndex) % pageSize;
			// temp = 0;
			if (temp == 0 && (startYfoot - tempyfoot > 400)) {
				curPage++;
				if (curPage > totalPage) {
					Toast.makeText(getActivity(), " 没有更多了", Toast.LENGTH_SHORT).show();
					// // listinfoagain();
				} else {
					getdatalist(curPage);
					Toast.makeText(getActivity(), "正在加载下一页", Toast.LENGTH_SHORT).show();
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
		if (type == 0) {
			RewardsModel data = list.get(position - 1);
			Intent intent = new Intent();
			intent.setClass(getActivity(), StudyArticleDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("Title", data.getTitle());
			bundle.putString("Time", data.getTime());
			intent.putExtras(bundle);
			startActivity(intent);
		} else {
			StudyVideoModel data = listVideo.get(position - 1);
			Intent intent = new Intent();
			intent.setClass(getActivity(), StudyVideoDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("Title", data.getTitle());
			bundle.putString("Time", data.getTime());
			bundle.putString("TimeLong", data.getTimeLong());
			intent.putExtras(bundle);
			startActivity(intent);
		}

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onStart() {
		super.onStart();

	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.text_list_title:

			break;
		case R.id.text_article:
			type = 0;
			getdatalist(1);
			curPage = 1;
			TextArticle.setTextColor(Color.RED);
			TextVideo.setTextColor(Color.BLACK);
			break;
		case R.id.text_video:
			type = 1;
			getdatalist(1);
			curPage = 1;
			TextVideo.setTextColor(Color.RED);
			TextArticle.setTextColor(Color.BLACK);
			break;
		default:
			break;
		}
	}

}
