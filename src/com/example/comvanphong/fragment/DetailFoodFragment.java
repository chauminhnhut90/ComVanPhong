package com.example.comvanphong.fragment;

import java.util.Locale;

import com.example.comvanphong.R;
import com.example.comvanphong.activity.DetailFoodScreen;
import com.example.comvanphong.model.FoodObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFoodFragment extends Fragment {

	private FoodObject f;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		f = getArguments().getParcelable(DetailFoodScreen.FOOD_OBJECT_DATA);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.layout_fragment_detail_food,
				container, false);
		return v;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		doTask(view);
	}

	private void doTask(View v) {
		if (null != f) {
			TextView tvName = (TextView) v.findViewById(R.id.txtName);
			tvName.setText(f.name.toUpperCase(Locale.getDefault()));
		}

	}
}
