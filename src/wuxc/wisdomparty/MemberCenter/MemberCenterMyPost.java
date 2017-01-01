package wuxc.wisdomparty.MemberCenter;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.Window;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.ChildFragment.MyPostFragment;
import wuxc.wisdomparty.ChildFragment.MyPunishFragment;
import wuxc.wisdomparty.ChildFragment.MyReturnFragment;
import wuxc.wisdomparty.ChildFragment.MyRewardFragment;
import wuxc.wisdomparty.layout.Childviewpaper;

public class MemberCenterMyPost extends FragmentActivity implements OnClickListener {
	private Childviewpaper ViewPaper;
	public List<Fragment> Fragments = new ArrayList<Fragment>();
	private FragmentManager FragmentManager;
	private int NumberPicture = 2;
	private LinearLayout lin_top;
	private TextView text_reward;
	private TextView text_punish;
	private ImageView ImageBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_mypost);
		ViewPaper = (Childviewpaper) findViewById(R.id.viewPager);
		lin_top = (LinearLayout) findViewById(R.id.lin_top);
		text_reward = (TextView) findViewById(R.id.text_reward);
		text_punish = (TextView) findViewById(R.id.text_punish);
		Fragments.clear();// Çå¿Õlist
		initfragment();// list ×°Ìîfragment
		FragmentManager = getSupportFragmentManager();
		ViewPaper.setOffscreenPageLimit(NumberPicture);
		ViewPaper.setOnPageChangeListener(new MyOnPageChangeListener());
		ViewPaper.setAdapter(new MyPagerAdapter());
		lin_top.setOnClickListener(this);
		text_reward.setOnClickListener(this);
		text_punish.setOnClickListener(this);
		lin_top.setBackgroundResource(R.drawable.myreward_left);
		text_reward.setTextColor(Color.WHITE);
		text_punish.setTextColor(Color.BLACK);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageBack.setOnClickListener(this);
	}

	private void initfragment() {
		// TODO Auto-generated method stub
		Fragments.add(new MyPostFragment());
		Fragments.add(new MyReturnFragment());
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
			if (arg0 == 0) {
				lin_top.setBackgroundResource(R.drawable.myreward_left);
				text_reward.setTextColor(Color.WHITE);
				text_punish.setTextColor(Color.BLACK);
			} else {
				lin_top.setBackgroundResource(R.drawable.myreward_right);
				text_reward.setTextColor(Color.BLACK);
				text_punish.setTextColor(Color.WHITE);
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
		case R.id.text_reward:
			ViewPaper.setCurrentItem(0);
			lin_top.setBackgroundResource(R.drawable.myreward_left);
			text_reward.setTextColor(Color.WHITE);
			text_punish.setTextColor(Color.BLACK);
			break;
		case R.id.text_punish:
			ViewPaper.setCurrentItem(1);
			lin_top.setBackgroundResource(R.drawable.myreward_right);
			text_reward.setTextColor(Color.BLACK);
			text_punish.setTextColor(Color.WHITE);
			break;
		case R.id.image_back:
			finish();
			break;
		default:
			break;
		}
	}

}
