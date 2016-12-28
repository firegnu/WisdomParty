package wuxc.wisdomparty.PartyManage;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.dialogfour;

public class AssistanceDetailActivity extends Activity implements OnClickListener {
	private ImageView ImageBackground;
	private int screenwidth = 0;
	private ImageView ImageBack;
	private ImageView ImageShare;
	private TextView TextTitle;
	private TextView TextTime;
	private TextView TextAuthor;
	private TextView TextReadNumber;
	private TextView TextDetail;
	private Button BtnConfirm;
	private String Time;
	private String Title;
	private UMImage image = null;
	private String Tag = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.assistance_detail_activity);
		initview();
		setonclicklistener();
		setlayout();
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象

		Title = bundle.getString("Title");
		Time = bundle.getString("Time");
		TextTime.setText("日期：" + Time);
		TextTitle.setText(Title);
		TextAuthor.setText("作者：超级管理员");
		TextReadNumber.setText("访问量：2341");
		TextDetail.setText(ToDBC(
				"他长得“其貌不扬”，对恶势力的关键却是“心雄万夫”。他在户部为官十四年，就因严正无私，“为吏胥所畏”。1859年，湖北巡抚胡林翼奏调他去湖北，为湖北的军队办理粮草后勤。他公正耿介，一丝不苟，胡林翼和继任湖北巡抚严树森都向皇帝推荐他，说他是国家少有的贤才，如做法官将使“弄律有准”；如做理财官则“必无欺伪”。湖广总督官文也看中了他，但官文“贪庸骄蹇”，阎敬铭对他很不满。阎敬铭(1817-1892)字丹初，清代朝邑县(今属大荔县)人，清光绪皇帝时东阁大学士，为官清廉耿介，是我国历史潮流上为数不多的理财专家，有救时宰相之称。但其山东黄崖寨冤案使人切齿。阎敬铭道光二十五年(1845)中进士，历任户部主事，湖北按察使，署布政使，署山东盐运使，山东巡抚等。1882年调任户部尚书，1883年充军机大臣，总理各国事务衙门大臣，晋协办大学士，1885年授东阁大学士。1892年卒后追赠太子少保，谥文介。官文手下有个副将。一天，他率领几名新兵闯入武昌城外一户居民家里，强抢民女，女哭骂不从，竟被他们乱刀砍死。死者父母进城告状，县、府官员都不敢过问。阎敬铭闻知此事后勃然大怒，决心为民除害。那恶棍听说阎敬铭要出面问案，赶紧跑到官文的总督府中，官文竟把他藏匿起来。阎敬铭找到总督府，向官文要凶犯。官文推说自己病重，拒不接见。阎敬铭即向随从传话:去把我的被子拿来!我就在总督府的门房过道里住宿、办公，总督的病不好，我阎敬铭绝不回去!阎敬铭真的在这里住下来。三天过去，官文被困府中实在想不出拒客的办法，只得着人请湖北巡抚严树森和武昌知府李宗寿来府劝说阎敬铭归去。严、李二人百般劝说，阎敬铭立誓不杀凶犯绝不回府。官文无奈，只得出来相见，求阎敬铭给官文一个面子，阎敬铭提出的条件是:立即交出凶犯，当众剥夺凶犯的官职，押回原籍，不许逗留片时。官文只得接受条件，把凶犯交出。阎敬铭一见凶犯，立呼衙役将其颠翻捆拿，剥去衣服，当众重杖四十，杖毕具律发落报边，立即执行。"));

	}

	private void initview() {
		// TODO Auto-generated method stub
		ImageBackground = (ImageView) findViewById(R.id.image_background);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageShare = (ImageView) findViewById(R.id.image_share);
		TextTitle = (TextView) findViewById(R.id.text_title);
		TextTime = (TextView) findViewById(R.id.text_time);
		TextAuthor = (TextView) findViewById(R.id.text_author);
		TextReadNumber = (TextView) findViewById(R.id.text_readnumber);
		TextDetail = (TextView) findViewById(R.id.text_detail);
		BtnConfirm = (Button) findViewById(R.id.btn_confirm);

	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBackground.setOnClickListener(this);
		ImageBack.setOnClickListener(this);
		ImageShare.setOnClickListener(this);
		BtnConfirm.setOnClickListener(this);
	}

	public String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375) {
				c[i] = (char) (c[i] - 65248);
			}
		}
		return new String(c);

	}

	private void setlayout() {
		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		int height = screenwidth / 2;
		LinearLayout.LayoutParams layoutParams1 = (android.widget.LinearLayout.LayoutParams) ImageBackground
				.getLayoutParams();
		layoutParams1.height = height;
		ImageBackground.setLayoutParams(layoutParams1);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_share:
			ShareDialog();
			break;
		case R.id.image_back:
			finish();
			break;
		case R.id.btn_confirm:
			Intent intent=new Intent();
			intent.setClass(getApplicationContext(), AssistancePayActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	private void ShareDialog() {
		final String title = "推荐一款很棒的APP";
		final String content = "这是一款集招聘、应聘、企业管理、即时通讯于一体的APP，是你生活工作的好帮手！";
		final String targeturl = "http://fir.im/j4zk";
		// String img = "";
		// String url = "";
		// if (!img.equals("")) {
		// url = URLcontainer.urlip + img;
		// image = new UMImage(AssistanceDetailActivity.this, url);
		// // image=new UMImage(AssistanceDetailActivity.this,
		// R.drawable.qidongye);
		// } else {
		image = new UMImage(AssistanceDetailActivity.this, R.drawable.image_share);
		// }

		dialogfour.Builder builder = new dialogfour.Builder(this);
		builder.setMessage("您未正确选择！");
		builder.setTitle("提示");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});

		builder.setNegativeButton("取消", new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.setQQImage(new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Toast.makeText(getApplicationContext(), "qq", Toast.LENGTH_SHORT).show();
				Tag = "QQ好友";
				if (image == null) {
					new ShareAction(AssistanceDetailActivity.this).setPlatform(SHARE_MEDIA.QQ)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.share();
				} else {
					new ShareAction(AssistanceDetailActivity.this).setPlatform(SHARE_MEDIA.QQ)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.withMedia(image).share();
				}
			}
		});
		builder.setQQZoneImage(new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Tag = "QQ空间";
				Toast.makeText(getApplicationContext(), "qqzone", Toast.LENGTH_SHORT).show();
				if (image == null) {
					new ShareAction(AssistanceDetailActivity.this).setPlatform(SHARE_MEDIA.QZONE)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.share();
				} else {
					new ShareAction(AssistanceDetailActivity.this).setPlatform(SHARE_MEDIA.QZONE)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.withMedia(image).share();
				}
			}
		});
		builder.setWeChatImage(new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Tag = "微信好友";
				Toast.makeText(getApplicationContext(), "wechat", Toast.LENGTH_SHORT).show();
				if (image == null) {
					new ShareAction(AssistanceDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.share();
				} else {
					new ShareAction(AssistanceDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.withMedia(image).share();
				}
			}
		});
		builder.setWeFriendsImage(new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
				Tag = "微信朋友圈";
				Toast.makeText(getApplicationContext(), "wefriends", Toast.LENGTH_SHORT).show();
				if (image == null) {
					new ShareAction(AssistanceDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.share();
				} else {
					new ShareAction(AssistanceDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.withMedia(image).share();
				}
			}
		});
		builder.create().show();

	}

	private UMShareListener umShareListener = new UMShareListener() {
		@Override
		public void onResult(SHARE_MEDIA platform) {
			// sendshareinfo();
			Toast.makeText(getApplicationContext(), Tag + "分享成功！", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onError(SHARE_MEDIA platform, Throwable t) {
			Toast.makeText(getApplicationContext(), Tag + "分享失败！", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onCancel(SHARE_MEDIA platform) {
			Toast.makeText(getApplicationContext(), Tag + "分享取消！", Toast.LENGTH_SHORT).show();
		}
	};
}
