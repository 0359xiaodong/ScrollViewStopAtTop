package com.a23qws.scrollview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {

	private ScrollListener listener;
	public static boolean flg = false;
	private int oldScrollY;

	public MyScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyScrollView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public MyScrollView(Context context) {
		this(context, null);
	}

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			int y = MyScrollView.this.getScrollY();
			if (oldScrollY != y) {
				oldScrollY = y;
			}
			listener.scroll(oldScrollY);
			if (flg) {
				mHandler.sendMessageDelayed(mHandler.obtainMessage(), 5);
			}
		}
	};

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		oldScrollY = MyScrollView.this.getScrollY();
		mHandler.sendMessage(mHandler.obtainMessage());
		switch (ev.getAction()) {
		case MotionEvent.ACTION_UP:
			mHandler.sendMessageDelayed(mHandler.obtainMessage(), 5);
			break;
		default:
			break;
		}
		return super.onTouchEvent(ev);
	}

	public void setOnScrollListener(ScrollListener listener) {
		this.listener = listener;
	}

	public interface ScrollListener {

		public void scroll(int y);
	}

}
