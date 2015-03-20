package com.example.comvanphong.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.comvanphong.R;
import com.example.comvanphong.fragment.DetailFoodFragment;
import com.example.comvanphong.model.FoodObject;
import com.example.comvanphong.uitls.CommonUtils;

public class DetailFoodScreen extends FragmentActivity {

	public static final String FOOD_OBJECT_DATA = "FOOD_OBJECT_DATA";
	private static final String TAG = DetailFoodScreen.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_detail_food);

		FoodObject f = getIntent().getExtras().getParcelable(FOOD_OBJECT_DATA);
		if (null != f) {
			Fragment fg = new DetailFoodFragment();
			Bundle b = new Bundle();
			b.putParcelable(FOOD_OBJECT_DATA, f);
			fg.setArguments(b);
			CommonUtils.addFragment(getSupportFragmentManager(), fg);
		} else {
			Log.e(TAG, "Not found");
		}
	}
}
