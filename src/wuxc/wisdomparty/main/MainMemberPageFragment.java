package wuxc.wisdomparty.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeActivity.HomeSearchActivity;
import wuxc.wisdomparty.HomeActivity.HomeSettingActivity;
import wuxc.wisdomparty.HomeOfMember.NoticeDatalistActivity;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyActivity;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyBranch;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyCheck;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyCollect;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyDue;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyEvaluate;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyFund;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyMark;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyPost;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyPublish;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyRelationship;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyResume;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyReward;
import wuxc.wisdomparty.MemberCenter.MemberCenterMySelect;
import wuxc.wisdomparty.MemberCenter.MemberCenterMyVote;
import wuxc.wisdomparty.layout.RoundedImageView;

public class MainMemberPageFragment extends MainBaseFragment implements OnClickListener {

	private LinearLayout LinTopBack;
	private RelativeLayout RelaHeadimg;
	private int screenwidth;
	private int ScreenHeight = 0;
	private LinearLayout LinButton;
	private RoundedImageView RoundedHeadimg;
	private ImageView ImageSearch;
	private ImageView ImageInform;
	private ImageView ImageSetting;
	private ImageView ImageHeadParty;
	private ImageView ImageVipRank;
	private ImageView ImagePartyMember;
	private TextView TextResume;
	private TextView TextName;
	private TextView TextPartyMember;
	private TextView TextMotto;
	private TextView TextMark;
	private TextView TextFund;
	private TextView TextEvaluate;
	private LinearLayout LinMark;
	private LinearLayout LinFund;
	private LinearLayout LinEvaluate;
	private LinearLayout LinMypublish;
	private LinearLayout LinMycollect;
	private LinearLayout LinMypost;
	private LinearLayout LinMyactivity;
	private LinearLayout LinMyselect;
	private LinearLayout LinMyvote;
	private RelativeLayout RelMybranch;
	private RelativeLayout RelMydue;
	private RelativeLayout RelMyrelationship;
	private RelativeLayout RelMyreward;
	private RelativeLayout RelMycheck;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mainmemberpage, container, false);
		initview(view);
		setonclicklistener();
		setlayoutheight();
		return view;
	}

	private void initview(View view) {
		// TODO Auto-generated method stub
		LinTopBack = (LinearLayout) view.findViewById(R.id.lin_top_back);
		LinButton = (LinearLayout) view.findViewById(R.id.lin_button);
		RelaHeadimg = (RelativeLayout) view.findViewById(R.id.rela_headimg);
		RoundedHeadimg = (RoundedImageView) view.findViewById(R.id.rounded_headimg);
		ImageSearch = (ImageView) view.findViewById(R.id.image_search);
		ImageInform = (ImageView) view.findViewById(R.id.image_inform);
		ImageSetting = (ImageView) view.findViewById(R.id.image_setting);
		ImageHeadParty = (ImageView) view.findViewById(R.id.image_head_party);
		ImageVipRank = (ImageView) view.findViewById(R.id.image_vip_rank);
		ImagePartyMember = (ImageView) view.findViewById(R.id.image_party_member);
		TextResume = (TextView) view.findViewById(R.id.text_resume);
		TextName = (TextView) view.findViewById(R.id.text_name);
		TextPartyMember = (TextView) view.findViewById(R.id.text_party_member);
		TextMotto = (TextView) view.findViewById(R.id.text_motto);
		TextMark = (TextView) view.findViewById(R.id.text_mark);
		TextFund = (TextView) view.findViewById(R.id.text_fund);
		TextEvaluate = (TextView) view.findViewById(R.id.text_evaluate);
		LinMark = (LinearLayout) view.findViewById(R.id.lin_mark);
		LinFund = (LinearLayout) view.findViewById(R.id.lin_fund);
		LinEvaluate = (LinearLayout) view.findViewById(R.id.lin_evaluate);
		LinMypublish = (LinearLayout) view.findViewById(R.id.lin_mypublish);
		LinMycollect = (LinearLayout) view.findViewById(R.id.lin_mycollect);
		LinMypost = (LinearLayout) view.findViewById(R.id.lin_mypost);
		LinMyactivity = (LinearLayout) view.findViewById(R.id.lin_myactivity);
		LinMyselect = (LinearLayout) view.findViewById(R.id.lin_myselect);
		LinMyvote = (LinearLayout) view.findViewById(R.id.lin_myvote);
		RelMybranch = (RelativeLayout) view.findViewById(R.id.rel_mybranch);
		RelMydue = (RelativeLayout) view.findViewById(R.id.rel_mydue);
		RelMyrelationship = (RelativeLayout) view.findViewById(R.id.rel_myrelationship);
		RelMyreward = (RelativeLayout) view.findViewById(R.id.rel_myreward);
		RelMycheck = (RelativeLayout) view.findViewById(R.id.rel_mycheck);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		RoundedHeadimg.setOnClickListener(this);
		ImageSearch.setOnClickListener(this);
		ImageInform.setOnClickListener(this);
		ImageSetting.setOnClickListener(this);
		ImageHeadParty.setOnClickListener(this);
		ImageVipRank.setOnClickListener(this);
		ImagePartyMember.setOnClickListener(this);
		TextResume.setOnClickListener(this);
		TextName.setOnClickListener(this);
		TextPartyMember.setOnClickListener(this);
		TextMotto.setOnClickListener(this);
		TextMark.setOnClickListener(this);
		TextFund.setOnClickListener(this);
		TextEvaluate.setOnClickListener(this);
		LinMark.setOnClickListener(this);
		LinFund.setOnClickListener(this);
		LinEvaluate.setOnClickListener(this);
		LinMypublish.setOnClickListener(this);
		LinMycollect.setOnClickListener(this);
		LinMypost.setOnClickListener(this);
		LinMyactivity.setOnClickListener(this);
		LinMyselect.setOnClickListener(this);
		LinMyvote.setOnClickListener(this);
		RelMybranch.setOnClickListener(this);
		RelMydue.setOnClickListener(this);
		RelMyrelationship.setOnClickListener(this);
		RelMyreward.setOnClickListener(this);
		RelMycheck.setOnClickListener(this);

	}

	private void setlayoutheight() {
		// TODO Auto-generated method stub
		screenwidth = getActivity().getWindow().getWindowManager().getDefaultDisplay().getWidth();
		ScreenHeight = (int) (screenwidth / 1.8);
		LinearLayout.LayoutParams LayoutParams = (android.widget.LinearLayout.LayoutParams) LinTopBack
				.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		LinTopBack.setLayoutParams(LayoutParams);
		LayoutParams = (android.widget.LinearLayout.LayoutParams) RelaHeadimg.getLayoutParams();
		LayoutParams.width = 16 * ScreenHeight / 33;
		RelaHeadimg.setLayoutParams(LayoutParams);
		LayoutParams = (android.widget.LinearLayout.LayoutParams) LinButton.getLayoutParams();
		LayoutParams.height = (int) (screenwidth / 2.45);
		LinButton.setLayoutParams(LayoutParams);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		MainActivity.curFragmentTag = getString(R.string.str_member);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_search:
			Intent intent_image_search = new Intent();
			intent_image_search.setClass(getActivity(), HomeSearchActivity.class);
			startActivity(intent_image_search);
			break;
		case R.id.image_inform:
			Intent intent_image_inform = new Intent();
			intent_image_inform.setClass(getActivity(), NoticeDatalistActivity.class);
			startActivity(intent_image_inform);
			break;
		case R.id.image_setting:
			Intent intent_image_setting = new Intent();
			intent_image_setting.setClass(getActivity(), HomeSettingActivity.class);
			startActivity(intent_image_setting);
			break;
		case R.id.text_resume:
			Intent intent_text_resume = new Intent();
			intent_text_resume.setClass(getActivity(), MemberCenterMyResume.class);
			startActivity(intent_text_resume);
			break;
		case R.id.lin_mark:
			Intent intent_lin_mark = new Intent();
			intent_lin_mark.setClass(getActivity(), MemberCenterMyMark.class);
			startActivity(intent_lin_mark);
			break;
		case R.id.lin_fund:
			Intent intent_lin_fund = new Intent();
			intent_lin_fund.setClass(getActivity(), MemberCenterMyFund.class);
			Bundle bundle = new Bundle();
			bundle.putString("fund", "12");
			intent_lin_fund.putExtras(bundle);
			startActivity(intent_lin_fund);
			break;
		case R.id.lin_evaluate:
			Intent intent_lin_evaluate = new Intent();
			intent_lin_evaluate.setClass(getActivity(), MemberCenterMyEvaluate.class);
			startActivity(intent_lin_evaluate);
			break;
		case R.id.lin_mypublish:
			Intent intent_lin_mypublish = new Intent();
			intent_lin_mypublish.setClass(getActivity(), MemberCenterMyPublish.class);
			startActivity(intent_lin_mypublish);
			break;
		case R.id.lin_mycollect:
			Intent intent_lin_mycollect = new Intent();
			intent_lin_mycollect.setClass(getActivity(), MemberCenterMyCollect.class);
			startActivity(intent_lin_mycollect);
			break;
		case R.id.lin_mypost:
			Intent intent_lin_mypost = new Intent();
			intent_lin_mypost.setClass(getActivity(), MemberCenterMyPost.class);
			startActivity(intent_lin_mypost);
			break;
		case R.id.lin_myactivity:
			Intent intent_lin_myactivity = new Intent();
			intent_lin_myactivity.setClass(getActivity(), MemberCenterMyActivity.class);
			startActivity(intent_lin_myactivity);
			break;
		case R.id.lin_myselect:
			Intent intent_lin_myselect = new Intent();
			intent_lin_myselect.setClass(getActivity(), MemberCenterMySelect.class);
			startActivity(intent_lin_myselect);
			break;
		case R.id.lin_myvote:
			Intent intent_lin_myvote = new Intent();
			intent_lin_myvote.setClass(getActivity(), MemberCenterMyVote.class);
			startActivity(intent_lin_myvote);
			break;
		case R.id.rel_mybranch:
			Intent intent_rel_mybranch = new Intent();
			intent_rel_mybranch.setClass(getActivity(), MemberCenterMyBranch.class);
			startActivity(intent_rel_mybranch);
			break;
		case R.id.rel_mydue:
			Intent intent_rel_mydue = new Intent();
			intent_rel_mydue.setClass(getActivity(), MemberCenterMyDue.class);
			startActivity(intent_rel_mydue);
			break;
		case R.id.rel_myrelationship:
			Intent intent_rel_myrelationship = new Intent();
			intent_rel_myrelationship.setClass(getActivity(), MemberCenterMyRelationship.class);
			startActivity(intent_rel_myrelationship);
			break;
		case R.id.rel_myreward:
			Intent intent_rel_myreward = new Intent();
			intent_rel_myreward.setClass(getActivity(), MemberCenterMyReward.class);
			startActivity(intent_rel_myreward);
			break;
		case R.id.rel_mycheck:
			Intent intent_rel_mycheck = new Intent();
			intent_rel_mycheck.setClass(getActivity(), MemberCenterMyCheck.class);
			startActivity(intent_rel_mycheck);
			break;

		default:
			break;
		}
	}
}
