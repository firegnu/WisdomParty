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
		setContentView(R.layout.membereducationdetailactivity);
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
				"他长得“其貌不扬”，对恶势力的关键却是“心雄万夫”。他在户部为官十四年，就因严正无私，“为吏胥所畏”。1859年，湖北巡抚胡林翼奏调他去湖北，为湖北的军队办理粮草后勤。他公正耿介，一丝不苟，胡林翼和继任湖北巡抚严树森都向皇帝推荐他，说他是国家少有的贤才，如做法官将使“弄律有准”；如做理财官则“必无欺伪”。湖广总督官文也看中了他，但官文“贪庸骄蹇”，阎敬铭对他很不满。阎敬铭(1817-1892)字丹初，清代朝邑县(今属大荔县)人，清光绪皇帝时东阁大学士，为官清廉耿介，是我国历史潮流上为数不多的理财专家，有救时宰相之称。但其山东黄崖寨冤案使人切齿。阎敬铭道光二十五年(1845)中进士，历任户部主事，湖北按察使，署布政使，署山东盐运使，山东巡抚等。1882年调任户部尚书，1883年充军机大臣，总理各国事务衙门大臣，晋协办大学士，1885年授东阁大学士。1892年卒后追赠太子少保，谥文介。官文手下有个副将。一天，他率领几名新兵闯入武昌城外一户居民家里，强抢民女，女哭骂不从，竟被他们乱刀砍死。死者父母进城告状，县、府官员都不敢过问。阎敬铭闻知此事后勃然大怒，决心为民除害。那恶棍听说阎敬铭要出面问案，赶紧跑到官文的总督府中，官文竟把他藏匿起来。阎敬铭找到总督府，向官文要凶犯。官文推说自己病重，拒不接见。阎敬铭即向随从传话:去把我的被子拿来!我就在总督府的门房过道里住宿、办公，总督的病不好，我阎敬铭绝不回去!阎敬铭真的在这里住下来。三天过去，官文被困府中实在想不出拒客的办法，只得着人请湖北巡抚严树森和武昌知府李宗寿来府劝说阎敬铭归去。严、李二人百般劝说，阎敬铭立誓不杀凶犯绝不回府。官文无奈，只得出来相见，求阎敬铭给官文一个面子，阎敬铭提出的条件是:立即交出凶犯，当众剥夺凶犯的官职，押回原籍，不许逗留片时。官文只得接受条件，把凶犯交出。阎敬铭一见凶犯，立呼衙役将其颠翻捆拿，剥去衣服，当众重杖四十，杖毕具律发落报边，立即执行。"));
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
