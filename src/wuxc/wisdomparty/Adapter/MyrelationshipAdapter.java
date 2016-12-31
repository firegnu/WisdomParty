package wuxc.wisdomparty.Adapter;

import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Cache.MyrelationshipCache;
import wuxc.wisdomparty.Model.MyrelationshipModel;;

public class MyrelationshipAdapter extends ArrayAdapter<MyrelationshipModel> {

	public MyrelationshipAdapter(Activity activity, List<MyrelationshipModel> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		MyrelationshipCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_myrelationship, null);
			viewCache = new MyrelationshipCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (MyrelationshipCache) rowView.getTag();
		}
		MyrelationshipModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView

		TextView TextIn = viewCache.getTextIn();
		TextIn.setText(imageAndText.getIn());
		TextView TextOut = viewCache.getTextOut();
		TextOut.setText(imageAndText.getOut());
		TextView Time = viewCache.getTextTime();
		Time.setText(imageAndText.getTime());
		LinearLayout LinAll = viewCache.getLinAll();
		if (imageAndText.isIsPink()) {
			LinAll.setBackgroundColor(Color.parseColor("#fef3f1"));
			TextIn.setTextColor(Color.parseColor("#f40000"));
		} else {
			LinAll.setBackgroundColor(Color.parseColor("#ffffff"));
			TextIn.setTextColor(Color.parseColor("#000000"));
		}
		return rowView;
	}

}
