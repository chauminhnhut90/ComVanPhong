package com.example.comvanphong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.comvanphong.R;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_splash);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				startActivity(new Intent(SplashScreen.this, MainScreen.class));
				finish();
			}
		}, 3000);
	}

}
