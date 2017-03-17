package wuxc.wisdomparty.MemberCenter;

import java.io.File;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Internet.GetBitmapFromServer;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.Internet.UpLoadFile;
import wuxc.wisdomparty.Internet.getImageAbsolutePath;
import wuxc.wisdomparty.Internet.saveBitmap;
import wuxc.wisdomparty.Internet.savePNG;
import wuxc.wisdomparty.layout.RoundedImageView;

public class MemberCenterMyHeadimg extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private int screenwidth;
	private int ScreenHeight = 0;
	private LinearLayout LinUserHeadimg;
	// lin_up_pic
	// rounded_headimg
	private LinearLayout LinUpPic;
	private RoundedImageView RoundedHeadimg;
	private static final int UPLOAD_PICTURE = 1;
	private static final int GET_CUT_PICTURE = 2;
	private static final int GET_UPLOAD_RESULT = 3;
	private Bitmap mbitmap;
	private RoundedImageView RoundHeadimg1;
	private RoundedImageView RoundHeadimg2;
	private RoundedImageView RoundHeadimg3;
	private RoundedImageView RoundHeadimg4;
	private RoundedImageView RoundHeadimg5;
	private RoundedImageView RoundHeadimg6;
	private RoundedImageView RoundHeadimg7;
	private RoundedImageView RoundHeadimg8;
	private LinearLayout LinHeadimg1;
	private LinearLayout LinHeadimg2;
	private LinearLayout LinHeadimg3;
	private LinearLayout LinHeadimg4;
	private LinearLayout LinHeadimg5;
	private LinearLayout LinHeadimg6;
	private LinearLayout LinHeadimg7;
	private LinearLayout LinHeadimg8;
	private static String HeadimgAbsolutePath;
	private SharedPreferences PreUserInfo;// 存储个人信息
	private String LoginId;
	private String ticket;
	private String userPhoto;
	private final static int GET_USER_HEAD_IMAGE = 6;
	private boolean UploadImage = false;
	private Handler uiHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GET_UPLOAD_RESULT:
				GetUpLoadResult(msg.obj);
				break;
			case GET_USER_HEAD_IMAGE:
				ShowHeadImage(msg.obj);
				break;
			default:
				break;
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_myheadimg);
		PreUserInfo = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		ReadTicket();
		LinUserHeadimg = (LinearLayout) findViewById(R.id.lin_user_headimg);
		LinUpPic = (LinearLayout) findViewById(R.id.lin_up_pic);
		RoundedHeadimg = (RoundedImageView) findViewById(R.id.rounded_headimg);
		ImageBack = (ImageView) findViewById(R.id.image_back);
		RoundHeadimg1 = (RoundedImageView) findViewById(R.id.rounded_headimg_1);
		RoundHeadimg2 = (RoundedImageView) findViewById(R.id.rounded_headimg_2);
		RoundHeadimg3 = (RoundedImageView) findViewById(R.id.rounded_headimg_3);
		RoundHeadimg4 = (RoundedImageView) findViewById(R.id.rounded_headimg_4);
		RoundHeadimg5 = (RoundedImageView) findViewById(R.id.rounded_headimg_5);
		RoundHeadimg6 = (RoundedImageView) findViewById(R.id.rounded_headimg_6);
		RoundHeadimg7 = (RoundedImageView) findViewById(R.id.rounded_headimg_7);
		RoundHeadimg8 = (RoundedImageView) findViewById(R.id.rounded_headimg_8);
		LinHeadimg1 = (LinearLayout) findViewById(R.id.lin_headimg_1);
		LinHeadimg2 = (LinearLayout) findViewById(R.id.lin_headimg_2);
		LinHeadimg3 = (LinearLayout) findViewById(R.id.lin_headimg_3);
		LinHeadimg4 = (LinearLayout) findViewById(R.id.lin_headimg_4);
		LinHeadimg5 = (LinearLayout) findViewById(R.id.lin_headimg_5);
		LinHeadimg6 = (LinearLayout) findViewById(R.id.lin_headimg_6);
		LinHeadimg7 = (LinearLayout) findViewById(R.id.lin_headimg_7);
		LinHeadimg8 = (LinearLayout) findViewById(R.id.lin_headimg_8);
		RoundHeadimg1.setOnClickListener(this);
		RoundHeadimg2.setOnClickListener(this);
		RoundHeadimg3.setOnClickListener(this);
		RoundHeadimg4.setOnClickListener(this);
		RoundHeadimg5.setOnClickListener(this);
		RoundHeadimg6.setOnClickListener(this);
		RoundHeadimg7.setOnClickListener(this);
		RoundHeadimg8.setOnClickListener(this);
		ImageBack.setOnClickListener(this);
		LinUpPic.setOnClickListener(this);
		initheight();
		SetInitLayout();
		GetHeadPic();
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

	protected void GetUpLoadResult(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj == null)) {
			String fileInfo = null;
			try {
				JSONObject demoJson = new JSONObject(obj.toString());
				fileInfo = demoJson.getString("fileInfo");
				if (!fileInfo.equals("") || !(fileInfo == null)) {
					GetImageNameFromResult(fileInfo);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	private void GetImageNameFromResult(String fileInfo) {
		// TODO Auto-generated method stub
		String fileName = null;
		String filePath = null;
		try {
			JSONObject demoJson = new JSONObject(fileInfo);
			fileName = demoJson.getString("fileName");
			filePath = demoJson.getString("filePath");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (fileName.equals("image_headimg")) {
			Toast.makeText(getApplicationContext(), "上传成功！", Toast.LENGTH_SHORT).show();
			WriteUsPhoto(filePath);
			UploadImage = true;
		} else {
			Toast.makeText(getApplicationContext(), "上传失败！", Toast.LENGTH_SHORT).show();
		}
	}

	private void WriteUsPhoto(String filePath) {
		// TODO Auto-generated method stub
		Editor edit = PreUserInfo.edit();
		edit.putString("userPhoto", filePath);
		edit.commit();
	}

	private void SetInitLayout() {
		// TODO Auto-generated method stub
		LinHeadimg1.setVisibility(View.GONE);
		LinHeadimg2.setVisibility(View.GONE);
		LinHeadimg3.setVisibility(View.GONE);
		LinHeadimg4.setVisibility(View.GONE);
		LinHeadimg5.setVisibility(View.GONE);
		LinHeadimg6.setVisibility(View.GONE);
		LinHeadimg7.setVisibility(View.GONE);
		LinHeadimg8.setVisibility(View.GONE);

	}

	private void ReadTicket() {
		// TODO Auto-generated method stub
		LoginId = PreUserInfo.getString("loginId", null);
		ticket = PreUserInfo.getString("ticket", null);
		userPhoto = PreUserInfo.getString("userPhoto", null);
	}

	private void SaveImageResource(int resourceid) {// 保存图片以备上传
		// TODO Auto-generated method stub
		Bitmap myBitmap = null;
		try {
			myBitmap = BitmapFactory.decodeResource(getResources(), resourceid);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			File file = saveBitmap.saveMyBitmap("image_headimg", myBitmap);
			setPicToView(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initheight() {
		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		ScreenHeight = (int) (screenwidth / 2);
		RelativeLayout.LayoutParams LayoutParams = (android.widget.RelativeLayout.LayoutParams) LinUserHeadimg
				.getLayoutParams();
		LayoutParams.height = ScreenHeight;
		LinUserHeadimg.setLayoutParams(LayoutParams);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (data == null)
			return;
		Bundle bundle = data.getExtras();
		switch (requestCode) {
		case UPLOAD_PICTURE:
			if (!(data == null)) {
				HeadimgAbsolutePath = "";
				startPhotoZoom(data.getData());
				HeadimgAbsolutePath = getImageAbsolutePath.getPath(this, data.getData());
			}

			break;
		case GET_CUT_PICTURE:
			if (data != null) {
				setPicToView(data);
			}
			break;
		default:
			break;

		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void setPicToView(Intent picdata) {
		Bundle extras = picdata.getExtras();
		if (extras != null) {
			Bitmap photo = extras.getParcelable("data");
			mbitmap = photo;
			Drawable drawable = new BitmapDrawable(photo);
			RoundedHeadimg.setImageBitmap(photo);
			final File file1 = savePNG.savePNG_After(photo, "wuxc", HeadimgAbsolutePath);
			File file = null;

			try {
				file = saveBitmap.saveMyBitmap("wuxc", photo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			new Thread(new Runnable() { // 开启线程上传文件
				@Override
				public void run() {
					String UpLoadResult = UpLoadFile.uploadHeadImage(file1,
							URLcontainer.urlip + URLcontainer.UpLoadSignle, LoginId, ticket);
					Message msg = new Message();
					msg.what = GET_UPLOAD_RESULT;
					msg.obj = UpLoadResult;
					uiHandler.sendMessage(msg);
				}
			}).start();
		}
	}

	private void setPicToView(final File file) {
		if (file != null) {

			new Thread(new Runnable() { // 开启线程上传文件
				@Override
				public void run() {
					String UpLoadResult = UpLoadFile.uploadHeadImage(file,
							URLcontainer.urlip + URLcontainer.UpLoadSignle, LoginId, ticket);
					Message msg = new Message();
					msg.what = GET_UPLOAD_RESULT;
					msg.obj = UpLoadResult;
					uiHandler.sendMessage(msg);
				}
			}).start();
		}
	}

	public void startPhotoZoom(Uri uri) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		intent.putExtra("outputX", 150);
		intent.putExtra("outputY", 150);
		intent.putExtra("return-data", true);
		intent.putExtra("circleCrop", true);

		startActivityForResult(intent, GET_CUT_PICTURE);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.image_back:

			Intent intentresult = new Intent();

			intentresult.putExtra("UploadImage", UploadImage);

			setResult(0, intentresult);
			finish();
			break;
		case R.id.lin_up_pic:
			Intent intent = new Intent(Intent.ACTION_PICK, null);
			intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			startActivityForResult(intent, UPLOAD_PICTURE);
			break;
		case R.id.rounded_headimg_1:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_1);
			SetInitLayout();
			LinHeadimg1.setVisibility(View.VISIBLE);
			SaveImageResource(R.drawable.user_headimg_1);
			break;
		case R.id.rounded_headimg_2:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_2);
			SetInitLayout();
			LinHeadimg2.setVisibility(View.VISIBLE);
			SaveImageResource(R.drawable.user_headimg_2);
			break;
		case R.id.rounded_headimg_3:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_3);
			SetInitLayout();
			LinHeadimg3.setVisibility(View.VISIBLE);
			SaveImageResource(R.drawable.user_headimg_3);
			break;
		case R.id.rounded_headimg_4:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_4);
			SetInitLayout();
			LinHeadimg4.setVisibility(View.VISIBLE);
			SaveImageResource(R.drawable.user_headimg_4);
			break;
		case R.id.rounded_headimg_5:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_5);
			SetInitLayout();
			LinHeadimg5.setVisibility(View.VISIBLE);
			SaveImageResource(R.drawable.user_headimg_5);
			break;
		case R.id.rounded_headimg_6:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_6);
			SetInitLayout();
			LinHeadimg6.setVisibility(View.VISIBLE);
			SaveImageResource(R.drawable.user_headimg_6);
			break;
		case R.id.rounded_headimg_7:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_7);
			SetInitLayout();
			LinHeadimg7.setVisibility(View.VISIBLE);
			SaveImageResource(R.drawable.user_headimg_7);
			break;
		case R.id.rounded_headimg_8:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_8);
			SetInitLayout();
			LinHeadimg8.setVisibility(View.VISIBLE);
			SaveImageResource(R.drawable.user_headimg_8);
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intentresult = new Intent();

			intentresult.putExtra("UploadImage", UploadImage);

			setResult(0, intentresult);
			finish();
		}
		return false;
	}
}
