package wuxc.wisdomparty.HomeActivity;

import java.util.ArrayList;
import java.util.List;

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
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdmparty.HomeOfYouth.DynamicActivity;
import wuxc.wisdmparty.HomeOfYouth.AppearanceOfMember;
import wuxc.wisdomparty.Adapter.SpecialAdapter;
import wuxc.wisdomparty.ChildFragment.YouthTopEightFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopFiveFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopFourFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopNineFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopOneFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopSevenFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopSixFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopTenFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopThreeFragment;
import wuxc.wisdomparty.ChildFragment.YouthTopTwoFragment;
import wuxc.wisdomparty.Model.SpecialModel;
import wuxc.wisdomparty.PartyManage.SpecialDetailActivity;
import wuxc.wisdomparty.layout.Childviewpaper;

public class HomeOfYouthActivity extends FragmentActivity implements OnClickListener {
	private RelativeLayout RelativeViewPage;
	private Childviewpaper ViewPaper;
	private ImageView dot1, dot2, dot3, dot4, dot5, dot6, dot7, dot8, dot9, dot10;
	private ImageView[] dot = { dot1, dot2, dot3, dot4, dot5, dot6, dot7, dot8, dot9, dot10 };
	private int screenwidth;
	private int ScreenHeight = 0;
	public List<Fragment> Fragments = new ArrayList<Fragment>();
	private FragmentManager FragmentManager;
	private int NumberPicture = 4;
	private ImageView ImageBack;
	private LinearLayout LinAppearance;
	private LinearLayout LinDynamic;
	private TextView TextAppearanceDetail;
	private TextView TextDynamicDetail;
	private TextView TextDynamicTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_youth_activity);
		initview();
		setonclicklistener();
		initviewHeight();
		SetText();
		Fragments.clear();// 清空list
		initfragment();// list 装填fragment
		FragmentManager = getSupportFragmentManager();
		ViewPaper.setOffscreenPageLimit(NumberPicture);
		ViewPaper.setOnPageChangeListener(new MyOnPageChangeListener());
		ViewPaper.setAdapter(new MyPagerAdapter());
		initdot(NumberPicture);
		godotchange(0);// 显示第一个逗点为绿色
	}

	private void SetText() {
		// TODO Auto-generated method stub
		TextDynamicDetail.setText("不放弃努力本是我的任务，在现有的基础上争取再争取更是我的职责。");
		TextDynamicTime.setText("2017-01-12");
		TextAppearanceDetail.setText("展现自我，成就人生，奉献社会");
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
		Fragments.add(new YouthTopOneFragment());
		Fragments.add(new YouthTopTwoFragment());
		Fragments.add(new YouthTopThreeFragment());
		Fragments.add(new YouthTopFourFragment());
		Fragments.add(new YouthTopFiveFragment());
		Fragments.add(new YouthTopSixFragment());
		Fragments.add(new YouthTopSevenFragment());
		Fragments.add(new YouthTopEightFragment());
		Fragments.add(new YouthTopNineFragment());
		Fragments.add(new YouthTopTenFragment());
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		LinAppearance.setOnClickListener(this);
		LinDynamic.setOnClickListener(this);
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
		ImageBack = (ImageView) findViewById(R.id.image_back);
		LinAppearance = (LinearLayout) findViewById(R.id.lin_appearance);
		LinDynamic = (LinearLayout) findViewById(R.id.lin_dynamic);
		TextAppearanceDetail = (TextView) findViewById(R.id.text_appearance_detail);
		TextDynamicTime = (TextView) findViewById(R.id.text_dynamic_time);
		TextDynamicDetail = (TextView) findViewById(R.id.text_dynamic_detail);
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
		case R.id.lin_dynamic:
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), DynamicActivity.class);
			startActivity(intent);
			break;
		case R.id.lin_appearance:
			Intent intent2 = new Intent();
			intent2.setClass(getApplicationContext(), AppearanceOfMember.class);
			startActivity(intent2);
			break;
		default:
			break;
		}
	}

}
