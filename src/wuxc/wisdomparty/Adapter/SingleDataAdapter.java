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
import wuxc.wisdomparty.Cache.SingleDataCache;
import wuxc.wisdomparty.Model.SingleDataModel;;

public class SingleDataAdapter extends ArrayAdapter<SingleDataModel> {

	public SingleDataAdapter(Activity activity, List<SingleDataModel> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		SingleDataCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_single_data, null);
			viewCache = new SingleDataCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (SingleDataCache) rowView.getTag();
		}
		SingleDataModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView

		TextView TextData = viewCache.getTextData();
		TextData.setText(imageAndText.getData());

		return rowView;
	}

}
