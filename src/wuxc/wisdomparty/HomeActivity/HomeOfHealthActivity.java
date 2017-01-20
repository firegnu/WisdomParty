package wuxc.wisdomparty.HomeActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.w3c.dom.Text;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
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
import wuxc.wisdomparty.Adapter.HealthAdapter;
import wuxc.wisdomparty.ChildFragment.HealthEightFragment;
import wuxc.wisdomparty.ChildFragment.HealthFiveFragment;
import wuxc.wisdomparty.ChildFragment.HealthFourFragment;
import wuxc.wisdomparty.ChildFragment.HealthNineFragment;
import wuxc.wisdomparty.ChildFragment.HealthOneFragment;
import wuxc.wisdomparty.ChildFragment.HealthSevenFragment;
import wuxc.wisdomparty.ChildFragment.HealthSixFragment;
import wuxc.wisdomparty.ChildFragment.HealthTenFragment;
import wuxc.wisdomparty.ChildFragment.HealthThreeFragment;
import wuxc.wisdomparty.ChildFragment.HealthTwoFragment;
import wuxc.wisdomparty.HomeOfHealth.RegimenOfHealth;
import wuxc.wisdomparty.HomeOfHealth.MedicalShopOfHealth;
import wuxc.wisdomparty.HomeOfHealth.RegimenDetailActivity;
import wuxc.wisdomparty.Model.HealthModel;
import wuxc.wisdomparty.layout.Childviewpaper;

public class HomeOfHealthActivity extends FragmentActivity implements OnClickListener, OnItemClickListener {
	private RelativeLayout RelativeViewPage;
	private Childviewpaper ViewPaper;
	private ImageView dot1, dot2, dot3, dot4, dot5, dot6, dot7, dot8, dot9, dot10;
	private ImageView[] dot = { dot1, dot2, dot3, dot4, dot5, dot6, dot7, dot8, dot9, dot10 };
	private int screenwidth;
	private int ScreenHeight = 0;
	public List<Fragment> Fragments = new ArrayList<Fragment>();
	private FragmentManager FragmentManager;
	private int NumberPicture = 4;
	private ListView ListData;
	private ImageView ImageBack;
	List<HealthModel> list = new ArrayList<HealthModel>();
	private static HealthAdapter mAdapter;

	private int pageSize = 10;
	private int totalPage = 5;
	private int curPage = 1;

	private LinearLayout LinWebMedical;
	private LinearLayout LinHealth;

	private float scale = 0;
	private float scalepx = 0;
	private float dp = 0;
	private TextView TextWarning;

