package wuxc.wisdomparty.PartyManage;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import single.wuxc.wisdomparty.R;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class InterPartyOnlineActivity extends Activity implements OnClickListener {
	private Button BtnConfirm;
	TimerTask task;
	private int time = 60;
	private Timer timer = new Timer();
	private boolean CanConfirm = false;
	private ImageView ImageBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.inter_party_online_activity);
		BtnConfirm = (Button) findViewById(R.id.btn_inter_confirm);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		BtnConfirm.setOnClickListener(this);
		ImageBack.setOnClickListener(this);
		delaytime();
	}

	private void delaytime() {
		// TODO Auto-generated method stub
		task = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() { // UI thread
					@Override
					public void run() {
						if (time <= 0) {
							// 当倒计时小余=0时记得还原图片，可以点击
							BtnConfirm.setText("确定");
							CanConfirm = true;
							task.cancel();
						} else {
							BtnConfirm.setText(time + "s");

						}
						time--;
					}
				});
			}
		};

		time = 60;
		timer.schedule(task, 0, 1000);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:
			finish();
			break;
		case R.id.btn_inter_confirm:
			// if (CanConfirm) {
			Intent intent = new Intent();
			intent.setClass(getApplicationContext(), InterPartyOnlineDetailActivity.class);
			startActivity(intent);
			// } else {
			// Toast.makeText(getApplicationContext(), "请仔细阅读入党宣誓词！",
			// Toast.LENGTH_SHORT).show();
			// }

			break;
		default:
			break;
		}
	}

}
