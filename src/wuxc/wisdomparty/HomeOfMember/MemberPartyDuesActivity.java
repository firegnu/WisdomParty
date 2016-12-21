package wuxc.wisdomparty.HomeOfMember;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.dialogtwo;

public class MemberPartyDuesActivity extends Activity implements OnClickListener {
	private TextView TextName;
	private TextView TextYear;
	private TextView TextTotalPay;
	private ImageView ImageLeft;
	private ImageView ImageRight;
	private ImageView ImageBack;
	private Button BtnSearch;
	private Button BtnPay;
	private EditText EditIDNumber;
	private RelativeLayout RelativeResult;
	private LinearLayout LinResult;
	private LinearLayout LinButtonResult;
	private LinearLayout Lin1;
	private LinearLayout Lin2;
	private LinearLayout Lin3;
	private LinearLayout LinNumber1;
	private LinearLayout LinNumber2;
	private LinearLayout LinNumber3;
	private LinearLayout LinNumber4;
	private LinearLayout LinNumber5;
	private LinearLayout LinNumber6;
	private LinearLayout LinNumber7;
	private LinearLayout LinNumber8;
	private LinearLayout LinNumber9;
	private LinearLayout LinNumber10;
	private LinearLayout LinNumber11;
	private LinearLayout LinNumber12;
	private ImageView ImageNumber1;
	private ImageView ImageNumber2;
	private ImageView ImageNumber3;
	private ImageView ImageNumber4;
	private ImageView ImageNumber5;
	private ImageView ImageNumber6;
	private ImageView ImageNumber7;
	private ImageView ImageNumber8;
	private ImageView ImageNumber9;
	private ImageView ImageNumber10;
	private ImageView ImageNumber11;
	private ImageView ImageNumber12;
	private ImageView ImageDot1;
	private ImageView ImageDot2;
	private ImageView ImageDot3;
	private ImageView ImageDot4;
	private ImageView ImageDot5;
	private ImageView ImageDot6;
	private ImageView ImageDot7;
	private ImageView ImageDot8;
	private ImageView ImageDot9;
	private ImageView ImageDot10;
	private ImageView ImageDot11;
	private ImageView ImageDot12;
	private int[] DotResourceId = { R.drawable.dot_ok, R.drawable.dot_grey };
	private int[][] NumberResourceId = {
			{ R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7,
					R.drawable.b8, R.drawable.b9, R.drawable.b10, R.drawable.b11, R.drawable.b12 },
			{ R.drawable.r1, R.drawable.r2, R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6, R.drawable.r7,
					R.drawable.r8, R.drawable.r9, R.drawable.r10, R.drawable.r11, R.drawable.r12 }, };
	// 0--已交
	// 1--未交

