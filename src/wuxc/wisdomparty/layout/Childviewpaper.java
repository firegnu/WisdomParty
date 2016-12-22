package wuxc.wisdomparty.layout;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class Childviewpaper extends ViewPager {
	private boolean isSlipping = true;

	public Childviewpaper(Context context) {
		super(context);
	}

	public Childviewpaper(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		if (!isSlipping) {
			return false;
		}
		return super.onInterceptTouchEvent(arg0);
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		if (!isSlipping) {
			return false;
		}
		return super.onTouchEvent(arg0);
	}

	public void setSlipping(boolean isSlipping) {
		this.isSlipping = isSlipping;
	}
}
