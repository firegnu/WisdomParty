package wuxc.wisdomparty.StartPage;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.ChildFragment.GuideFragment1;
import wuxc.wisdomparty.ChildFragment.GuideFragment2;
import wuxc.wisdomparty.ChildFragment.GuideFragment3;
import wuxc.wisdomparty.ChildFragment.GuideFragment4;
import wuxc.wisdomparty.layout.Childviewpaper;

public class GuidePageActivity extends FragmentActivity implements OnClickListener {
	private Childviewpaper ViewPaper;
	public List<Fragment> Fragments = new ArrayList<Fragment>();
	private FragmentManager FragmentManager;
	private int NumberPicture = 4;
	private SharedPreferences PreGuidePage;// 用于确定是否是第一次登录
	private TextView TextFinish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.guidepageactivity);
		ViewPaper = (Childviewpaper) findViewById(R.id.viewPager);
		TextFinish = (TextView) findViewById(R.id.text_finish);
		TextFinish.setOnClickListener(this);
		TextFinish.setVisibility(View.GONE);
		Fragments.clear();// 清空list
		initfragment();// list 装填fragment
		FragmentManager = getSupportFragmentManager();
		ViewPaper.setOffscreenPageLimit(NumberPicture);
		ViewPaper.setOnPageChangeListener(new MyOnPageChangeListener());
		ViewPaper.setAdapter(new MyPagerAdapter());
		PreGuidePage = getSharedPreferences("GuidePage", Context.MODE_PRIVATE);
		WriteGuidePage();
	}

	private void WriteGuidePage() {
		// TODO Auto-generated method stub
		Editor edit = PreGuidePage.edit();
		edit.putInt("GuidePage", 1);
		edit.commit();
	}

	private void initfragment() {
		// TODO Auto-generated method stub
		Fragments.add(new GuideFragment1());
		Fragments.add(new GuideFragment2());
		Fragments.add(new GuideFragment3());
		Fragments.add(new GuideFragment4());

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
			if (arg0 == NumberPicture - 1) {
				TextFinish.setVisibility(View.VISIBLE);
			} else {
				TextFinish.setVisibility(View.GONE);
			}
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
		case R.id.text_finish:
			Intent intent_test = new Intent();
			intent_test.setClass(getApplicationContext(), LoginAactivity.class);
			startActivity(intent_test);
			finish();

			break;

		default:
			break;
		}
	}
}
