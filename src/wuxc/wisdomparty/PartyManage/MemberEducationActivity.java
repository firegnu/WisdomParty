package wuxc.wisdomparty.PartyManage;

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
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.ChildFragment.MemberEducationEightFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationFiveFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationFourFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationNineFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationOneFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationSevenFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationSixFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationTenFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationThreeFragment;
import wuxc.wisdomparty.ChildFragment.MemberEducationTwoFragment;
import wuxc.wisdomparty.layout.Childviewpaper;

public class MemberEducationActivity extends FragmentActivity implements OnClickListener {
	public Childviewpaper viewPager;
	public List<Fragment> fragments = new ArrayList<Fragment>();
	private int temp;
	private FragmentManager fragmentManager;
	private LinearLayout lin_label1;
	private Button btn_labelup1;
	private Button btn_labeldown1;
	private LinearLayout lin_label2;
	private Button btn_labelup2;
	private Button btn_labeldown2;
	private LinearLayout lin_label3;
	private Button btn_labelup3;
	private Button btn_labeldown3;
	private LinearLayout lin_label4;
	private Button btn_labelup4;
	private Button btn_labeldown4;
	private LinearLayout lin_label5;
	private Button btn_labelup5;
	private Button btn_labeldown5;
	private LinearLayout lin_label6;
	private Button btn_labelup6;
	private Button btn_labeldown6;
	private LinearLayout lin_label7;
	private Button btn_labelup7;
	private Button btn_labeldown7;
	private LinearLayout lin_label8;
	private Button btn_labelup8;
	private Button btn_labeldown8;
	private LinearLayout lin_label9;
	private Button btn_labelup9;
	private Button btn_labeldown9;
	private LinearLayout lin_label10;
	private Button btn_labelup10;
	private Button btn_labeldown10;
	private HorizontalScrollView scro;

