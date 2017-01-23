package wuxc.wisdomparty.Adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Cache.MyPostCache;
import wuxc.wisdomparty.Internet.ImageLoader;
import wuxc.wisdomparty.Internet.ImageLoader.ImageCallback;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.Model.MyPostModel;
import wuxc.wisdomparty.layout.RoundedImageView;;

public class MyPostAdapter extends ArrayAdapter<MyPostModel> implements OnClickListener {
	private ListView listView;
	private ImageLoader ImageLoader;
	private String imageurl = "";
	private Callback mCallback;

	public MyPostAdapter(Activity activity, List<MyPostModel> imageAndTexts, ListView listView, Callback callback) {
		super(activity, 0, imageAndTexts);
		this.listView = listView;
		ImageLoader = new ImageLoader();
		mCallback = callback;
	}

	public interface Callback {
		public void click(View v);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		mCallback.click(v);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		MyPostCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_mypost, null);
			viewCache = new MyPostCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (MyPostCache) rowView.getTag();
		}
		MyPostModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView
		String imageUrl = imageAndText.getHeadImgUrl();
		RoundedImageView imageView = viewCache.getHeadImg();
		imageView.setTag(URLcontainer.urlip + imageUrl);

		if (imageUrl.equals(imageurl)) {
			imageView.setImageResource(R.drawable.item_headimg);
		} else {
			try {
				String imageName1 = getBitName(imageUrl);
				String temppath = Environment.getExternalStorageDirectory() + "/chat/" + imageName1 + ".png";
				Bitmap bm1 = null;
				bm1 = getBitmapByPath(temppath);
				if (bm1 == null) {
					imageUrl = URLcontainer.urlip + imageUrl;
					Log.e("imageUrl", imageUrl);
					Drawable cachedImage = ImageLoader.loadDrawable(imageUrl, new ImageCallback() {
						public void imageLoaded(Drawable imageDrawable, String imageUrl) {
							ImageView imageViewByTag = (ImageView) listView.findViewWithTag(imageUrl);
							if (imageViewByTag != null) {
								imageViewByTag.setImageDrawable(imageDrawable);
							}
						}
					});
					if (cachedImage == null) {
						imageView.setImageResource(R.drawable.item_headimg);
					} else {
						Drawable d = cachedImage; // xxx根据自己的情况获取drawable

						BitmapDrawable bd = (BitmapDrawable) d;

						Bitmap bm = bd.getBitmap();
						bm = cutBmp(bm);
						imageView.setImageBitmap(bm);
					}
				} else {
					imageView.setImageBitmap(bm1);
				}
			} catch (Exception e) {
				// TODO: handle exception
			} catch (OutOfMemoryError e) {
				// TODO: handle exception
			}

		}

		TextView TextTime = viewCache.getTextTime();
		TextTime.setText("" + imageAndText.getTime());
		TextView Textname = viewCache.getTextName();
		Textname.setText("" + imageAndText.getName());
		TextView TextTitle = viewCache.getTextTitle();
		TextTitle.setText("" + imageAndText.getTitle());
		TextView TextReBack = viewCache.getTextMyReBack();
		TextReBack.setText("" + imageAndText.getReBack());
		ImageView ImageDelete = viewCache.getImageDelete();
		ImageDelete.setOnClickListener(this);
		ImageDelete.setTag(position);
		return rowView;
	}

	public Bitmap getBitmapByPath(String fileName) {
		// String myJpgPath =
		// Environment.getExternalStorageDirectory()+"pepper/" + fileName;
		BitmapFactory.Options options = new BitmapFactory.Options();
		// options.inSampleSize = 12;
		Bitmap bm = BitmapFactory.decodeFile(fileName, options);
		return bm;
	}

	private String getBitName(String imageUrl) {
		// TODO Auto-generated method stub
		String[] temp = imageUrl.split("");
		String result = "";
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].equals("/") || temp[i].equals(".")) {
				temp[i] = "";
			}
			result = result + temp[i];
		}
		return result;
	}

	public void saveMyBitmap(String bitName, Bitmap mBitmap) throws IOException {
		String path = Environment.getExternalStorageDirectory() + "/chat/";
		String myJpgPath = Environment.getExternalStorageDirectory() + "/chat/" + bitName + ".png";
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
	}

	public Bitmap cutBmp(Bitmap bmp) {
		Bitmap result;
		int w = bmp.getWidth();// 输入长方形宽
		int h = bmp.getHeight();// 输入长方形高
		int nw;// 输出正方形宽
		result = Bitmap.createBitmap(bmp, 15 * w / 100, 15 * h / 100, 7 * w / 10, 7 * h / 10);
		// }
		return result;
	}
}
