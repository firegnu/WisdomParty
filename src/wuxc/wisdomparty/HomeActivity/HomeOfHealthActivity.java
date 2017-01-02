package wuxc.wisdomparty.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Text;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Adapter.SpecialAdapter;
import wuxc.wisdomparty.ChildFragment.SpecialTopEightFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopFiveFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopFourFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopNineFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopOneFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopSevenFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopSixFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopTenFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopThreeFragment;
import wuxc.wisdomparty.ChildFragment.SpecialTopTwoFragment;
import wuxc.wisdomparty.Model.SpecialModel;
import wuxc.wisdomparty.OtherActivity.Dongtai;
import wuxc.wisdomparty.OtherActivity.Tuanyuan;
import wuxc.wisdomparty.OtherActivity.Yangsheng;
import wuxc.wisdomparty.OtherActivity.yaodian;
import wuxc.wisdomparty.PartyManage.SpecialDetailActivity;
import wuxc.wisdomparty.layout.Childviewpaper;

public class HomeOfHealthActivity extends FragmentActivity
		implements OnTouchListener, OnClickListener, OnItemClickListener {
	private RelativeLayout RelativeViewPage;
	private Childviewpaper ViewPaper;
	private ImageView dot1, dot2, dot3, dot4, dot5, dot6, dot7, dot8, dot9, dot10;
	private ImageView[] dot = { dot1, dot2, dot3, dot4, dot5, dot6, dot7, dot8, dot9, dot10 };
	private int screenwidth;
	private int ScreenHeight = 0;
	public List<Fragment> Fragments = new ArrayList<Fragment>();
	private FragmentManager FragmentManager;
	private int NumberPicture = 4;
	private String[] Title = { "习大大的讲话1", "习大大的讲话2", "习大大的讲话3", "习大大的讲话4", "习大大的讲话5", "习大大的讲话6", "习大大的讲话7", "习大大的讲话8",
			"习大大的讲话9", "习大大的讲话10" };
	private TextView TextTitle;
	private ListView ListData;
	private ImageView ImageBack;
	List<SpecialModel> list = new ArrayList<SpecialModel>();
	private static SpecialAdapter mAdapter;
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
	private ImageView img1;
	private ImageView img2;
	private ImageView img3;
	private ImageView img4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_health_activity);
		initview();
		setonclicklistener();
		initviewHeight();
		Fragments.clear();// 清空list
		initfragment();// list 装填fragment
		FragmentManager = getSupportFragmentManager();
		ViewPaper.setOffscreenPageLimit(NumberPicture);
		ViewPaper.setOnPageChangeListener(new MyOnPageChangeListener());
		ViewPaper.setAdapter(new MyPagerAdapter());
		initdot(NumberPicture);
		godotchange(0);// 显示第一个逗点为绿色
		setheadtextview();
		getdatalist(curPage);
	}

	private void setheadtextview() {
		headTextView = new TextView(this);
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

			for (int i = 0; i < 10; i++) {

				SpecialModel listinfo = new SpecialModel();
				listinfo.setTime("2016-12-14");
				listinfo.setDetail(
						"中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果中共党史研究新成果"
								+ arg);
				listinfo.setTitle("中共党史研究新成果" + arg);
				listinfo.setNumber("23");
				listinfo.setImageUrl("");
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
		mAdapter = new SpecialAdapter(this, list, ListData);
		ListData.setAdapter(mAdapter);
	}

	private void initdot(int numpic) {
		// TODO Auto-generated method stub
		for (int i = 9; i >= numpic; i--) {
			dot[i].setVisibility(View.GONE);
		}
	}

	private void godotchange(int position) {
		for (int i = 0; i < NumberPicture; i++) {
			dot[i].setBackgroundResource(R.drawable.dotn);
		}
		dot[position].setBackgroundResource(R.drawable.dotc);
		TextTitle.setText(Title[position]);
	}

	private void initfragment() {
		// TODO Auto-generated method stub
		Fragments.add(new SpecialTopOneFragment());
		Fragments.add(new SpecialTopTwoFragment());
		Fragments.add(new SpecialTopThreeFragment());
		Fragments.add(new SpecialTopFourFragment());
		Fragments.add(new SpecialTopFiveFragment());
		Fragments.add(new SpecialTopSixFragment());
		Fragments.add(new SpecialTopSevenFragment());
		Fragments.add(new SpecialTopEightFragment());
		Fragments.add(new SpecialTopNineFragment());
		Fragments.add(new SpecialTopTenFragment());
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		ListData.setOnItemClickListener(this);
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		img3.setOnClickListener(this);
		img4.setOnClickListener(this);
	}

	private void initviewHeight() {
		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		ScreenHeight = (int) (screenwidth / 2);
		LinearLayout.LayoutParams LayoutParams = (android.widget.LinearLayout.LayoutParams) RelativeViewPage
				.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		RelativeViewPage.setLayoutParams(LayoutParams);
	}

	private void initview() {
		// TODO Auto-generated method stub
		RelativeViewPage = (RelativeLayout) findViewById(R.id.rel_viewpaper);
		ViewPaper = (Childviewpaper) findViewById(R.id.viewPager);
		TextTitle = (TextView) findViewById(R.id.text_title);
		dot[0] = (ImageView) findViewById(R.id.dot1);
		dot[1] = (ImageView) findViewById(R.id.dot2);
		dot[2] = (ImageView) findViewById(R.id.dot3);
		dot[3] = (ImageView) findViewById(R.id.dot4);
		dot[4] = (ImageView) findViewById(R.id.dot5);
		dot[5] = (ImageView) findViewById(R.id.dot6);
		dot[6] = (ImageView) findViewById(R.id.dot7);
		dot[7] = (ImageView) findViewById(R.id.dot8);
		dot[8] = (ImageView) findViewById(R.id.dot9);
		dot[9] = (ImageView) findViewById(R.id.dot10);
		ListData = (ListView) findViewById(R.id.list_data);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		img1 = (ImageView) findViewById(R.id.img1);
		img2 = (ImageView) findViewById(R.id.img2);
		img3 = (ImageView) findViewById(R.id.img3);
		img4 = (ImageView) findViewById(R.id.img4);
	}

	private class MyPagerAdapter extends PagerAdapter {
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getCount() {
			return NumberPicture;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(Fragments.get(position).getView());
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			Fragment fragment = Fragments.get(position);
			if (!fragment.isAdded()) {
				FragmentTransaction ft = FragmentManager.beginTransaction();
				ft.add(fragment, fragment.getClass().getSimpleName());
				ft.commit();
				FragmentManager.executePendingTransactions();
			}

			if (fragment.getView().getParent() == null) {
				container.addView(fragment.getView());
			}
			return fragment.getView();
		}
	};

	public class MyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			godotchange(arg0);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.img1:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), yaodian.class);
			startActivity(intent);
			break;
		case R.id.img2:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(), Yangsheng.class);
			startActivity(intent2);
			break;
		case R.id.img3:
			Intent intent3 = new Intent();
			intent3.setClass(getApplicationContext(), Yangsheng.class);
			startActivity(intent3);
			break;
		case R.id.img4:
			Intent intent4 = new Intent();
			intent4.setClass(getApplicationContext(), Yangsheng.class);
			startActivity(intent4);
			break;
		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		SpecialModel data = list.get(position - 1);
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), SpecialDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("Title", data.getTitle());
		bundle.putString("Time", data.getTime());
		bundle.putString("Name", "名字");
		intent.putExtras(bundle);
		startActivity(intent);
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
				Toast.makeText(getApplicationContext(), "正在刷新", Toast.LENGTH_SHORT).show();
				getdatalist(curPage);
			}
			int temp = 1;
			temp = (lastItemIndex) % pageSize;
			// temp = 0;
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

}