	private int currfragment = 0;
	private int screenwidth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_education_activity);
		initview();
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		showlabelchange();
		showbtntext();
		fragments.clear();
		initfragment(10);
		fragmentManager = this.getSupportFragmentManager();
		viewPager = (Childviewpaper) findViewById(R.id.viewPager);
		viewPager.setOffscreenPageLimit(10);
		viewPager.setOnPageChangeListener(new twoMyOnPageChangeListener());
		viewPager.setAdapter(new twoMyPagerAdapter());
	}

	private void showbtntext() {
		// TODO Auto-generated method stub
		btn_labelup1.setText("两学一做1");
		btn_labelup2.setText("两学一做2");
		btn_labelup3.setText("两学一做3");
		btn_labelup4.setText("两学一做4");
		btn_labelup5.setText("两学一做5");
		btn_labelup6.setText("两学一做6");
		btn_labelup7.setText("两学一做7");
		btn_labelup8.setText("两学一做8");
		btn_labelup9.setText("两学一做9");
		btn_labelup10.setText("两学一做10");
	}

	private void initview() {
		// TODO Auto-generated method stub
		lin_label1 = (LinearLayout) findViewById(R.id.lin_label1);
		btn_labelup1 = (Button) findViewById(R.id.btn_labelup1);
		btn_labeldown1 = (Button) findViewById(R.id.btn_labeldown1);
		lin_label2 = (LinearLayout) findViewById(R.id.lin_label2);
		btn_labelup2 = (Button) findViewById(R.id.btn_labelup2);
		btn_labeldown2 = (Button) findViewById(R.id.btn_labeldown2);
		lin_label3 = (LinearLayout) findViewById(R.id.lin_label3);
		btn_labelup3 = (Button) findViewById(R.id.btn_labelup3);
		btn_labeldown3 = (Button) findViewById(R.id.btn_labeldown3);
		lin_label4 = (LinearLayout) findViewById(R.id.lin_label4);
		btn_labelup4 = (Button) findViewById(R.id.btn_labelup4);
		btn_labeldown4 = (Button) findViewById(R.id.btn_labeldown4);
		lin_label5 = (LinearLayout) findViewById(R.id.lin_label5);
		btn_labelup5 = (Button) findViewById(R.id.btn_labelup5);
		btn_labeldown5 = (Button) findViewById(R.id.btn_labeldown5);
		lin_label6 = (LinearLayout) findViewById(R.id.lin_label6);
		btn_labelup6 = (Button) findViewById(R.id.btn_labelup6);
		btn_labeldown6 = (Button) findViewById(R.id.btn_labeldown6);
		lin_label7 = (LinearLayout) findViewById(R.id.lin_label7);
		btn_labelup7 = (Button) findViewById(R.id.btn_labelup7);
		btn_labeldown7 = (Button) findViewById(R.id.btn_labeldown7);
		lin_label8 = (LinearLayout) findViewById(R.id.lin_label8);
		btn_labelup8 = (Button) findViewById(R.id.btn_labelup8);
		btn_labeldown8 = (Button) findViewById(R.id.btn_labeldown8);
		lin_label9 = (LinearLayout) findViewById(R.id.lin_label9);
		btn_labelup9 = (Button) findViewById(R.id.btn_labelup9);
		btn_labeldown9 = (Button) findViewById(R.id.btn_labeldown9);
		lin_label10 = (LinearLayout) findViewById(R.id.lin_label10);
		btn_labelup10 = (Button) findViewById(R.id.btn_labelup10);
		btn_labeldown10 = (Button) findViewById(R.id.btn_labeldown10);
		btn_labelup1.setOnClickListener(this);
		btn_labelup2.setOnClickListener(this);
		btn_labelup3.setOnClickListener(this);
		btn_labelup4.setOnClickListener(this);
		btn_labelup5.setOnClickListener(this);
		btn_labelup6.setOnClickListener(this);
		btn_labelup7.setOnClickListener(this);
		btn_labelup8.setOnClickListener(this);
		btn_labelup9.setOnClickListener(this);
		btn_labelup10.setOnClickListener(this);
		scro = (HorizontalScrollView) findViewById(R.id.scro);

	}

	private void showlabelchange() {
		if (currfragment == 0) {
			btn_labeldown1.setBackgroundResource(R.drawable.shapered);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
			btn_labelup1.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
		} else if (currfragment == 1) {
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapered);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
		} else if (currfragment == 2) {
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapered);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
		} else if (currfragment == 3) {
			scro.scrollTo(0, 0);
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapered);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
		} else if (currfragment == 4) {
			scro.scrollTo(temp, 0);
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapered);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
		} else if (currfragment == 5) {
			scro.scrollTo(2 * temp, 0);
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapered);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
		} else if (currfragment == 6) {
			scro.scrollTo(3 * temp, 0);
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapered);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
		} else if (currfragment == 7) {
			scro.scrollTo(4 * temp, 0);
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapered);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
		} else if (currfragment == 8) {
			scro.scrollTo(5 * temp, 0);
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(196, 5, 5));
			btn_labelup10.setTextColor(Color.rgb(0, 0, 0));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapered);
			btn_labeldown10.setBackgroundResource(R.drawable.shapewhite);
		} else if (currfragment == 9) {
			scro.scrollTo(6 * temp, 0);
			btn_labelup1.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup2.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup3.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup4.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup5.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup6.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup7.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup8.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup9.setTextColor(Color.rgb(0, 0, 0));
			btn_labelup10.setTextColor(Color.rgb(196, 5, 5));
			btn_labeldown1.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown2.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown3.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown4.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown5.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown6.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown7.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown8.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown9.setBackgroundResource(R.drawable.shapewhite);
			btn_labeldown10.setBackgroundResource(R.drawable.shapered);
		}
	}

	private class twoMyPagerAdapter extends PagerAdapter {
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public int getCount() {

			return fragments.size();
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(fragments.get(position).getView());
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			Fragment fragment = fragments.get(position);

			if (!fragment.isAdded()) { // 锟斤拷锟絝ragment锟斤拷没锟斤拷added
				FragmentTransaction ft = fragmentManager.beginTransaction();
				ft.add(fragment, fragment.getClass().getSimpleName());
				ft.commit();
				fragmentManager.executePendingTransactions();
			}

			if (fragment.getView().getParent() == null) {
				container.addView(fragment.getView()); // 为viewpager锟斤拷锟接诧拷锟斤拷
			}
			return fragment.getView();
		}
	};

	public class twoMyOnPageChangeListener implements OnPageChangeListener {
		@Override
		public void onPageSelected(int arg0) {
			currfragment = arg0;
			showlabelchange();
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
		case R.id.btn_labelup1:
			viewPager.setCurrentItem(0);
			break;
		case R.id.btn_labelup2:
			viewPager.setCurrentItem(1);
			break;
		case R.id.btn_labelup3:
			viewPager.setCurrentItem(2);
			break;
		case R.id.btn_labelup4:
			viewPager.setCurrentItem(3);
			break;
		case R.id.btn_labelup5:
			viewPager.setCurrentItem(4);
			break;
		case R.id.btn_labelup6:
			viewPager.setCurrentItem(5);
			break;
		case R.id.btn_labelup7:
			viewPager.setCurrentItem(6);
			break;
		case R.id.btn_labelup8:
			viewPager.setCurrentItem(7);
			break;
		case R.id.btn_labelup9:
			viewPager.setCurrentItem(8);
			break;
		case R.id.btn_labelup10:
			viewPager.setCurrentItem(9);
			break;

		default:
			break;
		}
	}

	private void initfragment(int num) {
		// TODO Auto-generated method stub
		if (num == 1) {
			fragments.add(new MemberEducationOneFragment());
			lin_label1.setVisibility(View.VISIBLE);
		} else if (num == 2) {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
		} else if (num == 3) {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			fragments.add(new MemberEducationThreeFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
			lin_label3.setVisibility(View.VISIBLE);
		} else if (num == 4) {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			fragments.add(new MemberEducationThreeFragment());
			fragments.add(new MemberEducationFourFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
			lin_label3.setVisibility(View.VISIBLE);
			lin_label4.setVisibility(View.VISIBLE);
		} else if (num == 5) {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			fragments.add(new MemberEducationThreeFragment());
			fragments.add(new MemberEducationFourFragment());
			fragments.add(new MemberEducationFiveFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
			lin_label3.setVisibility(View.VISIBLE);
			lin_label4.setVisibility(View.VISIBLE);
			lin_label5.setVisibility(View.VISIBLE);
		} else if (num == 6) {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			fragments.add(new MemberEducationThreeFragment());
			fragments.add(new MemberEducationFourFragment());
			fragments.add(new MemberEducationFiveFragment());
			fragments.add(new MemberEducationSixFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
			lin_label3.setVisibility(View.VISIBLE);
			lin_label4.setVisibility(View.VISIBLE);
			lin_label5.setVisibility(View.VISIBLE);
			lin_label6.setVisibility(View.VISIBLE);
		} else if (num == 7) {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			fragments.add(new MemberEducationThreeFragment());
			fragments.add(new MemberEducationFourFragment());
			fragments.add(new MemberEducationFiveFragment());
			fragments.add(new MemberEducationSixFragment());
			fragments.add(new MemberEducationSevenFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
			lin_label3.setVisibility(View.VISIBLE);
			lin_label4.setVisibility(View.VISIBLE);
			lin_label5.setVisibility(View.VISIBLE);
			lin_label6.setVisibility(View.VISIBLE);
			lin_label7.setVisibility(View.VISIBLE);
		} else if (num == 8) {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			fragments.add(new MemberEducationThreeFragment());
			fragments.add(new MemberEducationFourFragment());
			fragments.add(new MemberEducationFiveFragment());
			fragments.add(new MemberEducationSixFragment());
			fragments.add(new MemberEducationSevenFragment());
			fragments.add(new MemberEducationEightFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
			lin_label3.setVisibility(View.VISIBLE);
			lin_label4.setVisibility(View.VISIBLE);
			lin_label5.setVisibility(View.VISIBLE);
			lin_label6.setVisibility(View.VISIBLE);
			lin_label7.setVisibility(View.VISIBLE);
			lin_label8.setVisibility(View.VISIBLE);
		} else if (num == 9) {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			fragments.add(new MemberEducationThreeFragment());
			fragments.add(new MemberEducationFourFragment());
			fragments.add(new MemberEducationFiveFragment());
			fragments.add(new MemberEducationSixFragment());
			fragments.add(new MemberEducationSevenFragment());
			fragments.add(new MemberEducationEightFragment());
			fragments.add(new MemberEducationNineFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
			lin_label3.setVisibility(View.VISIBLE);
			lin_label4.setVisibility(View.VISIBLE);
			lin_label5.setVisibility(View.VISIBLE);
			lin_label6.setVisibility(View.VISIBLE);
			lin_label7.setVisibility(View.VISIBLE);
			lin_label8.setVisibility(View.VISIBLE);
			lin_label9.setVisibility(View.VISIBLE);
		} else {
			fragments.add(new MemberEducationOneFragment());
			fragments.add(new MemberEducationTwoFragment());
			fragments.add(new MemberEducationThreeFragment());
			fragments.add(new MemberEducationFourFragment());
			fragments.add(new MemberEducationFiveFragment());
			fragments.add(new MemberEducationSixFragment());
			fragments.add(new MemberEducationSevenFragment());
			fragments.add(new MemberEducationEightFragment());
			fragments.add(new MemberEducationNineFragment());
			fragments.add(new MemberEducationTenFragment());
			lin_label1.setVisibility(View.VISIBLE);
			lin_label2.setVisibility(View.VISIBLE);
			lin_label3.setVisibility(View.VISIBLE);
			lin_label4.setVisibility(View.VISIBLE);
			lin_label5.setVisibility(View.VISIBLE);
			lin_label6.setVisibility(View.VISIBLE);
			lin_label7.setVisibility(View.VISIBLE);
			lin_label8.setVisibility(View.VISIBLE);
			lin_label9.setVisibility(View.VISIBLE);
			lin_label10.setVisibility(View.VISIBLE);
		}
		int labelwidth = screenwidth / num;
		if (num > 4) {
			labelwidth = screenwidth / 4;
		}
		temp = labelwidth;
		int btn_down_width = (int) (0.8 * labelwidth);
		LinearLayout.LayoutParams layout_lin_label1 = (android.widget.LinearLayout.LayoutParams) lin_label1
				.getLayoutParams();
		layout_lin_label1.width = labelwidth;
		lin_label1.setLayoutParams(layout_lin_label1);
		LinearLayout.LayoutParams layout_lin_label2 = (android.widget.LinearLayout.LayoutParams) lin_label2
				.getLayoutParams();
		layout_lin_label2.width = labelwidth;
		lin_label2.setLayoutParams(layout_lin_label2);
		LinearLayout.LayoutParams layout_lin_label3 = (android.widget.LinearLayout.LayoutParams) lin_label3
				.getLayoutParams();
		layout_lin_label3.width = labelwidth;
		lin_label3.setLayoutParams(layout_lin_label3);
		LinearLayout.LayoutParams layout_lin_label4 = (android.widget.LinearLayout.LayoutParams) lin_label4
				.getLayoutParams();
		layout_lin_label4.width = labelwidth;
		lin_label4.setLayoutParams(layout_lin_label4);
		LinearLayout.LayoutParams layout_lin_label5 = (android.widget.LinearLayout.LayoutParams) lin_label5
				.getLayoutParams();
		layout_lin_label5.width = labelwidth;
		lin_label5.setLayoutParams(layout_lin_label5);
		LinearLayout.LayoutParams layout_lin_label6 = (android.widget.LinearLayout.LayoutParams) lin_label6
				.getLayoutParams();
		layout_lin_label6.width = labelwidth;
		lin_label6.setLayoutParams(layout_lin_label6);
		LinearLayout.LayoutParams layout_lin_label7 = (android.widget.LinearLayout.LayoutParams) lin_label7
				.getLayoutParams();
		layout_lin_label7.width = labelwidth;
		lin_label7.setLayoutParams(layout_lin_label7);
		LinearLayout.LayoutParams layout_lin_label8 = (android.widget.LinearLayout.LayoutParams) lin_label8
				.getLayoutParams();
		layout_lin_label8.width = labelwidth;
		lin_label8.setLayoutParams(layout_lin_label8);
		LinearLayout.LayoutParams layout_lin_label9 = (android.widget.LinearLayout.LayoutParams) lin_label9
				.getLayoutParams();
		layout_lin_label9.width = labelwidth;
		lin_label9.setLayoutParams(layout_lin_label9);
		LinearLayout.LayoutParams layout_lin_label10 = (android.widget.LinearLayout.LayoutParams) lin_label10
				.getLayoutParams();
		layout_lin_label10.width = labelwidth;
		lin_label10.setLayoutParams(layout_lin_label10);
		LinearLayout.LayoutParams layout_btn_labelup1 = (android.widget.LinearLayout.LayoutParams) btn_labelup1
				.getLayoutParams();
		layout_btn_labelup1.width = labelwidth;
		btn_labelup1.setLayoutParams(layout_btn_labelup1);
		LinearLayout.LayoutParams layout_btn_labelup2 = (android.widget.LinearLayout.LayoutParams) btn_labelup2
				.getLayoutParams();
		layout_btn_labelup2.width = labelwidth;
		btn_labelup2.setLayoutParams(layout_btn_labelup2);
		LinearLayout.LayoutParams layout_btn_labelup3 = (android.widget.LinearLayout.LayoutParams) btn_labelup3
				.getLayoutParams();
		layout_btn_labelup3.width = labelwidth;
		btn_labelup3.setLayoutParams(layout_btn_labelup3);
		LinearLayout.LayoutParams layout_btn_labelup4 = (android.widget.LinearLayout.LayoutParams) btn_labelup4
				.getLayoutParams();
		layout_btn_labelup4.width = labelwidth;
		btn_labelup4.setLayoutParams(layout_btn_labelup4);
		LinearLayout.LayoutParams layout_btn_labelup5 = (android.widget.LinearLayout.LayoutParams) btn_labelup5
				.getLayoutParams();
		layout_btn_labelup5.width = labelwidth;
		btn_labelup5.setLayoutParams(layout_btn_labelup5);
		LinearLayout.LayoutParams layout_btn_labelup6 = (android.widget.LinearLayout.LayoutParams) btn_labelup6
				.getLayoutParams();
		layout_btn_labelup6.width = labelwidth;
		btn_labelup6.setLayoutParams(layout_btn_labelup6);
		LinearLayout.LayoutParams layout_btn_labelup7 = (android.widget.LinearLayout.LayoutParams) btn_labelup7
				.getLayoutParams();
		layout_btn_labelup7.width = labelwidth;
		btn_labelup7.setLayoutParams(layout_btn_labelup7);
		LinearLayout.LayoutParams layout_btn_labelup8 = (android.widget.LinearLayout.LayoutParams) btn_labelup8
				.getLayoutParams();
		layout_btn_labelup8.width = labelwidth;
		btn_labelup8.setLayoutParams(layout_btn_labelup8);
		LinearLayout.LayoutParams layout_btn_labelup9 = (android.widget.LinearLayout.LayoutParams) btn_labelup9
				.getLayoutParams();
		layout_btn_labelup9.width = labelwidth;
		btn_labelup9.setLayoutParams(layout_btn_labelup9);
		LinearLayout.LayoutParams layout_btn_labelup10 = (android.widget.LinearLayout.LayoutParams) btn_labelup10
				.getLayoutParams();
		layout_btn_labelup10.width = labelwidth;
		btn_labelup10.setLayoutParams(layout_btn_labelup10);
		LinearLayout.LayoutParams layout_btn_labeldown1 = (android.widget.LinearLayout.LayoutParams) btn_labeldown1
				.getLayoutParams();
		layout_btn_labeldown1.width = btn_down_width;
		btn_labeldown1.setLayoutParams(layout_btn_labeldown1);
		LinearLayout.LayoutParams layout_btn_labeldown2 = (android.widget.LinearLayout.LayoutParams) btn_labeldown2
				.getLayoutParams();
		layout_btn_labeldown2.width = btn_down_width;
		btn_labeldown2.setLayoutParams(layout_btn_labeldown2);
		LinearLayout.LayoutParams layout_btn_labeldown3 = (android.widget.LinearLayout.LayoutParams) btn_labeldown3
				.getLayoutParams();
		layout_btn_labeldown3.width = btn_down_width;
		btn_labeldown3.setLayoutParams(layout_btn_labeldown3);
		LinearLayout.LayoutParams layout_btn_labeldown4 = (android.widget.LinearLayout.LayoutParams) btn_labeldown4
				.getLayoutParams();
		layout_btn_labeldown4.width = btn_down_width;
		btn_labeldown4.setLayoutParams(layout_btn_labeldown4);
		LinearLayout.LayoutParams layout_btn_labeldown5 = (android.widget.LinearLayout.LayoutParams) btn_labeldown5
				.getLayoutParams();
		layout_btn_labeldown5.width = btn_down_width;
		btn_labeldown5.setLayoutParams(layout_btn_labeldown5);
		LinearLayout.LayoutParams layout_btn_labeldown6 = (android.widget.LinearLayout.LayoutParams) btn_labeldown6
				.getLayoutParams();
		layout_btn_labeldown6.width = btn_down_width;
		btn_labeldown6.setLayoutParams(layout_btn_labeldown6);
		LinearLayout.LayoutParams layout_btn_labeldown7 = (android.widget.LinearLayout.LayoutParams) btn_labeldown7
				.getLayoutParams();
		layout_btn_labeldown7.width = btn_down_width;
		btn_labeldown7.setLayoutParams(layout_btn_labeldown7);
		LinearLayout.LayoutParams layout_btn_labeldown8 = (android.widget.LinearLayout.LayoutParams) btn_labeldown8
				.getLayoutParams();
		layout_btn_labeldown8.width = btn_down_width;
		btn_labeldown8.setLayoutParams(layout_btn_labeldown8);
		LinearLayout.LayoutParams layout_btn_labeldown9 = (android.widget.LinearLayout.LayoutParams) btn_labeldown9
				.getLayoutParams();
		layout_btn_labeldown9.width = btn_down_width;
		btn_labeldown9.setLayoutParams(layout_btn_labeldown9);
		LinearLayout.LayoutParams layout_btn_labeldown10 = (android.widget.LinearLayout.LayoutParams) btn_labeldown10
				.getLayoutParams();
		layout_btn_labeldown10.width = btn_down_width;
		btn_labeldown10.setLayoutParams(layout_btn_labeldown10);

	}
}
