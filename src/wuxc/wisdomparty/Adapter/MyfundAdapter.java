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
import wuxc.wisdomparty.Cache.MyfundCache;
import wuxc.wisdomparty.Model.MyfundModel;;

public class MyfundAdapter extends ArrayAdapter<MyfundModel> {

	public MyfundAdapter(Activity activity, List<MyfundModel> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		MyfundCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_myfund, null);
			viewCache = new MyfundCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (MyfundCache) rowView.getTag();
		}
		MyfundModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView

		TextView TextChange = viewCache.getTextChange();
		TextChange.setText(imageAndText.getChange());
		TextView TextDetail = viewCache.getTextDetail();
		TextDetail.setText(imageAndText.getDetail());
		TextView Time = viewCache.getTextTime();
		Time.setText(imageAndText.getTime());
		return rowView;
	}

}
