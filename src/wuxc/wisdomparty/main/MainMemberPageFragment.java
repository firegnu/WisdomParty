package wuxc.wisdomparty.main;

import java.util.ArrayList;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.umeng.socialize.utils.Log;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.HomeActivity.HomeSearchActivity;
import wuxc.wisdomparty.HomeActivity.HomeSettingActivity;
import wuxc.wisdomparty.Internet.GetBitmapFromServer;
import wuxc.wisdomparty.Internet.HttpGetData;
import wuxc.wisdomparty.Internet.URLcontainer;
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
import wuxc.wisdomparty.MemberCenter.NoticeDatalistActivity;
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
	private TextView TextVipRank;
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
	private SharedPreferences PreUserInfo;// 存储个人信息
	private String LoginId;
	private String ticket;
	private final static String IS_PARTY_MEMBER = "党员";
	private final static String VIP_RANK_1 = "一级";
	private final static String VIP_RANK_2 = "二级";
	private final static String VIP_RANK_3 = "三级";
	private final static String VIP_RANK_4 = "四级";
	private final static String VIP_RANK_5 = "五级";
	private final static int GET_USER_HEAD_IMAGE = 6;
	private final static int READY_USERINFO = 4;
	private final static int READY_MEMBERDATA = 5;
	private static final String GET_SUCCESS_RESULT = "success";
	private static final int GET_USERINFO_RESULT_DATA = 1;
	private static final int GET_MEMBERDATA_RESULT_DATA = 2;
	private String userPhoto;
	private String userName;
	private String address;
	private String sex;
	private String loginId;
	private String memberLevel;
	private String memberLevelDesc;
	private String permisons;
	private String personBg;
	private String userClassify;
	private String sign;
	private String hobby;
	private String balance;
	private String cashBalance;
	private String realName;
	private String cityCode;
	private String mobile;
	private String alipayAccount;
	private String alipayRealname;
	private String renzhengName;
	private String renzheng;
	private String sixin;
	private String guanzhu;
	private String fensi;
	private String shoucang;
	private String isGuanZhu;
	private String readNum;
	private String unReadNum;
	private String totalNum;
	private String credits;
	private String scoreInNum;
	private String scoreOutNum;
	private String scoreCurNum;
	private String scoreTotalNum;
	private final static int GO_CHANGE_HEADIMG = 8;
	private final static int GO_CHANGE_MARK = 10;
	public Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_USER_HEAD_IMAGE:
				ShowHeadImage(msg.obj);
				break;
			case READY_USERINFO:
				ReadUserInfo();
				ShowUserInfo();
				GetHeadPic();
				break;
			case READY_MEMBERDATA:
				ReadMemberData();
				ShowMemberData();
				break;
			case GET_USERINFO_RESULT_DATA:
				GetDataDetailFromUserInfoResultData(msg.obj);
				break;
			case GET_MEMBERDATA_RESULT_DATA:
				GetDataDetailFromMemberDataResultData(msg.obj);
				break;
			default:
				break;
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.mainmemberpage, container, false);
		initview(view);
		setonclicklistener();
		setlayoutheight();
		ReadTicket();
		GetUserInfo();
		GetMemberData();
		return view;
	}

	private void ShowMemberData() {
		// TODO Auto-generated method stub
		TextMark.setText(credits);
		TextEvaluate.setText(totalNum);
	}

	private void ReadMemberData() {
		// TODO Auto-generated method stub
		totalNum = PreUserInfo.getString("totalNum", null);
		credits = PreUserInfo.getString("credits", null);
	}

	protected void ShowHeadImage(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj == null)) {
			try {
				Bitmap HeadImage = (Bitmap) obj;
				RoundedHeadimg.setImageBitmap(HeadImage);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void ReadTicket() {
		// TODO Auto-generated method stub
		LoginId = PreUserInfo.getString("loginId", null);
		ticket = PreUserInfo.getString("ticket", null);
	}

	private void GetHeadPic() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				Bitmap HeadImage = null;
				HeadImage = GetBitmapFromServer
						.getBitmapFromServer(URLcontainer.urlip + URLcontainer.GetFile + userPhoto);
				Message msg = new Message();
				msg.what = GET_USER_HEAD_IMAGE;
				msg.obj = HeadImage;
				uiHandler.sendMessage(msg);
			}
		}).start();
	}

	private void ShowUserInfo() {
		// TODO Auto-generated method stub
		try {
			if (memberLevelDesc.equals(IS_PARTY_MEMBER)) {
				ImageHeadParty.setVisibility(View.VISIBLE);
			} else {
				ImageHeadParty.setVisibility(View.GONE);
			}
			TextPartyMember.setText(memberLevelDesc);
			TextName.setText(userName);
			if (memberLevel.equals("1")) {
				TextVipRank.setText(VIP_RANK_1);
				ImageVipRank.setImageResource(R.drawable.vip1);
			} else if (memberLevel.equals("2")) {
				TextVipRank.setText(VIP_RANK_2);
				ImageVipRank.setImageResource(R.drawable.vip2);
			} else if (memberLevel.equals("3")) {
				TextVipRank.setText(VIP_RANK_3);
				ImageVipRank.setImageResource(R.drawable.vip3);
			} else if (memberLevel.equals("4")) {
				TextVipRank.setText(VIP_RANK_4);
				ImageVipRank.setImageResource(R.drawable.vip4);
			} else {
				TextVipRank.setText(VIP_RANK_5);
				ImageVipRank.setImageResource(R.drawable.vip5);
			}
			TextMotto.setText(sign);

			TextFund.setText(balance);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void ReadUserInfo() {
		// TODO Auto-generated method stub
		ticket = PreUserInfo.getString("ticket", null);
		userPhoto = PreUserInfo.getString("userPhoto", null);
		userName = PreUserInfo.getString("userName", null);

		memberLevel = PreUserInfo.getString("memberLevel", null);
		memberLevelDesc = PreUserInfo.getString("memberLevelDesc", null);
		balance = PreUserInfo.getString("balance", null);

		sign = PreUserInfo.getString("sign", null);
		Log.e("PreUserInfo", balance);
	}

	private void initview(View view) {
		// TODO Auto-generated method stub
		PreUserInfo = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
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
		TextVipRank = (TextView) view.findViewById(R.id.text_vip_rank);
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

	private void GetMemberData() {
		// TODO Auto-generated method stub
		final ArrayList ArrayValues = new ArrayList();
		ArrayValues.add(new BasicNameValuePair("ticket", ticket));
		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				String LoginResultData = "";
				LoginResultData = HttpGetData.GetData(URLcontainer.GetMemberData, ArrayValues);
				Message msg = new Message();
				msg.obj = LoginResultData;
				msg.what = GET_MEMBERDATA_RESULT_DATA;
				uiHandler.sendMessage(msg);
			}
		}).start();
	}

	private void GetUserInfo() {
		// TODO Auto-generated method stub
		final ArrayList ArrayValues = new ArrayList();
		ArrayValues.add(new BasicNameValuePair("ticket", ticket));
		ArrayValues.add(new BasicNameValuePair("queryUserId", LoginId));
		new Thread(new Runnable() { // 开启线程上传文件
			@Override
			public void run() {
				String LoginResultData = "";
				LoginResultData = HttpGetData.GetData(URLcontainer.GetUserInfo, ArrayValues);
				Message msg = new Message();
				msg.obj = LoginResultData;
				msg.what = GET_USERINFO_RESULT_DATA;
				uiHandler.sendMessage(msg);
			}
		}).start();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		MainActivity.curFragmentTag = getString(R.string.str_member);

	}

	protected void GetDataDetailFromMemberDataResultData(Object obj) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String Type = null;
		String Data = null;
		try {
			JSONObject demoJson = new JSONObject(obj.toString());
			Type = demoJson.getString("type");
			Data = demoJson.getString("data");
			if (Type.equals(GET_SUCCESS_RESULT)) {
				GetMemberDataDetailData(Data);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void GetMemberDataDetailData(String data) {
		// TODO Auto-generated method stub
		try {
			JSONObject demoJson = new JSONObject(data);

			readNum = demoJson.getString("readNum");
			unReadNum = demoJson.getString("unReadNum");
			totalNum = demoJson.getString("totalNum");
			balance = demoJson.getString("balance");
			cashBalance = demoJson.getString("cashBalance");
			credits = demoJson.getString("credits");
			memberLevel = demoJson.getString("memberLevel");
			memberLevelDesc = demoJson.getString("memberLevelDesc");
			scoreInNum = demoJson.getString("scoreInNum");
			scoreOutNum = demoJson.getString("scoreOutNum");
			scoreCurNum = demoJson.getString("scoreCurNum");
			scoreTotalNum = demoJson.getString("scoreTotalNum");

			WriteMemberData();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data == null)
			return;
		Bundle bundle = data.getExtras();
		switch (requestCode) {
		case GO_CHANGE_HEADIMG:
			if (!(data == null)) {
				boolean Result = bundle.getBoolean("UploadImage", false);
				if (Result) {
					ReadUserInfo();
					GetHeadPic();
				}
			}
		case GO_CHANGE_MARK:
			if (!(data == null)) {
				boolean Result = bundle.getBoolean("UploadMark", false);
				if (Result) {
					ReadMemberData();
					ShowMemberData();
				}
			}
			break;

		default:
			break;

		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void WriteMemberData() {
		// TODO Auto-generated method stub
		Editor edit = PreUserInfo.edit();
		edit.putString("readNum", readNum);
		edit.putString("unReadNum", unReadNum);
		edit.putString("totalNum", totalNum);
		edit.putString("balance", balance);
		edit.putString("cashBalance", cashBalance);
		edit.putString("credits", credits);
		edit.putString("memberLevel", memberLevel);
		edit.putString("memberLevelDesc", memberLevelDesc);
		edit.putString("scoreInNum", scoreInNum);
		edit.putString("scoreOutNum", scoreOutNum);
		edit.putString("scoreCurNum", scoreCurNum);
		edit.putString("scoreTotalNum", scoreTotalNum);

		edit.commit();
		Message msg = new Message();
		msg.what = READY_MEMBERDATA;
		uiHandler.sendMessage(msg);
	}

	protected void GetDataDetailFromUserInfoResultData(Object obj) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String Type = null;
		String Data = null;
		try {
			JSONObject demoJson = new JSONObject(obj.toString());
			Type = demoJson.getString("type");
			Data = demoJson.getString("data");
			if (Type.equals(GET_SUCCESS_RESULT)) {
				GetDetailData(Data);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void GetDetailData(String data) {
		// TODO Auto-generated method stub
		try {
			JSONObject demoJson = new JSONObject(data);

			userPhoto = demoJson.getString("userPhoto");
			userName = demoJson.getString("userName");
			address = demoJson.getString("address");
			sex = demoJson.getString("sex");
			loginId = demoJson.getString("loginId");
			memberLevel = demoJson.getString("memberLevel");
			memberLevelDesc = demoJson.getString("memberLevelDesc");
			permisons = demoJson.getString("permisons");
			personBg = demoJson.getString("personBg");
			userClassify = demoJson.getString("userClassify");
			sign = demoJson.getString("sign");
			hobby = demoJson.getString("hobby");
			balance = demoJson.getString("balance");
			cashBalance = demoJson.getString("cashBalance");
			realName = demoJson.getString("realName");
			cityCode = demoJson.getString("cityCode");
			mobile = demoJson.getString("mobile");
			alipayAccount = demoJson.getString("alipayAccount");
			alipayRealname = demoJson.getString("alipayRealname");
			renzhengName = demoJson.getString("renzhengName");
			renzheng = demoJson.getString("renzheng");
			sixin = demoJson.getString("sixin");
			guanzhu = demoJson.getString("guanzhu");
			fensi = demoJson.getString("fensi");
			shoucang = demoJson.getString("shoucang");
			isGuanZhu = demoJson.getString("isGuanZhu");

			WriteUserInfo();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void WriteUserInfo() {
		// TODO Auto-generated method stub
		Editor edit = PreUserInfo.edit();
		edit.putString("userPhoto", userPhoto);
		edit.putString("userName", userName);
		edit.putString("address", address);
		edit.putString("sex", sex);
		edit.putString("loginId", loginId);
		edit.putString("memberLevel", memberLevel);
		edit.putString("memberLevelDesc", memberLevelDesc);
		edit.putString("permisons", permisons);
		edit.putString("personBg", personBg);
		edit.putString("userClassify", userClassify);
		edit.putString("sign", sign);
		edit.putString("hobby", hobby);
		edit.putString("balance", balance);
		edit.putString("cashBalance", cashBalance);
		edit.putString("realName", realName);
		edit.putString("cityCode", cityCode);
		edit.putString("mobile", mobile);
		edit.putString("alipayAccount", alipayAccount);
		edit.putString("alipayRealname", alipayRealname);
		edit.putString("renzhengName", renzhengName);
		edit.putString("renzheng", renzheng);
		edit.putString("sixin", sixin);
		edit.putString("guanzhu", guanzhu);
		edit.putString("fensi", fensi);
		edit.putString("shoucang", shoucang);
		edit.putString("isGuanZhu", isGuanZhu);

		edit.commit();
		Message msg = new Message();
		msg.what = READY_USERINFO;
		uiHandler.sendMessage(msg);
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
			startActivityForResult(intent_text_resume, GO_CHANGE_HEADIMG);
			break;
		case R.id.lin_mark:
			Intent intent_lin_mark = new Intent();
			intent_lin_mark.setClass(getActivity(), MemberCenterMyMark.class);
			Bundle bundle1 = new Bundle();
			bundle1.putString("mark", credits);
			intent_lin_mark.putExtras(bundle1);
			startActivityForResult(intent_lin_mark, GO_CHANGE_MARK);
			break;
		case R.id.lin_fund:
			Intent intent_lin_fund = new Intent();
			intent_lin_fund.setClass(getActivity(), MemberCenterMyFund.class);
			Bundle bundle = new Bundle();
			bundle.putString("fund", balance);
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
