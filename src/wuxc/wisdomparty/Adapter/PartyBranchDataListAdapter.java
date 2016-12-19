package wuxc.wisdomparty.Adapter;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import single.wuxc.wisdomparty.R;
import wuxc.wisdomparty.Model.PartyBranchDataListModel;

public class PartyBranchDataListAdapter extends BaseAdapter {
	private List<PartyBranchDataListModel> mData;
	private Context mContext;
	private TextView TextPartyName;
	private TextView TextPartyAddress;
	private TextView TextPartyPhonenumber;
	private RelativeLayout LinHeight;
	private LinearLayout LinSelected;
	private LinearLayout LinAll;
	private int screenheight = 0;
	private float scale = 0;
	private float scalepx = 0;
	private float dp = 0;
	private Activity thisactivity;
	private ImageView ImageHeading;

	public PartyBranchDataListAdapter(Context context, Activity activity, List<PartyBranchDataListModel> data) {
		this.thisactivity = activity;
		this.mContext = context;
		this.mData = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = View.inflate(mContext, R.layout.item_partybranch_datalist, null);
		LinHeight = (RelativeLayout) view.findViewById(R.id.lin_item_height);
		LinSelected = (LinearLayout) view.findViewById(R.id.lin_item_selected);
		LinAll = (LinearLayout) view.findViewById(R.id.lin_item_all);
		TextPartyName = (TextView) view.findViewById(R.id.party_name);
		TextPartyAddress = (TextView) view.findViewById(R.id.party_address);
		TextPartyPhonenumber = (TextView) view.findViewById(R.id.party_phonenumber);
		ImageHeading = (ImageView) view.findViewById(R.id.image_heading);
		PartyBranchDataListModel data = mData.get(position);
		TextPartyAddress.setText(data.getPartyAddress());
		TextPartyName.setText(data.getPartyName());
		TextPartyPhonenumber.setText("联系电话：" + data.getPartyPhonenumber());
		if (data.isIsSelected()) {
			LinSelected.setVisibility(view.VISIBLE);
			LinAll.setBackgroundResource(R.color.member_transform_party_symbol);
		} else {
			LinSelected.setVisibility(view.GONE);
			LinAll.setBackgroundResource(R.color.white);
		}
		screenheight = thisactivity.getWindow().getWindowManager().getDefaultDisplay().getHeight();
		DisplayMetrics mMetrics = new DisplayMetrics();
		thisactivity.getWindowManager().getDefaultDisplay().getMetrics(mMetrics);

		scale = thisactivity.getResources().getDisplayMetrics().density;
		// Log.e("mMetrics", mMetrics.toString() + "scale=" + scale + "0.5f"
		// +
		// 0.5f);
		Rect frame = new Rect();

		thisactivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);

		int statusBarHeight = frame.top;
		dp = screenheight / scale + 0.5f;
		scalepx = screenheight / dp;
		LinearLayout.LayoutParams layoutParams1 = (android.widget.LinearLayout.LayoutParams) LinHeight
				.getLayoutParams();
		layoutParams1.height = (int) (((screenheight - statusBarHeight - 161 * scalepx) / 6));
		LinHeight.setLayoutParams(layoutParams1);
		RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) ImageHeading
				.getLayoutParams();
		layoutParams.width = (int) (((screenheight - statusBarHeight - 161 * scalepx) / 6));
		ImageHeading.setLayoutParams(layoutParams);
		return view;
	}

}
