package com.example.comvanphong.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.nhutcm.officemeal.R;
import com.example.comvanphong.fragment.GridFoodFragment;
import com.example.comvanphong.fragment.ListFoodFragment;
import com.example.comvanphong.model.FoodObject;
import com.example.comvanphong.uitls.CommonUtils;

public class MainScreen extends FragmentActivity {

	private ArrayList<FoodObject> listFood;
	private boolean isListView = true;

	ListFoodFragment f1;
	GridFoodFragment f2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_main);
		loadData();

		f1 = new ListFoodFragment(listFood);
		f2 = new GridFoodFragment(listFood);
		CommonUtils.addFragment(getSupportFragmentManager(), f1);
	}

	private void loadData() {

		ArrayList<String> data = new ArrayList<String>();
		data.add(getString(R.string.food_1));
		data.add(getString(R.string.food_2));
		data.add(getString(R.string.food_3));
		data.add(getString(R.string.food_4));
		data.add(getString(R.string.food_5));
		data.add(getString(R.string.food_6));
		data.add(getString(R.string.food_7));
		data.add(getString(R.string.food_8));
		data.add(getString(R.string.food_9));
		data.add(getString(R.string.food_10));
		data.add(getString(R.string.food_11));
		data.add(getString(R.string.food_12));
		data.add(getString(R.string.food_13));
		data.add(getString(R.string.food_14));

		listFood = new ArrayList<FoodObject>();
		for (int i = 0; i < data.size(); i++) {
			FoodObject f = new FoodObject();
			f.id = String.valueOf(i);
			f.name = data.get(i);
			f.image = "";
			f.description = "Thong tin chi tiet mon " + data.get(i);
			listFood.add(f);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_change) {
			if (isListView) {
				CommonUtils.replaceFragment(getSupportFragmentManager(), f2);
				item.setIcon(R.drawable.ic_action_view_as_grid);
				item.setTitle(getString(R.string.action_gird));
			} else {
				CommonUtils.replaceFragment(getSupportFragmentManager(), f1);
				item.setIcon(R.drawable.ic_action_view_as_list);
				item.setTitle(getString(R.string.action_list));
			}
			isListView = !isListView;
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
