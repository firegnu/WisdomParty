package wuxc.wisdomparty.Adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Cache.ChangeTermsCache;
import wuxc.wisdomparty.Internet.ImageLoader;
import wuxc.wisdomparty.Internet.ImageLoader.ImageCallback;
import wuxc.wisdomparty.Internet.URLcontainer;
import wuxc.wisdomparty.Model.ChangeTermsModel;;

public class ChangeTermsAdapter extends ArrayAdapter<ChangeTermsModel> {
	private ListView listView;
	private ImageLoader ImageLoader;
	private String imageurl = "";

	public ChangeTermsAdapter(Activity activity, List<ChangeTermsModel> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);
		this.listView = listView;
		ImageLoader = new ImageLoader();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		ChangeTermsCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_change_terms, null);
			viewCache = new ChangeTermsCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (ChangeTermsCache) rowView.getTag();
		}
		ChangeTermsModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView

		TextView TextTitle = viewCache.getTextTitle();
		TextTitle.setText("" + imageAndText.getTitle());
		TextView TextNumber = viewCache.getTextNumber();
		TextNumber.setText("参与(" + imageAndText.getNumber() + ")");
		TextView TextIsSelecting = viewCache.getTextIsSelecting();
		TextView TextIsSelected = viewCache.getTextIsSelected();
		if (imageAndText.isSelecting()) {
			TextIsSelected.setBackgroundResource(R.drawable.is_selecting);
			TextIsSelecting.setText("选举中...");
			TextIsSelecting.setTextColor(Color.parseColor("#f40000"));
		} else {
			TextIsSelected.setBackgroundResource(R.drawable.is_done);
			TextIsSelecting.setText("已结束");
			TextIsSelecting.setTextColor(Color.parseColor("#c2c2c2"));
		}
		if (imageAndText.isSelected()) {
			TextIsSelected.setText("已参与");
		} else {
			if (imageAndText.isSelecting()) {
				TextIsSelected.setText("我要参与");
			} else {
				TextIsSelected.setText("未参与");
			}

		}
		return rowView;
	}

}
