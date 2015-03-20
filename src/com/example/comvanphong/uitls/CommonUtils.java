package com.example.comvanphong.uitls;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.comvanphong.R;

public class CommonUtils {

	public static void replaceFragment(FragmentManager manager, Fragment f) {
		FragmentTransaction ft = manager.beginTransaction();
		ft.replace(R.id.rlContainner, f);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		//ft.addToBackStack(null);
		ft.commit();
	}

	public static void addFragment(FragmentManager manager, Fragment f) {
		FragmentTransaction ft = manager.beginTransaction();
		ft.add(R.id.rlContainner, f).commit();
	}

}
