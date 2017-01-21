package wuxc.wisdomparty.ChildFragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeOfEmployee.AppeaeanceOfVipDetail;
import wuxc.wisdomparty.HomeOfEmployee.AppearanceVipActivity;
import wuxc.wisdomparty.MemberCenter.NoticeDatalistActivity;
import wuxc.wisdomparty.PartyManage.SpecialDetailActivity;
import wuxc.wisdomparty.PartyManage.SpecialProjectActivity;

public class EmployeeOrganizationFragment extends Fragment implements OnClickListener {

	private RelativeLayout RelaSpecial;
	private RelativeLayout RelaInform;
	private RelativeLayout RelaAppearance;
	private LinearLayout LinSpecialLeft;
	private LinearLayout LinSpecialRightTop;
	private LinearLayout LinSpecialRightBottom;
	private ImageView ImageAppearanceLeft;
	private ImageView ImageCenterTop;
	private ImageView ImageRightTop;
	private ImageView ImageCenterBottom;
	private ImageView ImageRightBottom;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.employee_organization, container, false);
		initview(view);
		setonclicklistener();
		return view;
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		RelaSpecial.setOnClickListener(this);
		RelaInform.setOnClickListener(this);
		RelaAppearance.setOnClickListener(this);
		LinSpecialLeft.setOnClickListener(this);
		LinSpecialRightTop.setOnClickListener(this);
		LinSpecialRightBottom.setOnClickListener(this);
		ImageAppearanceLeft.setOnClickListener(this);
		ImageCenterTop.setOnClickListener(this);
		ImageRightTop.setOnClickListener(this);
		ImageCenterBottom.setOnClickListener(this);
		ImageRightBottom.setOnClickListener(this);
	}

	private void initview(View view) {
		// TODO Auto-generated method stub

		RelaSpecial = (RelativeLayout) view.findViewById(R.id.rela_special);
		RelaInform = (RelativeLayout) view.findViewById(R.id.rela_inform);
		RelaAppearance = (RelativeLayout) view.findViewById(R.id.rela_appearance);
		LinSpecialLeft = (LinearLayout) view.findViewById(R.id.lin_special_left);
		LinSpecialRightTop = (LinearLayout) view.findViewById(R.id.lin_special_right_top);
		LinSpecialRightBottom = (LinearLayout) view.findViewById(R.id.lin_special_right_bottom);
		ImageAppearanceLeft = (ImageView) view.findViewById(R.id.image_appearance_left);
		ImageCenterTop = (ImageView) view.findViewById(R.id.image_center_top);
		ImageRightTop = (ImageView) view.findViewById(R.id.image_right_top);
		ImageCenterBottom = (ImageView) view.findViewById(R.id.image_center_bottom);
		ImageRightBottom = (ImageView) view.findViewById(R.id.image_right_bottom);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.rela_special:
			GoSpecialProject();
			break;
		case R.id.rela_inform:
			GoNotice();
			break;
		case R.id.rela_appearance:
			Govip();
			break;
		case R.id.lin_special_left:
			GoSpecialProjectDetail();
			break;
		case R.id.lin_special_right_top:
			GoSpecialProjectDetail();
			break;
		case R.id.lin_special_right_bottom:
			GoSpecialProjectDetail();
			break;
		case R.id.image_appearance_left:
			Govipappearance();
			break;
		case R.id.image_center_top:
			Govipappearance();
			break;
		case R.id.image_right_top:
			Govipappearance();
			break;
		case R.id.image_center_bottom:
			Govipappearance();
			break;
		case R.id.image_right_bottom:
			Govipappearance();
			break;

		default:
			break;
		}
	}

	private void GoSpecialProject() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), SpecialProjectActivity.class);
		startActivity(intent);
	}

	private void GoSpecialProjectDetail() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), SpecialDetailActivity.class);
		Bundle bundle = new Bundle();
		bundle.putString("Title", "测试1");
		bundle.putString("detail", "测试1");
		bundle.putString("Time", "测试1");
		bundle.putString("Name", "名字");
		intent.putExtras(bundle);
		startActivity(intent);
	}

	private void GoNotice() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), NoticeDatalistActivity.class);
		startActivity(intent);
	}

	private void Govip() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), AppearanceVipActivity.class);
		startActivity(intent);
	}

	private void Govipappearance() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), AppeaeanceOfVipDetail.class);
		Bundle bundle = new Bundle();
		bundle.putString("Title", "会员风采");
		bundle.putString("Time", "2016-11-23");
		bundle.putString("Name", "小李");
		bundle.putString("PageTitle", "会员风采");
		bundle.putString("Detail",
				"中国共产主义青年团，简称共青团，原名中国社会主义青年团，是中国共产党领导的一个由信仰共产主义的中国青年组成的群众性组织。共青团中央委员会受中共中央委员会领导，共青团的地方各级组织受同级党的委员会领导，同时受共青团上级组织领导。1922年5月，团的第一次代表大会在广州举行，正式成立中国社会主义青年团，1925年1月26日改称中国共产主义青年团。1959年5月4日共青团中央颁布共青团团徽。");
		intent.putExtras(bundle);
		startActivity(intent);
	}
}
