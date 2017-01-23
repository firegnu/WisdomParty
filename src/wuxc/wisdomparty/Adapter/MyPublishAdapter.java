package wuxc.wisdomparty.Adapter;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Cache.MyPublishCache;
import wuxc.wisdomparty.Model.MyPublishModel;;

public class MyPublishAdapter extends ArrayAdapter<MyPublishModel> implements OnClickListener {
	private Callback mCallback;

	public MyPublishAdapter(Activity activity, List<MyPublishModel> imageAndTexts, ListView listView,
			Callback callback) {
		super(activity, 0, imageAndTexts);
		mCallback = callback;

	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public interface Callback {
		public void click(View v);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Activity activity = (Activity) getContext();

		// Inflate the views from XML
		View rowView = convertView;
		MyPublishCache viewCache;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.item_mypublish, null);
			viewCache = new MyPublishCache(rowView);
			rowView.setTag(viewCache);
		} else {
			viewCache = (MyPublishCache) rowView.getTag();
		}
		MyPublishModel imageAndText = getItem(position);

		// Load the image and set it on the ImageView

		TextView TextTitle = viewCache.getTextTitle();
		TextTitle.setText(imageAndText.getTitle());
		TextView TextBigTime = viewCache.getTextBigTime();
		TextBigTime.setText(imageAndText.getBigTime());
		TextView Time = viewCache.getTextTime();
		Time.setText(imageAndText.getTime());
		ImageView ImageDelete = viewCache.getImageDelete();
		ImageDelete.setOnClickListener(this);
		ImageDelete.setTag(position);
		return rowView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		mCallback.click(v);
	}

}
