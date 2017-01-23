package wuxc.wisdomparty.MemberCenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Adapter.CommentAdapter;
import wuxc.wisdomparty.HomeOfMember.CommentDetailActivity;
import wuxc.wisdomparty.Model.CommentModel;
import wuxc.wisdomparty.layout.dialogfour;

public class MemberCenterMyReBackDetail extends Activity implements OnClickListener {

	private ImageView ImageBack;
	private String Title;
	private String Time;
	private String Reback;
	private TextView TextTime;
	private TextView TextTitle;
	private TextView TextReBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.membercentermyrebackdetail);
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象
		Title = bundle.getString("Title");
		Time = bundle.getString("Time");
		Reback = bundle.getString("Reback");
		initview();
		setonclicklistener();

		settext();

	}

	private void settext() {
		TextTime.setText(Time);
		TextTitle.setText(Title);
		TextReBack.setText(Reback);
	}

	private void initview() {
		// TODO Auto-generated method stub
		TextTime = (TextView) findViewById(R.id.text_time);
		TextTitle = (TextView) findViewById(R.id.text_title);
		TextReBack = (TextView) findViewById(R.id.text_reback);
		ImageBack = (ImageView) findViewById(R.id.image_back);
	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub

		ImageBack.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;

		default:
			break;
		}
	}

}
