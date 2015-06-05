package com.simas.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final View left = findViewById(R.id.left);
		final View right = findViewById(R.id.right);

		final RelativeLayout.LayoutParams leftParams = (RelativeLayout.LayoutParams)
				left.getLayoutParams();
		final RelativeLayout.LayoutParams rightParams = (RelativeLayout.LayoutParams)
				right.getLayoutParams();

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
					leftParams.addRule(RelativeLayout.ALIGN_RIGHT, 0);
					rightParams.addRule(RelativeLayout.ALIGN_LEFT, 0);
					left.requestLayout();
					right.requestLayout();

				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						leftParams.addRule(RelativeLayout.ALIGN_RIGHT, R.id.spacer);
						rightParams.addRule(RelativeLayout.ALIGN_LEFT, R.id.spacer);
						left.requestLayout();
						right.requestLayout();
					}
				}, 2000);
			}
		}, 2000);
	}
}