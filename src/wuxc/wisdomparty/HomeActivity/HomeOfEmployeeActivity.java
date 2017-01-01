package wuxc.wisdomparty.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
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
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.ChildFragment.EmployeeExamFragment;
import wuxc.wisdomparty.ChildFragment.EmployeeOrganizationFragment;
import wuxc.wisdomparty.ChildFragment.EmployeeProjectFragment;
import wuxc.wisdomparty.layout.Childviewpaper;

public class HomeOfEmployeeActivity extends FragmentActivity implements OnClickListener {
	private Childviewpaper ViewPaper;
	public List<Fragment> Fragments = new ArrayList<Fragment>();
	private FragmentManager FragmentManager;
	private int NumberPicture = 3;
	private ImageView ImageBack;
	private TextView TextParty;
	private TextView TextInform;
	private TextView TextStudy;
	private TextView TextVote;
	private ImageView ImageParty;
	private ImageView ImageInform;
	private ImageView ImageStudy;
	private ImageView ImageVote;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_employee_activity);
		initview();
		setonclicklistener();
		Fragments.clear();// Çå¿Õlist
		initfragment();// list ×°Ìîfragment
		FragmentManager = getSupportFragmentManager();
		ViewPaper.setOffscreenPageLimit(NumberPicture);
		ViewPaper.setOnPageChangeListener(new MyOnPageChangeListener());
		ViewPaper.setAdapter(new MyPagerAdapter());
		changecaret(0);
	}

	private void changecaret(int i) {
		// TODO Auto-generated method stub
		ImageParty.setVisibility(View.GONE);
		ImageInform.setVisibility(View.GONE);
		ImageStudy.setVisibility(View.GONE);
		ImageVote.setVisibility(View.GONE);
		TextParty.setTextColor(Color.BLACK);
		TextInform.setTextColor(Color.BLACK);
		TextStudy.setTextColor(Color.BLACK);
		TextVote.setTextColor(Color.BLACK);
		if (i == 0) {
			ImageParty.setVisibility(View.VISIBLE);
			TextParty.setTextColor(Color.WHITE);
		} else if (i == 1) {
			ImageInform.setVisibility(View.VISIBLE);
			TextInform.setTextColor(Color.WHITE);
		} else if (i == 2) {
			ImageStudy.setVisibility(View.VISIBLE);
			TextStudy.setTextColor(Color.WHITE);
		} else if (i == 3) {
			ImageVote.setVisibility(View.VISIBLE);
			TextVote.setTextColor(Color.WHITE);
		} else {
			ImageParty.setVisibility(View.VISIBLE);
			TextParty.setTextColor(Color.WHITE);
		}
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
			changecaret(arg0);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	private void initfragment() {
		// TODO Auto-generated method stub
		Fragments.add(new EmployeeExamFragment());
		Fragments.add(new EmployeeProjectFragment());
		Fragments.add(new EmployeeOrganizationFragment());
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);

		TextParty.setOnClickListener(this);
		TextInform.setOnClickListener(this);
		TextStudy.setOnClickListener(this);
		TextVote.setOnClickListener(this);
	}

	private void initview() {
		// TODO Auto-generated method stub
		ViewPaper = (Childviewpaper) findViewById(R.id.viewPager);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		TextParty = (TextView) findViewById(R.id.text_party);
		TextInform = (TextView) findViewById(R.id.text_inform);
		TextStudy = (TextView) findViewById(R.id.text_study);
		TextVote = (TextView) findViewById(R.id.text_vote);
		ImageParty = (ImageView) findViewById(R.id.image_party);
		ImageInform = (ImageView) findViewById(R.id.image_inform);
		ImageStudy = (ImageView) findViewById(R.id.image_study);
		ImageVote = (ImageView) findViewById(R.id.image_vote);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.text_party:
			ViewPaper.setCurrentItem(0);
			changecaret(0);
			break;
		case R.id.text_inform:
			ViewPaper.setCurrentItem(1);
			changecaret(1);
			break;
		case R.id.text_study:
			ViewPaper.setCurrentItem(2);
			changecaret(2);
			break;
		case R.id.text_vote:
			ViewPaper.setCurrentItem(3);
			changecaret(3);
			break;
		default:
			break;
		}

	}

}
