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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Window;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.dialogfour;

public class StudyArticleDetailActivity extends Activity implements OnClickListener {
	private ImageView ImageBackground;
	private ImageView ImageBack;
	private ImageView ImageShare;
	private ImageView ImageCollect;
	private ImageView ImageGreat;
	private TextView TextTime;
	private TextView TextDetail;
	private LinearLayout LinCollect;
	private LinearLayout LinGreat;
	private int screenwidth = 0;
	private TextView TextTitle;
	private String Title;
	private String Time;
	private boolean IsCollect = true;
	private Boolean IsGreat = false;
	private UMImage image = null;
	private String Tag = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.study_article_detail_activity);
		initview();
		setonclicklistener();
		setlayoutheight();
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象

		Title = bundle.getString("Title");
		Time = bundle.getString("Time");
		settext();
		ShowCollectAndGreat();
	}

	private void settext() {
		// TODO Auto-generated method stub
		TextTime.setText(Time);
		TextTitle.setText(Title);
		TextDetail.setText(
				"随着甘肃省“加强安全法制保障安全生产”知识竞赛落下帷幕，三个月的封闭集训画上了圆满的句号。回顾过去，有挑灯夜读，不弃功于寸阴的坚持；有放下书本，脑袋发懵、遥遥无期时的迷茫；也有齐心协力，十指包拳力千斤的无畏。三个月里增长的不仅仅是知识，更是面对挑战、面对压力、面对机会时的责任、担当和信念。");

	}

	private void ShowCollectAndGreat() {
		if (IsCollect) {
			ImageCollect.setImageResource(R.drawable.collect);
		} else {
			ImageCollect.setImageResource(R.drawable.no_collect);
		}
		if (IsGreat) {
			ImageGreat.setImageResource(R.drawable.great);
		} else {
			ImageGreat.setImageResource(R.drawable.no_great);
		}
	}

	private void initview() {
		// TODO Auto-generated method stub
		ImageBackground = (ImageView) findViewById(R.id.image_background);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImageShare = (ImageView) findViewById(R.id.image_share);
		ImageCollect = (ImageView) findViewById(R.id.image_collect);
		ImageGreat = (ImageView) findViewById(R.id.image_great);
		TextTime = (TextView) findViewById(R.id.text_time);
		TextDetail = (TextView) findViewById(R.id.text_detail);
		LinCollect = (LinearLayout) findViewById(R.id.lin_collect);
		LinGreat = (LinearLayout) findViewById(R.id.lin_great);
		TextTitle = (TextView) findViewById(R.id.text_title);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBackground.setOnClickListener(this);
		ImageBack.setOnClickListener(this);
		ImageShare.setOnClickListener(this);
		LinCollect.setOnClickListener(this);
		LinGreat.setOnClickListener(this);
	}

	private void setlayoutheight() {
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
		case R.id.image_back:
			finish();
			break;
		case R.id.image_share:
			ShareDialog();
			break;
		case R.id.lin_collect:
			if (IsCollect) {
				IsCollect = false;
			} else {
				IsCollect = true;
			}
			ShowCollectAndGreat();
			break;
		case R.id.lin_great:
			if (IsGreat) {
				IsGreat = false;
			} else {
				IsGreat = true;
			}
			ShowCollectAndGreat();
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
		image = new UMImage(getApplicationContext(), R.drawable.image_share);
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
					new ShareAction(StudyArticleDetailActivity.this).setPlatform(SHARE_MEDIA.QQ)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.share();
				} else {
					new ShareAction(StudyArticleDetailActivity.this).setPlatform(SHARE_MEDIA.QQ)
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
					new ShareAction(StudyArticleDetailActivity.this).setPlatform(SHARE_MEDIA.QZONE)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.share();
				} else {
					new ShareAction(StudyArticleDetailActivity.this).setPlatform(SHARE_MEDIA.QZONE)
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
					new ShareAction(StudyArticleDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.share();
				} else {
					new ShareAction(StudyArticleDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN)
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
					new ShareAction(StudyArticleDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
							.setCallback(umShareListener).withText(content).withTitle(title).withTargetUrl(targeturl)
							.share();
				} else {
					new ShareAction(StudyArticleDetailActivity.this).setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
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
