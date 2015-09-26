package com.example.comvanphong.fragment;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.nhutcm.officemeal.R;
import com.example.comvanphong.activity.DetailFoodScreen;
import com.example.comvanphong.adapter.GridFoodAdapter;
import com.example.comvanphong.model.FoodObject;

public class GridFoodFragment extends Fragment implements OnItemClickListener {
	private GridView gvFood;
	public ArrayList<FoodObject> data;

	public GridFoodFragment(ArrayList<FoodObject> data) {
		this.data = data;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.layout_fragment_gird_food,
				container, false);
		return v;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		doTask(view);
	}

	private void doTask(View v) {
		gvFood = (GridView) v.findViewById(R.id.gvFood);
		BaseAdapter adapter = new GridFoodAdapter(getActivity(), data);
		gvFood.setAdapter(adapter);

		gvFood.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		FoodObject f = (FoodObject) parent.getAdapter().getItem(position);
		if (null != f) {
			Intent i = new Intent(getActivity(), DetailFoodScreen.class);
			i.putExtra(DetailFoodScreen.FOOD_OBJECT_DATA, f);
			startActivity(i);
		}
	}
}
