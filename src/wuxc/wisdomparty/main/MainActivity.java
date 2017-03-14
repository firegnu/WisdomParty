package wuxc.wisdomparty.main;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.umeng.socialize.utils.Log;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Internet.HttpGetData;
import wuxc.wisdomparty.Internet.URLcontainer;

public class MainActivity extends FragmentActivity implements OnClickListener {
	public static String curFragmentTag;
	public MainHomePageFragment HomePageFragment;
	public MainPublicPageFragment PublicFragment;
	public MainPartyPageFragment PartyFragment;
	public MainMemberPageFragment MemberFragment;

	private View RelativeHomePage, RelativePublic, RelativeParty, RelativeMember;
	private ImageView ImageHomePage, ImagePublic, ImageParty, ImageMember;
	private TextView TextRecommned, TextPublic, TextParty, TextMember;
	private FragmentManager mFragmentManager;
	private FragmentTransaction mFragmentTransaction;
	private int page = 0;
	private SharedPreferences FragmentPage;
	public static Activity activity;
 
	 
 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainactivity);
		activity = this;
		initViews();
		read();
		mFragmentManager = getSupportFragmentManager();
		if (page == 1) {
			setTabSelection(getString(R.string.str_homepage));
		} else if (page == 2) {
			setTabSelection(getString(R.string.str_public));
		} else if (page == 3) {
			setTabSelection(getString(R.string.str_party));
		} else if (page == 4) {
			setTabSelection(getString(R.string.str_member));
		} else if (page == 0) {
			setCurrentFragment();
		}
		
	}

	


	

	private void initViews() {
		// TODO Auto-generated method stub

		FragmentPage = getSharedPreferences("fragmentinfo", MODE_PRIVATE);

		RelativeHomePage = findViewById(R.id.relative_recommned);
		RelativePublic = findViewById(R.id.relative_public);
		RelativeParty = findViewById(R.id.relative_party);
		RelativeMember = findViewById(R.id.relative_member);

		ImageHomePage = (ImageView) findViewById(R.id.image_homepage);
		ImagePublic = (ImageView) findViewById(R.id.image_public);
		ImageParty = (ImageView) findViewById(R.id.image_party);
		ImageMember = (ImageView) findViewById(R.id.image_member);

		TextRecommned = (TextView) findViewById(R.id.text_homepage);
		TextPublic = (TextView) findViewById(R.id.text_public);
		TextParty = (TextView) findViewById(R.id.text_party);
		TextMember = (TextView) findViewById(R.id.text_member);

		RelativeHomePage.setOnClickListener(this);
		RelativePublic.setOnClickListener(this);
		RelativeParty.setOnClickListener(this);
		RelativeMember.setOnClickListener(this);

	}

	private void setCurrentFragment() {
		clearSelection();
		mFragmentTransaction = mFragmentManager.beginTransaction();
		ImageHomePage.setImageResource(R.drawable.homepage_selected);
		TextRecommned.setTextColor(Color.rgb(0, 167, 255));
		write(1);
		if (HomePageFragment == null) {
			HomePageFragment = new MainHomePageFragment();
			mFragmentTransaction.add(R.id.content, HomePageFragment, getString(R.string.str_homepage));
			commitTransactions();
		}
		curFragmentTag = getString(R.string.str_homepage);
	}

	private void read() {
		// TODO Auto-generated method stub
		page = FragmentPage.getInt("fragment", 0);
	}

	private void write(int i) {
		// TODO Auto-generated method stub
		Editor edit = FragmentPage.edit();
		edit.putInt("fragment", i);
		edit.commit();
	}

	public void setTabSelection(String tag) {

		clearSelection();
		mFragmentTransaction = mFragmentManager.beginTransaction();
		if (TextUtils.equals(tag, getString(R.string.str_homepage))) {
			ImageHomePage.setImageResource(R.drawable.homepage_selected);
			TextRecommned.setTextColor(Color.rgb(0, 167, 255));

			if (HomePageFragment == null) {
				HomePageFragment = new MainHomePageFragment();
			}

		} else if (TextUtils.equals(tag, getString(R.string.str_public))) {
			ImagePublic.setImageResource(R.drawable.public_selected);
			TextPublic.setTextColor(Color.rgb(0, 167, 255));
			if (PublicFragment == null) {
				PublicFragment = new MainPublicPageFragment();
			}

		} else if (TextUtils.equals(tag, getString(R.string.str_party))) {
			ImageParty.setImageResource(R.drawable.party_selected);
			TextParty.setTextColor(Color.rgb(0, 167, 255));
			if (PartyFragment == null) {
				PartyFragment = new MainPartyPageFragment();
			}

		} else if (TextUtils.equals(tag, getString(R.string.str_member))) {
			ImageMember.setImageResource(R.drawable.member_selected);
			TextMember.setTextColor(Color.rgb(0, 167, 255));
			if (MemberFragment == null) {
				MemberFragment = new MainMemberPageFragment();
			}
		}
		switchFragment(tag);

	}

	public void switchFragment(String tag) {
		if (TextUtils.equals(tag, curFragmentTag)) {
			return;
		}

		if (curFragmentTag != null) {
			detachFragment(getFragment(curFragmentTag));

		}
		attachFragment(R.id.content, getFragment(tag), tag);
		curFragmentTag = tag;
		commitTransactions();
	}

	private void detachFragment(Fragment f) {

		if (f != null && !f.isDetached()) {
			ensureTransaction();
			mFragmentTransaction.detach(f);
		}
	}

	private FragmentTransaction ensureTransaction() {
		if (mFragmentTransaction == null) {
			mFragmentTransaction = mFragmentManager.beginTransaction();
			mFragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

		}
		return mFragmentTransaction;

	}

	private void attachFragment(int layout, Fragment f, String tag) {
		if (f != null) {
			if (f.isDetached()) {
				ensureTransaction();
				mFragmentTransaction.attach(f);

			} else if (!f.isAdded()) {
				ensureTransaction();
				mFragmentTransaction.add(layout, f, tag);
			}
		}
	}

	private void clearSelection() {
		ImageHomePage.setImageResource(R.drawable.homepage_normal);
		TextRecommned.setTextColor(Color.parseColor("#82858b"));
		ImagePublic.setImageResource(R.drawable.public_normal);
		TextPublic.setTextColor(Color.parseColor("#82858b"));
		ImageParty.setImageResource(R.drawable.party_normal);
		TextParty.setTextColor(Color.parseColor("#82858b"));
		ImageMember.setImageResource(R.drawable.member_normal);
		TextMember.setTextColor(Color.parseColor("#82858b"));

	}

	private void commitTransactions() {
		if (mFragmentTransaction != null && !mFragmentTransaction.isEmpty()) {
			mFragmentTransaction.commit();
			mFragmentTransaction = null;
		}
	}

	private Fragment getFragment(String tag) {

		Fragment f = mFragmentManager.findFragmentByTag(tag);

		if (f == null) {
			f = MainBaseFragment.newInstance(getApplicationContext(), tag);
		}
		return f;

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		write(0);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.relative_recommned:
			write(1);
			setTabSelection(getString(R.string.str_homepage));
			break;
		case R.id.relative_public:
			write(2);
			setTabSelection(getString(R.string.str_public));
			break;
		case R.id.relative_party:
			write(3);
			setTabSelection(getString(R.string.str_party));
			break;
		case R.id.relative_member:
			write(4);
			setTabSelection(getString(R.string.str_member));
			break;

		default:
			break;
		}
	}

}
