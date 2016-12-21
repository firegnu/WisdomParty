package wuxc.wisdomparty.HomeOfMember;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.RoundImageView;

public class CommentDetailActivity extends Activity implements OnClickListener {
	private RoundImageView RoundImg;
	private ImageView ImageBack;
	private String Name;
	private String Time;
	private String Comment;
	private TextView TextName;
	private TextView TextTime;
	private TextView TextComment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.commentdetailactivity);
		Intent intent = this.getIntent(); // 获取已有的intent对象
		Bundle bundle = intent.getExtras(); // 获取intent里面的bundle对象
		Name = bundle.getString("Name");
		Comment = bundle.getString("Comment");
		Time = bundle.getString("Time");
		RoundImg = (RoundImageView) findViewById(R.id.round_headimg);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		TextName = (TextView) findViewById(R.id.text_name);
		TextTime = (TextView) findViewById(R.id.text_time);
		TextComment = (TextView) findViewById(R.id.text_comment);
		TextName.setText(Name);
		TextTime.setText(Time);
		TextComment.setText(Comment);
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
