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
import wuxc.wisdomparty.Cache.MydueCache;
import wuxc.wisdomparty.Model.MydueModel;;

public class MydueAdapter extends ArrayAdapter<MydueModel> {

	public MydueAdapter(Activity activity, List<MydueModel> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		MydueCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_mydue, null);
			viewCache = new MydueCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (MydueCache) rowView.getTag();
		}
		MydueModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView

		TextView TextMoney = viewCache.getTextMoney();
		TextMoney.setText(imageAndText.getMoney());
		TextView TextMonth = viewCache.getTextMonth();
		TextMonth.setText(imageAndText.getMonth());
		TextView Time = viewCache.getTextTime();
		Time.setText(imageAndText.getTime());
		return rowView;
	}

}