	private TextView TextMore;
	private TextView TextHealthMore;
	private LinearLayout LinWebMedicalLeft;
	private LinearLayout LinWebMedicalRightTop;
	private LinearLayout LinWebMedicalRightBottom;
	private LinearLayout LinHealthLeft;
	private LinearLayout LinHealthRight;
	private Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg1) {
			switch (msg1.what) {
			case 0:
				getdatalist(curPage);
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
		setlistheight(0);
		starttimedelay();
	}

	private void starttimedelay() {
		// 原因：不延时的话list会滑到顶部
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {

				Message msg1 = new Message();
				msg1.what = 0;
				uiHandler.sendMessage(msg1);

			}

		}, 2000);
	}

	private void getdatalist(int arg) {
		if (arg == 1) {
			list.clear();
		}
		// TODO Auto-generated method stub

		try {

			for (int i = 0; i < 10; i++) {

				HealthModel listinfo = new HealthModel();

				listinfo.setTitle("最健康的养生法，我在这里，你在哪呢？" + i);
				listinfo.setLabel("养生专栏");
				listinfo.setCollect("23");
				listinfo.setGreat("45");
				listinfo.setIamgeUrl("");
				listinfo.setIsCollect(true);
				listinfo.setIsGreat(false);
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
		setlistheight(list.size());
		if (arg == totalPage) {
			TextWarning.setText("没有更多了");
		} else {
			TextWarning.setText("点击加载更多");
		}
	}

	private void setlistheight(int size) {
		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		DisplayMetrics mMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
		scale = getResources().getDisplayMetrics().density;
		dp = screenwidth / scale + 0.5f;
		scalepx = screenwidth / dp;
		int height = (int) (size * (screenwidth * 0.5 + 96 * scalepx));
		LinearLayout.LayoutParams layoutParams1 = (android.widget.LinearLayout.LayoutParams) ListData.getLayoutParams();
		layoutParams1.height = height;
		ListData.setLayoutParams(layoutParams1);

	}

	protected void go() {

		mAdapter = new HealthAdapter(this, list, ListData);
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

	}

	private void initfragment() {
		// TODO Auto-generated method stub
		Fragments.add(new HealthOneFragment());
		Fragments.add(new HealthTwoFragment());
		Fragments.add(new HealthThreeFragment());
		Fragments.add(new HealthFourFragment());
		Fragments.add(new HealthFiveFragment());
		Fragments.add(new HealthSixFragment());
		Fragments.add(new HealthSevenFragment());
		Fragments.add(new HealthEightFragment());
		Fragments.add(new HealthNineFragment());
		Fragments.add(new HealthTenFragment());
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		ListData.setOnItemClickListener(this);
		TextWarning.setOnClickListener(this);
		TextMore.setOnClickListener(this);
		TextHealthMore.setOnClickListener(this);
		LinWebMedicalLeft.setOnClickListener(this);
		LinWebMedicalRightTop.setOnClickListener(this);
		LinWebMedicalRightBottom.setOnClickListener(this);
		LinHealthLeft.setOnClickListener(this);
		LinHealthRight.setOnClickListener(this);

	}

	private void initviewHeight() {
		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		ScreenHeight = (int) (screenwidth / 2);
		LinearLayout.LayoutParams LayoutParams = (android.widget.LinearLayout.LayoutParams) RelativeViewPage
				.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		RelativeViewPage.setLayoutParams(LayoutParams);
		ScreenHeight = (int) (screenwidth / 3.4);
		LayoutParams = (android.widget.LinearLayout.LayoutParams) LinWebMedical.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		LinWebMedical.setLayoutParams(LayoutParams);
		ScreenHeight = (int) (screenwidth / 4);
		LayoutParams = (android.widget.LinearLayout.LayoutParams) LinHealth.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		LinHealth.setLayoutParams(LayoutParams);
	}

	private void initview() {
		// TODO Auto-generated method stub
		RelativeViewPage = (RelativeLayout) findViewById(R.id.rel_viewpaper);
		ViewPaper = (Childviewpaper) findViewById(R.id.viewPager);

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
		LinWebMedical = (LinearLayout) findViewById(R.id.lin_webmedical);
		LinHealth = (LinearLayout) findViewById(R.id.lin_health);
		TextMore = (TextView) findViewById(R.id.text_more);
		TextHealthMore = (TextView) findViewById(R.id.text_more_health);
		LinWebMedicalLeft = (LinearLayout) findViewById(R.id.lin_webmedical_left);
		LinWebMedicalRightTop = (LinearLayout) findViewById(R.id.lin_webmedical_right_top);
		LinWebMedicalRightBottom = (LinearLayout) findViewById(R.id.lin_webmedical_right_bottom);
		LinHealthLeft = (LinearLayout) findViewById(R.id.lin_health_left);
		LinHealthRight = (LinearLayout) findViewById(R.id.lin_health_right);
		TextWarning = (TextView) findViewById(R.id.text_warning);
		TextWarning.setText("正在加载数据...");
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
		case R.id.text_warning:
			curPage++;
			if (!(curPage > totalPage)) {
				getdatalist(curPage);
				Toast.makeText(getApplicationContext(), "正在加载", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.text_more:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), MedicalShopOfHealth.class);
			startActivity(intent);
			break;
		case R.id.lin_webmedical_left:
			Toast.makeText(getApplicationContext(), "药店", Toast.LENGTH_SHORT).show();
			break;
		case R.id.lin_webmedical_right_top:
			Toast.makeText(getApplicationContext(), "药店", Toast.LENGTH_SHORT).show();
			break;
		case R.id.lin_webmedical_right_bottom:
			Toast.makeText(getApplicationContext(), "药店", Toast.LENGTH_SHORT).show();
			break;
		case R.id.text_more_health:
			Intent intent1 = new Intent();
			intent1.setClass(getApplicationContext(), RegimenOfHealth.class);
			startActivity(intent1);
			break;
		case R.id.lin_health_left:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(), RegimenDetailActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("PageTitle", "中医养生");
			bundle.putString("Time", "2016-11-26");
			bundle.putString("Name", "新华社");
			bundle.putString("Title", "补血顺气");
			bundle.putString("Detail",
					"中医学以阴阳五行作为理论基础，将人体看成是气、形、神的统一体，通过望闻问切四诊合参的方法，探求病因、病性、病位、分析病机及人体内五脏六腑、经络关节、气血津液的变化、判断邪正消长，进而得出病名，归纳出证型，以辨证论治原则，制定汗、吐、下、和、温、清、补、消等治法，使用中药、针灸、推拿、按摩、拔罐、气功、食疗等多种治疗手段，使人体达到阴阳调和而康复。");
			intent2.putExtras(bundle);
			startActivity(intent2);
			break;
		case R.id.lin_health_right:
			Intent intent3 = new Intent();
			intent3.setClass(getApplicationContext(), RegimenDetailActivity.class);
			Bundle bundle3 = new Bundle();
			bundle3.putString("PageTitle", "中医养生");
			bundle3.putString("Time", "2016-11-26");
			bundle3.putString("Name", "新华社");
			bundle3.putString("Title", "补血顺气");
			bundle3.putString("Detail",
					"中医学以阴阳五行作为理论基础，将人体看成是气、形、神的统一体，通过望闻问切四诊合参的方法，探求病因、病性、病位、分析病机及人体内五脏六腑、经络关节、气血津液的变化、判断邪正消长，进而得出病名，归纳出证型，以辨证论治原则，制定汗、吐、下、和、温、清、补、消等治法，使用中药、针灸、推拿、按摩、拔罐、气功、食疗等多种治疗手段，使人体达到阴阳调和而康复。");
			intent3.putExtras(bundle3);
			startActivity(intent3);
			break;
		default:
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		HealthModel data = list.get(position);
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), RegimenDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("PageTitle", data.getLabel());
		bundle.putString("Time", "2016-11-26");
		bundle.putString("Name", "新华社");
		bundle.putString("Title", data.getTitle());
		bundle.putString("Detail",
				"中医学以阴阳五行作为理论基础，将人体看成是气、形、神的统一体，通过望闻问切四诊合参的方法，探求病因、病性、病位、分析病机及人体内五脏六腑、经络关节、气血津液的变化、判断邪正消长，进而得出病名，归纳出证型，以辨证论治原则，制定汗、吐、下、和、温、清、补、消等治法，使用中药、针灸、推拿、按摩、拔罐、气功、食疗等多种治疗手段，使人体达到阴阳调和而康复。");
		intent.putExtras(bundle);
		startActivity(intent);
	}

}
