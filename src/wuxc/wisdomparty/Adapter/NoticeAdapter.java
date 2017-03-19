package wuxc.wisdomparty.Adapter;

import java.util.List;

import org.w3c.dom.Text;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Cache.NoticeCache;
import wuxc.wisdomparty.Model.NoticeModel;;

public class NoticeAdapter extends ArrayAdapter<NoticeModel> {

	public NoticeAdapter(Activity activity, List<NoticeModel> imageAndTexts, ListView listView) {
		super(activity, 0, imageAndTexts);

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		NoticeCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_notice, null);
			viewCache = new NoticeCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (NoticeCache) rowView.getTag();
		}
		NoticeModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView

		TextView TextStyle = viewCache.getTextStyle();
		TextStyle.setText(imageAndText.getStyle());
		TextView Time = viewCache.getTextTime();
		Time.setText(imageAndText.getTime());
		TextView TextRead = viewCache.getTextRead();
		if (imageAndText.getReadState() == 1) {
			TextRead.setText("ÒÑ¶Á");
			TextRead.setTextColor(Color.BLACK);
		} else {
			TextRead.setText("Î´¶Á");
			TextRead.setTextColor(Color.RED);
		}
		return rowView;
	}

}
