package wuxc.wisdomparty.PartyManage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import android.view.Window;

public class MemberEducationDetailActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private TextView TextTitle;
	private TextView TextTime;
	private TextView TextAuthor;
	private TextView TextReadNumber;
	private TextView TextDetail;
	private TextView TextLastEducation;
	private TextView TextNextEducation;
	private String Time;
	private String Title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_education_detail_activity);
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象

		Title = bundle.getString("Title");
		Time = bundle.getString("Time");
		initview();
		setonclicklistener();
		TextTime.setText("日期：" + Time);
		TextTitle.setText(Title);
		TextAuthor.setText("作者：超级管理员");
		TextReadNumber.setText("访问量：2341");
		TextDetail.setText(ToDBC(
				"第十八届中央政治局常委15日与中外记者见面。中共中央总书记习近平说，人民是历史的创造者，群众是真正的英雄。人民群众是我们力量的源泉。我们深深知道：每个人的力量是有限的，但只要我们万众一心，众志成城，就没有克服不了的困难；每个人的工作时间是有限的，但全心全意为人民服务是无限的。 习近平说，责任重于泰山，事业任重道远。我们一定要始终与人民心心相印、与人民同甘共苦、与人民团结奋斗，夙夜在公，勤勉工作，努力向历史、向人民交一份合格的答卷。 习近平对记者们说，中国需要更多地了解世界，世界也需要更多地了解中国。希望你们今后要继续为增进中国与世界各国的相互了解作出努力和贡献。来源： 新华"));
		TextLastEducation.setText("点击查看上一篇");
		TextNextEducation.setText("点击查看下一篇");
	}

	private void initview() {
		// TODO Auto-generated method stub
		ImageBack = (ImageView) findViewById(R.id.image_back);
		TextTitle = (TextView) findViewById(R.id.text_title);
		TextTime = (TextView) findViewById(R.id.text_time);
		TextAuthor = (TextView) findViewById(R.id.text_author);
		TextReadNumber = (TextView) findViewById(R.id.text_readnumber);
		TextDetail = (TextView) findViewById(R.id.text_detail);
		TextLastEducation = (TextView) findViewById(R.id.text_last_education);
		TextNextEducation = (TextView) findViewById(R.id.text_next_education);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		TextLastEducation.setOnClickListener(this);
		TextNextEducation.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.text_last_education:
			Toast.makeText(getApplicationContext(), "text_last_education", Toast.LENGTH_SHORT).show();
			break;
		case R.id.text_next_education:
			Toast.makeText(getApplicationContext(), "text_next_education", Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}
	}

}
