package wuxc.wisdomparty.Adapter;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Cache.MyActivityCache;
import wuxc.wisdomparty.Model.MyActivityModel;;

public class MyActivityAdapter extends ArrayAdapter<MyActivityModel> {

	public MyActivityAdapter(Activity activity, List<MyActivityModel> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		MyActivityCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_myactivity, null);
			viewCache = new MyActivityCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (MyActivityCache) rowView.getTag();
		}
		MyActivityModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView

		TextView TextTitle = viewCache.getTextTitle();
		TextTitle.setText(imageAndText.getTitle());
		TextView Time = viewCache.getTextTime();
		Time.setText(imageAndText.getTime());
		TextView Mark = viewCache.getTextMark();
		Mark.setText(imageAndText.getMark());
		return rowView;
	}

}
