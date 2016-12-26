package wuxc.wisdomparty.PartyManage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.layout.ImageTools;

public class InterPartyOnlineDetailActivity extends Activity implements OnClickListener {
	private ImageView ImageBack;
	private ImageView ImagePhoto;
	private LinearLayout LinPhoto;
	private LinearLayout LinFile;
	private LinearLayout LinPhotoWarning;
	private Button BtnInterConfirm;
	private EditText EditName;
	private EditText EditNation;
	private EditText EditSpecial;
	private EditText EditLocation;
	private EditText EditPosition;
	private EditText EditDegree;
	private EditText EditEducation;
	private EditText EditBornPlace;
	private EditText EditNativePlace;
	private EditText EditIDnumber;
	private EditText EditSex;
	private TextView TextFilePath;
	private static final int SCALE = 5;// 照片缩小比例
	private String StrName;
	private String StrNation;
	private String StrSpecial;
	private String StrLocation;
	private String StrPosition;
	private String StrDegree;
	private String StrEducation;
	private String StrBornPlace;
	private String StrNativePlace;
	private String StrIDNumber;
	private String StrSex;
	private String StrFilePath;
	private String StrPicPath;
	private Uri StrPicUrl;
	private TextView TextFileWarning;
	private int screenwidth = 0;
	private float scale = 0;
	private float scalepx = 0;
	private float dp = 0;
	private static final int SELECT_PICTURE_REQUEST_CODE = 0;
	public static final int REQUEST_CODE_SELECT_FILE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.inter_party_online_detail_activity);
		initview();
		setonclicklistener();
		setheight();
	}

	private void setheight() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		screenwidth = getWindow().getWindowManager().getDefaultDisplay().getWidth();
		DisplayMetrics mMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
		scale = getResources().getDisplayMetrics().density;
		dp = screenwidth / scale + 0.5f;
		scalepx = screenwidth / dp;
		int height = (int) ((int) (screenwidth - 55 * scalepx) / 2 / 1.2);
		LinearLayout.LayoutParams layoutParams1 = (android.widget.LinearLayout.LayoutParams) LinPhoto.getLayoutParams();
		layoutParams1.height = height;
		LinPhoto.setLayoutParams(layoutParams1);
		layoutParams1 = (android.widget.LinearLayout.LayoutParams) LinFile.getLayoutParams();
		layoutParams1.height = height;
		LinFile.setLayoutParams(layoutParams1);

	}

	private void setonclicklistener() {
		// TODO Auto-generated method stub
		ImageBack.setOnClickListener(this);
		ImagePhoto.setOnClickListener(this);
		LinPhoto.setOnClickListener(this);
		LinFile.setOnClickListener(this);
		LinPhotoWarning.setOnClickListener(this);
		BtnInterConfirm.setOnClickListener(this);
	}

	private void initview() {
		// TODO Auto-generated method stub
		ImageBack = (ImageView) findViewById(R.id.image_back);
		ImagePhoto = (ImageView) findViewById(R.id.image_photo);
		LinPhoto = (LinearLayout) findViewById(R.id.lin_photo);
		LinFile = (LinearLayout) findViewById(R.id.lin_file);
		LinPhotoWarning = (LinearLayout) findViewById(R.id.lin_photo_warning);
		BtnInterConfirm = (Button) findViewById(R.id.btn_inter_confirm);
		EditName = (EditText) findViewById(R.id.edit_name);
		EditNation = (EditText) findViewById(R.id.edit_nation);
		EditSpecial = (EditText) findViewById(R.id.edit_special);
		EditLocation = (EditText) findViewById(R.id.edit_location);
		EditPosition = (EditText) findViewById(R.id.edit_position);
		EditDegree = (EditText) findViewById(R.id.edit_degree);
		EditEducation = (EditText) findViewById(R.id.edit_education);
		EditBornPlace = (EditText) findViewById(R.id.edit_born_place);
		EditNativePlace = (EditText) findViewById(R.id.edit_native_place);
		EditIDnumber = (EditText) findViewById(R.id.edit_idnumber);
		EditSex = (EditText) findViewById(R.id.edit_sex);
		TextFilePath = (TextView) findViewById(R.id.text_file_path);
		TextFileWarning = (TextView) findViewById(R.id.text_file_warning);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_inter_confirm:
			StrName = EditName.getText().toString();
			StrNation = EditNation.getText().toString();
			StrSpecial = EditSpecial.getText().toString();
			StrLocation = EditLocation.getText().toString();
			StrPosition = EditPosition.getText().toString();
			StrDegree = EditDegree.getText().toString();
			StrEducation = EditEducation.getText().toString();
			StrBornPlace = EditBornPlace.getText().toString();
			StrNativePlace = EditNativePlace.getText().toString();
			StrIDNumber = EditIDnumber.getText().toString();
			StrSex = EditSex.getText().toString();
			if (TextUtils.isEmpty(StrName)) {
				Toast.makeText(getApplicationContext(), "姓名不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrNation)) {
				Toast.makeText(getApplicationContext(), "民族不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrSpecial)) {
				Toast.makeText(getApplicationContext(), "特长不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrLocation)) {
				Toast.makeText(getApplicationContext(), "现居住地不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrPosition)) {
				Toast.makeText(getApplicationContext(), "单位/职务不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrDegree)) {
				Toast.makeText(getApplicationContext(), "学位或职称不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrEducation)) {
				Toast.makeText(getApplicationContext(), "学历不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrBornPlace)) {
				Toast.makeText(getApplicationContext(), "出生地不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrNativePlace)) {
				Toast.makeText(getApplicationContext(), "籍贯不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrIDNumber)) {
				Toast.makeText(getApplicationContext(), "身份证号不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrSex)) {
				Toast.makeText(getApplicationContext(), "性别不可为空", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrFilePath)) {
				Toast.makeText(getApplicationContext(), "附件未上传", Toast.LENGTH_SHORT).show();
			} else if (TextUtils.isEmpty(StrPicPath)) {
				Toast.makeText(getApplicationContext(), "免冠照未上传", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(), "加入党组织", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.image_back:
			finish();
			break;
		case R.id.lin_file:
			Intent intent = null;
			// if (Build.VERSION.SDK_INT < 19) {
			intent = new Intent(Intent.ACTION_GET_CONTENT);
			intent.setType("*/*");
			intent.addCategory(Intent.CATEGORY_OPENABLE);
			// } else {
			// intent = new Intent(Intent.ACTION_PICK,
			// android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			// }
			startActivityForResult(intent, REQUEST_CODE_SELECT_FILE);
			break;

		case R.id.image_photo:
			Intent intentgetpicimage = new Intent(Intent.ACTION_PICK, null);
			intentgetpicimage.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			startActivityForResult(intentgetpicimage, SELECT_PICTURE_REQUEST_CODE);
			break;
		case R.id.lin_photo_warning:
			// finish();
			Intent intentgetpic = new Intent(Intent.ACTION_PICK, null);
			intentgetpic.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			startActivityForResult(intentgetpic, SELECT_PICTURE_REQUEST_CODE);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (data == null)
			return;
		Bundle bundle = data.getExtras();
		switch (requestCode) {
		case SELECT_PICTURE_REQUEST_CODE:
			ContentResolver resolver = getContentResolver();
			// 照片的原始资源地址
			Uri originalUri = data.getData();
			StrPicPath = originalUri.toString();
			try {
				// 使用ContentProvider通过URI获取原始图片
				Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
				if (photo != null) {
					// 为防止原始图片过大导致内存溢出，这里先缩小原图显示，然后释放原始Bitmap占用的内存
					Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() / SCALE,
							photo.getHeight() / SCALE);
					// 释放原始图片占用的内存，防止out of memory异常发生
					photo.recycle();
					LinPhotoWarning.setVisibility(View.GONE);
					ImagePhoto.setVisibility(View.VISIBLE);
					ImagePhoto.setImageBitmap(smallBitmap);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case REQUEST_CODE_SELECT_FILE:
			// 发送选择的文件
			if (data != null) {
				Uri uri = data.getData();
				if (uri != null) {
					GetFile(uri);
				}
			}

			break;
		default:
			break;
		}
	}

	/**
	 * 获取文件
	 * 
	 * @param uri
	 */
	private void GetFile(Uri uri) {
		String filePath = null;
		if ("content".equalsIgnoreCase(uri.getScheme())) {
			String[] projection = { "_data" };
			Cursor cursor = null;

			try {
				cursor = getContentResolver().query(uri, projection, null, null, null);
				int column_index = cursor.getColumnIndexOrThrow("_data");
				if (cursor.moveToFirst()) {
					filePath = cursor.getString(column_index);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("file".equalsIgnoreCase(uri.getScheme())) {
			filePath = uri.getPath();
		}
		File file = new File(filePath);
		if (file == null || !file.exists()) {

			Toast.makeText(getApplicationContext(), "文件不存在", 0).show();
			return;
		}
		if (file.length() > 20 * 1024 * 1024) {

			Toast.makeText(getApplicationContext(), "文件不能大于20M", 0).show();
			return;
		}
		StrFilePath = filePath;
		TextFileWarning.setText("已选择");
		TextFileWarning.setTextColor(Color.BLUE);
		TextFilePath.setText(StrFilePath);
		TextFilePath.setTextColor(Color.BLUE);
	}
}
