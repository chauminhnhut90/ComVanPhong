package com.example.comvanphong.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nhutcm.officemeal.R;
import com.example.comvanphong.model.FoodObject;

public class GridFoodAdapter extends BaseAdapter {

	public ArrayList<FoodObject> data;
	public LayoutInflater inflater;

	public GridFoodAdapter(Context context, ArrayList<FoodObject> data) {
		this.data = data;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public FoodObject getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolderItem viewHolder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.layout_item_grid_food,
					parent, false);
			viewHolder = new ViewHolderItem();

			viewHolder.name = (TextView) convertView.findViewById(R.id.name);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolderItem) convertView.getTag();
		}

		FoodObject food = data.get(position);
		viewHolder.name.setText(food.name);

		return convertView;
	}

	private class ViewHolderItem {
		public TextView name;

	}

}
