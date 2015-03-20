package com.example.comvanphong.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodObject implements Parcelable {

	public String id;
	public String name;
	public String image;
	public String description;

	public FoodObject() {
		this.id = "";
		this.name = "";
		this.image = "";
		this.description = "";
	}

	public FoodObject(Parcel in) {
		this.id = in.readString();
		this.name = in.readString();
		this.image = in.readString();
		this.description = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.id);
		dest.writeString(this.name);
		dest.writeString(this.image);
		dest.writeString(this.description);
	}

	public static final Parcelable.Creator<FoodObject> CREATOR = new Parcelable.Creator<FoodObject>() {
		public FoodObject createFromParcel(Parcel in) {
			return new FoodObject(in);
		}

		public FoodObject[] newArray(int size) {
			return new FoodObject[size];
		}
	};
}
