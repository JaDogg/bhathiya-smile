package org.bhathiya.smilerpg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Gather Tasks (Tasks) Tab Fragment
 * 
 * @author Bhathi
 *
 */
public class StatusFragment extends Fragment {

	private static StatusFragment fragment = null;
		
	/**
	 * @return static instance
	 */
	public static StatusFragment getInstance() {
		if (fragment == null) {
			fragment = new StatusFragment();
		}
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_status , container,
				false);

		return rootView;
	}
}
