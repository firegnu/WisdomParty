package wuxc.wisdomparty.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeActivity.HomeSearchActivity;
import wuxc.wisdomparty.PartyManage.AssistanceToPauperActivity;
import wuxc.wisdomparty.PartyManage.ChangeTermsActivity;
import wuxc.wisdomparty.PartyManage.CreationAndFightingActivity;
import wuxc.wisdomparty.PartyManage.DemocraticCommentActivity;
import wuxc.wisdomparty.PartyManage.InterPartyOnlineActivity;
import wuxc.wisdomparty.PartyManage.MemberEducationActivity;
import wuxc.wisdomparty.PartyManage.MemberManageActivity;
import wuxc.wisdomparty.PartyManage.MemberRewardsActivity;
import wuxc.wisdomparty.PartyManage.OrganizationLifeActivity;
import wuxc.wisdomparty.PartyManage.SpecialProjectActivity;

public class MainPartyPageFragment extends MainBaseFragment implements OnClickListener {
	private LinearLayout LinBtnZone;
	private int screenwidth = 0;
	private LinearLayout LinAssistancePauper;
	private LinearLayout LinChangeTerm;
	private LinearLayout LinSpecialProject;
	private LinearLayout LinCreationFighting;
	private LinearLayout LinMemberRewards;
	private LinearLayout LinDemocraticComment;
	private LinearLayout LinMemberEducation;
	private LinearLayout LinMemberManage;
	private LinearLayout LinOranizationLife;
	private LinearLayout LinInterPartyOnline;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mainpartypage, container, false);
		initview(view);
		setonclicklistener();
		setheight();
		return view;
	}

	private void setheight() {
		// TODO Auto-generated method stub
		screenwidth = getActivity().getWindow().getWindowManager().getDefaultDisplay().getWidth();
		int height = (int) 23 * screenwidth / 25;
		LinearLayout.LayoutParams layoutParams1 = (android.widget.LinearLayout.LayoutParams) LinBtnZone
				.getLayoutParams();
		layoutParams1.height = height;
		LinBtnZone.setLayoutParams(layoutParams1);
	}

	private void initview(View view) {
		// TODO Auto-generated method stub
		LinBtnZone = (LinearLayout) view.findViewById(R.id.lin_btn_zone);
		LinAssistancePauper = (LinearLayout) view.findViewById(R.id.lin_assistance_pauper);
		LinChangeTerm = (LinearLayout) view.findViewById(R.id.lin_change_term);
		LinSpecialProject = (LinearLayout) view.findViewById(R.id.lin_special_project);
		LinCreationFighting = (LinearLayout) view.findViewById(R.id.lin_creation_fighting);
		LinMemberRewards = (LinearLayout) view.findViewById(R.id.lin_member_rewards);
		LinDemocraticComment = (LinearLayout) view.findViewById(R.id.lin_democratic_comment);
		LinMemberEducation = (LinearLayout) view.findViewById(R.id.lin_member_education);
		LinMemberManage = (LinearLayout) view.findViewById(R.id.lin_member_manage);
		LinOranizationLife = (LinearLayout) view.findViewById(R.id.lin_organization_life);
		LinInterPartyOnline = (LinearLayout) view.findViewById(R.id.lin_inter_party_online);

	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		LinAssistancePauper.setOnClickListener(this);
		LinChangeTerm.setOnClickListener(this);
		LinSpecialProject.setOnClickListener(this);
		LinCreationFighting.setOnClickListener(this);
		LinMemberRewards.setOnClickListener(this);
		LinDemocraticComment.setOnClickListener(this);
		LinMemberEducation.setOnClickListener(this);
		LinMemberManage.setOnClickListener(this);
		LinOranizationLife.setOnClickListener(this);
		LinInterPartyOnline.setOnClickListener(this);

	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		MainActivity.curFragmentTag = getString(R.string.str_party);

	}

	@Override
	public void onClick(View v) {

		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.lin_assistance_pauper:
			Intent intent1 = new Intent();
			intent1.setClass(getActivity(), AssistanceToPauperActivity.class);
			startActivity(intent1);
			break;
		case R.id.lin_change_term:
			Intent intent2 = new Intent();
			intent2.setClass(getActivity(), ChangeTermsActivity.class);
			startActivity(intent2);
			break;
		case R.id.lin_special_project:
			Intent intent3 = new Intent();
			intent3.setClass(getActivity(), SpecialProjectActivity.class);
			startActivity(intent3);
			break;
		case R.id.lin_creation_fighting:
			Intent intent4 = new Intent();
			intent4.setClass(getActivity(), CreationAndFightingActivity.class);
			startActivity(intent4);
			break;
		case R.id.lin_member_rewards:
			Intent intent5 = new Intent();
			intent5.setClass(getActivity(), MemberRewardsActivity.class);
			startActivity(intent5);
			break;
		case R.id.lin_democratic_comment:
			Intent intent6 = new Intent();
			intent6.setClass(getActivity(), DemocraticCommentActivity.class);
			startActivity(intent6);
			break;
		case R.id.lin_member_education:
			Intent intent7 = new Intent();
			intent7.setClass(getActivity(), MemberEducationActivity.class);
			startActivity(intent7);
			break;
		case R.id.lin_member_manage:
			Intent intent8 = new Intent();
			intent8.setClass(getActivity(), MemberManageActivity.class);
			startActivity(intent8);
			break;
		case R.id.lin_organization_life:
			Intent intent9 = new Intent();
			intent9.setClass(getActivity(), OrganizationLifeActivity.class);
			startActivity(intent9);
			break;
		case R.id.lin_inter_party_online:
			Intent intent10 = new Intent();
			intent10.setClass(getActivity(), InterPartyOnlineActivity.class);
			startActivity(intent10);
			break;

		default:
			break;
		}
	}
}