	private int[] status = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 };
	// 0--未选
	// 1--已选
	private int[] condition = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	private double[] money = { 0, 0, 0, 0, 0, 0, 123.7, 344.7, 3454.6, 56.9, 786.9, 976.5 };
	private double totalpay = 0.0;
	private int screenwidth = 0;
	private float scale = 0;
	private float scalepx = 0;
	private float dp = 0;
	private int inityear = 2016;
	private String monthstring = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_party_dues_activity);
		initview();
		setonclicklistener();
		setlayoutheight();
		setinitview();

	}

	private void setinitview() {
		// TODO Auto-generated method stub
		RelativeResult.setVisibility(View.INVISIBLE);
		LinResult.setVisibility(View.INVISIBLE);
		LinButtonResult.setVisibility(View.INVISIBLE);
	}

	public void setImage() {
		// TODO Auto-generated method stub
		ImageView[] ImageNumber = { ImageNumber1, ImageNumber2, ImageNumber3, ImageNumber4, ImageNumber5, ImageNumber6,
				ImageNumber7, ImageNumber8, ImageNumber9, ImageNumber10, ImageNumber11, ImageNumber12 };
		ImageView[] ImageDot = { ImageDot1, ImageDot2, ImageDot3, ImageDot4, ImageDot5, ImageDot6, ImageDot7, ImageDot8,
				ImageDot9, ImageDot10, ImageDot11, ImageDot12 };
		for (int i = 0; i < 12; i++) {
			ImageNumber[i].setImageResource(NumberResourceId[status[i]][i]);
			ImageDot[i].setImageResource(DotResourceId[status[i]]);
		}

	}

	private void initview() {
		// TODO Auto-generated method stub
		TextName = (TextView) findViewById(R.id.text_name);
		TextYear = (TextView) findViewById(R.id.text_year);
		TextTotalPay = (TextView) findViewById(R.id.text_total_pay);
		ImageLeft = (ImageView) findViewById(R.id.image_left);
		ImageRight = (ImageView) findViewById(R.id.image_right);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		BtnSearch = (Button) findViewById(R.id.btn_search);
		BtnPay = (Button) findViewById(R.id.btn_pay);
		EditIDNumber = (EditText) findViewById(R.id.edit_id_number);
		RelativeResult = (RelativeLayout) findViewById(R.id.relative_result);
		LinResult = (LinearLayout) findViewById(R.id.lin_result);
		LinButtonResult = (LinearLayout) findViewById(R.id.lin_button_result);
		Lin1 = (LinearLayout) findViewById(R.id.lin_1);
		Lin2 = (LinearLayout) findViewById(R.id.lin_2);
		Lin3 = (LinearLayout) findViewById(R.id.lin_3);
		LinNumber1 = (LinearLayout) findViewById(R.id.lin_number_1);
		LinNumber2 = (LinearLayout) findViewById(R.id.lin_number_2);
		LinNumber3 = (LinearLayout) findViewById(R.id.lin_number_3);
		LinNumber4 = (LinearLayout) findViewById(R.id.lin_number_4);
		LinNumber5 = (LinearLayout) findViewById(R.id.lin_number_5);
		LinNumber6 = (LinearLayout) findViewById(R.id.lin_number_6);
		LinNumber7 = (LinearLayout) findViewById(R.id.lin_number_7);
		LinNumber8 = (LinearLayout) findViewById(R.id.lin_number_8);
		LinNumber9 = (LinearLayout) findViewById(R.id.lin_number_9);
		LinNumber10 = (LinearLayout) findViewById(R.id.lin_number_10);
		LinNumber11 = (LinearLayout) findViewById(R.id.lin_number_11);
		LinNumber12 = (LinearLayout) findViewById(R.id.lin_number_12);
		ImageNumber1 = (ImageView) findViewById(R.id.image_number_1);
		ImageNumber2 = (ImageView) findViewById(R.id.image_number_2);
		ImageNumber3 = (ImageView) findViewById(R.id.image_number_3);
		ImageNumber4 = (ImageView) findViewById(R.id.image_number_4);
		ImageNumber5 = (ImageView) findViewById(R.id.image_number_5);
		ImageNumber6 = (ImageView) findViewById(R.id.image_number_6);
		ImageNumber7 = (ImageView) findViewById(R.id.image_number_7);
		ImageNumber8 = (ImageView) findViewById(R.id.image_number_8);
		ImageNumber9 = (ImageView) findViewById(R.id.image_number_9);
		ImageNumber10 = (ImageView) findViewById(R.id.image_number_10);
		ImageNumber11 = (ImageView) findViewById(R.id.image_number_11);
		ImageNumber12 = (ImageView) findViewById(R.id.image_number_12);
		ImageDot1 = (ImageView) findViewById(R.id.image_dot_1);
		ImageDot2 = (ImageView) findViewById(R.id.image_dot_2);
		ImageDot3 = (ImageView) findViewById(R.id.image_dot_3);
		ImageDot4 = (ImageView) findViewById(R.id.image_dot_4);
		ImageDot5 = (ImageView) findViewById(R.id.image_dot_5);
		ImageDot6 = (ImageView) findViewById(R.id.image_dot_6);
		ImageDot7 = (ImageView) findViewById(R.id.image_dot_7);
		ImageDot8 = (ImageView) findViewById(R.id.image_dot_8);
		ImageDot9 = (ImageView) findViewById(R.id.image_dot_9);
		ImageDot10 = (ImageView) findViewById(R.id.image_dot_10);
		ImageDot11 = (ImageView) findViewById(R.id.image_dot_11);
		ImageDot12 = (ImageView) findViewById(R.id.image_dot_12);

	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		TextName.setOnClickListener(this);
		TextYear.setOnClickListener(this);
		TextTotalPay.setOnClickListener(this);
		ImageLeft.setOnClickListener(this);
		ImageRight.setOnClickListener(this);
		ImageBack.setOnClickListener(this);
		BtnSearch.setOnClickListener(this);
		BtnPay.setOnClickListener(this);
		EditIDNumber.setOnClickListener(this);
		RelativeResult.setOnClickListener(this);
		LinResult.setOnClickListener(this);
		LinButtonResult.setOnClickListener(this);
		Lin1.setOnClickListener(this);
		Lin2.setOnClickListener(this);
		Lin3.setOnClickListener(this);
		LinNumber1.setOnClickListener(this);
		LinNumber2.setOnClickListener(this);
		LinNumber3.setOnClickListener(this);
		LinNumber4.setOnClickListener(this);
		LinNumber5.setOnClickListener(this);
		LinNumber6.setOnClickListener(this);
		LinNumber7.setOnClickListener(this);
		LinNumber8.setOnClickListener(this);
		LinNumber9.setOnClickListener(this);
		LinNumber10.setOnClickListener(this);
		LinNumber11.setOnClickListener(this);
		LinNumber12.setOnClickListener(this);

	}

	private void setlayoutheight() {
		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		DisplayMetrics mMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
		scale = getResources().getDisplayMetrics().density;
		dp = screenwidth / scale + 0.5f;
		scalepx = screenwidth / dp;
		int height = (int) ((screenwidth - 67 * scalepx) / 4);
		LinearLayout.LayoutParams layoutParams1 = (android.widget.LinearLayout.LayoutParams) Lin1.getLayoutParams();
		layoutParams1.height = height;
		Lin1.setLayoutParams(layoutParams1);
		layoutParams1 = (android.widget.LinearLayout.LayoutParams) Lin2.getLayoutParams();
		layoutParams1.height = height;
		Lin2.setLayoutParams(layoutParams1);
		layoutParams1 = (android.widget.LinearLayout.LayoutParams) Lin3.getLayoutParams();
		layoutParams1.height = height;
		Lin3.setLayoutParams(layoutParams1);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.lin_number_1:
			if (status[0] == 0) {
				Toast.makeText(getApplicationContext(), "1月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[0] == 0) {
					condition[0] = 1;
					ImageDot1.setImageResource(R.drawable.dot_red);
				} else {
					condition[0] = 0;
					ImageDot1.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_2:
			if (status[1] == 0) {
				Toast.makeText(getApplicationContext(), "2月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[1] == 0) {
					condition[1] = 1;
					ImageDot2.setImageResource(R.drawable.dot_red);
				} else {
					condition[1] = 0;
					ImageDot2.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_3:
			if (status[2] == 0) {
				Toast.makeText(getApplicationContext(), "3月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[2] == 0) {
					condition[2] = 1;
					ImageDot3.setImageResource(R.drawable.dot_red);
				} else {
					condition[2] = 0;
					ImageDot3.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_4:
			if (status[3] == 0) {
				Toast.makeText(getApplicationContext(), "4月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[3] == 0) {
					condition[3] = 1;
					ImageDot4.setImageResource(R.drawable.dot_red);
				} else {
					condition[3] = 0;
					ImageDot4.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_5:
			if (status[4] == 0) {
				Toast.makeText(getApplicationContext(), "5月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[4] == 0) {
					condition[4] = 1;
					ImageDot5.setImageResource(R.drawable.dot_red);
				} else {
					condition[4] = 0;
					ImageDot5.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_6:
			if (status[5] == 0) {
				Toast.makeText(getApplicationContext(), "6月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[5] == 0) {
					condition[5] = 1;
					ImageDot6.setImageResource(R.drawable.dot_red);
				} else {
					condition[5] = 0;
					ImageDot6.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_7:
			if (status[6] == 0) {
				Toast.makeText(getApplicationContext(), "7月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[6] == 0) {
					condition[6] = 1;
					ImageDot7.setImageResource(R.drawable.dot_red);
				} else {
					condition[6] = 0;
					ImageDot7.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_8:
			if (status[7] == 0) {
				Toast.makeText(getApplicationContext(), "8月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[7] == 0) {
					condition[7] = 1;
					ImageDot8.setImageResource(R.drawable.dot_red);
				} else {
					condition[7] = 0;
					ImageDot8.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_9:
			if (status[8] == 0) {
				Toast.makeText(getApplicationContext(), "9月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[8] == 0) {
					condition[8] = 1;
					ImageDot9.setImageResource(R.drawable.dot_red);
				} else {
					condition[8] = 0;
					ImageDot9.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_10:
			if (status[9] == 0) {
				Toast.makeText(getApplicationContext(), "10月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[9] == 0) {
					condition[9] = 1;
					ImageDot10.setImageResource(R.drawable.dot_red);
				} else {
					condition[9] = 0;
					ImageDot10.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_11:
			if (status[10] == 0) {
				Toast.makeText(getApplicationContext(), "11月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[10] == 0) {
					condition[10] = 1;
					ImageDot11.setImageResource(R.drawable.dot_red);
				} else {
					condition[10] = 0;
					ImageDot11.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.lin_number_12:
			if (status[11] == 0) {
				Toast.makeText(getApplicationContext(), "12月党费已交", Toast.LENGTH_SHORT).show();
			} else {
				if (condition[11] == 0) {
					condition[11] = 1;
					ImageDot12.setImageResource(R.drawable.dot_red);
				} else {
					condition[11] = 0;
					ImageDot12.setImageResource(R.drawable.dot_grey);
				}
				ShowPayMoney();
			}
			break;
		case R.id.image_back:
			finish();
			break;
		case R.id.image_left:
			inityear = inityear - 1;
			TextYear.setText("" + inityear);
			break;
		case R.id.image_right:
			inityear = inityear + 1;
			TextYear.setText("" + inityear);
			break;
		case R.id.text_year:

			break;
		case R.id.btn_pay:
			if (monthstring.equals("")) {
				Toast.makeText(getApplicationContext(), "您未选择要支付的月份", Toast.LENGTH_SHORT).show();

			} else {
				showAlertDialog();
			}

			break;
		case R.id.btn_search:
			String idnumber = EditIDNumber.getText().toString();
			if (idnumber.equals("") || idnumber == null) {
				Toast.makeText(getApplicationContext(), "证件号不可为空", Toast.LENGTH_SHORT).show();
			} else {
				ShowResult();
			}
			break;
		default:
			break;
		}
	}

	public void showAlertDialog() {

		dialogtwo.Builder builder = new dialogtwo.Builder(this);
		builder.setMessage("您将支付" + totalpay + "元\n用于缴纳" + inityear + "年" + monthstring + "月份党费");
		builder.setTitle("缴费确认");
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

		builder.create().show();

	}

	private void ShowResult() {
		// TODO Auto-generated method stub
		TextName.setText("姓名：吴安安");
		RelativeResult.setVisibility(View.VISIBLE);
		LinResult.setVisibility(View.VISIBLE);
		LinButtonResult.setVisibility(View.VISIBLE);
		TextYear.setText("" + inityear);
		setImage();
	}

	private void ShowPayMoney() {
		// TODO Auto-generated method stub
		double result = 0;
		monthstring = "";
		for (int i = 0; i < 12; i++) {
			if (condition[i] == 1) {
				result = result + money[i];
				monthstring = monthstring + (i + 1) + "、";
			}

		}
		if (!monthstring.equals("")) {
			String b[] = monthstring.split("");
			monthstring = "";
			for (int i = 0; i < b.length - 1; i++) {
				monthstring = monthstring + b[i];
			}
		}

		totalpay = result;
		TextTotalPay.setText("共计" + result + "元");
	}

}
