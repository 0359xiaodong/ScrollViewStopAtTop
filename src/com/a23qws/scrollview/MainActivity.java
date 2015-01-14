package com.a23qws.scrollview;

import com.a23qws.scrollview.MyScrollView.ScrollListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements ScrollListener {

	private final String TAG = "MainActivity";
	private LinearLayout suspendView, topView, include;
	private MyScrollView scrollView;
	private int topViewHeight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		include = (LinearLayout) findViewById(R.id.include);
		scrollView = (MyScrollView) findViewById(R.id.scrollview);
		scrollView.setOnScrollListener(this);
		suspendView = (LinearLayout) findViewById(R.id.suspendview);
		topView = (LinearLayout) findViewById(R.id.topview);

		// topViewHeight = topView.getHeight();
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {

		if (hasFocus) {
			topViewHeight = topView.getHeight();
		}
	}

	@Override
	public void scroll(int y) {
		// TODO Auto-generated method stub
		Log.d(TAG, "y >>>>>>>> " + y);
		Log.d(TAG, "topViewheight >>>>>>>> " + topViewHeight);
		if (y >= topViewHeight) {
			MyScrollView.flg = true; 
			
			include.setVisibility(View.VISIBLE);
			
		} else {
			include.setVisibility(View.INVISIBLE);
			MyScrollView.flg = false;
		}
	}
}
