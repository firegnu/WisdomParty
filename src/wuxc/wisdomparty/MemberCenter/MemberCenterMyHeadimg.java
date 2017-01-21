package wuxc.wisdomparty.MemberCenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.Window;
import single.wuxc.wisdomparty.R;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.member_center_myheadimg);
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
		SaveImageResource();
		SetInitLayout();
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

	private void SaveImageResource() {// 保存图片以备上传
		// TODO Auto-generated method stub
		Bitmap myBitmap = null;
		try {
			myBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.user_headimg_1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			saveMyBitmap("image_1", myBitmap);
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

				startPhotoZoom(data.getData());

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
			File file = null;
			try {
				file = saveMyBitmap("wuxc", photo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (file == null) {
				Toast.makeText(getApplicationContext(), "失败", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "成功 ", Toast.LENGTH_SHORT).show();
			}
			new Thread(new Runnable() { // 开启线程上传文件
				@Override
				public void run() {
					// qquploadFile(file, URLcontainer.uploadSignleimage,
					// loginId);
					// Message msg = new Message();
					// msg.what = 1;
					// uiHandler.sendMessage(msg);
				}
			}).start();
		}
	}

	public File saveMyBitmap(String bitName, Bitmap mBitmap) throws IOException {
		String path = Environment.getExternalStorageDirectory() + "/MyParty/";
		String myJpgPath = Environment.getExternalStorageDirectory() + "/MyParty/" + bitName + ".png";
		File tmp = new File(path);
		if (!tmp.exists()) {
			tmp.mkdir();
		}
		File f = new File(myJpgPath);
		f.createNewFile();
		FileOutputStream fOut = null;
		try {
			fOut = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
		try {
			fOut.flush();
			fOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
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
			break;
		case R.id.rounded_headimg_2:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_2);
			SetInitLayout();
			LinHeadimg2.setVisibility(View.VISIBLE);
			break;
		case R.id.rounded_headimg_3:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_3);
			SetInitLayout();
			LinHeadimg3.setVisibility(View.VISIBLE);
			break;
		case R.id.rounded_headimg_4:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_4);
			SetInitLayout();
			LinHeadimg4.setVisibility(View.VISIBLE);
			break;
		case R.id.rounded_headimg_5:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_5);
			SetInitLayout();
			LinHeadimg5.setVisibility(View.VISIBLE);
			break;
		case R.id.rounded_headimg_6:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_6);
			SetInitLayout();
			LinHeadimg6.setVisibility(View.VISIBLE);
			break;
		case R.id.rounded_headimg_7:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_7);
			SetInitLayout();
			LinHeadimg7.setVisibility(View.VISIBLE);
			break;
		case R.id.rounded_headimg_8:
			RoundedHeadimg.setImageResource(R.drawable.user_headimg_8);
			SetInitLayout();
			LinHeadimg8.setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}
	}

}
