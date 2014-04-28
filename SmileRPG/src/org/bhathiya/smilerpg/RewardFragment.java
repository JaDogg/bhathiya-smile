package org.bhathiya.smilerpg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Gather Tasks (Tasks) Tab Fragment
 * 
 * @author Bhathi
 *
 */
public class RewardFragment extends Fragment {

	private static RewardFragment fragment = null;
	
	static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
		"Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
		"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };
	
	/**
	 * @return static instance
	 */
	public static RewardFragment getInstance() {
		if (fragment == null) {
			fragment = new RewardFragment();
		}
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_rewards, container,false);
		ListView listView = (ListView) rootView.findViewById(R.id.lstRewards);
		RewardArrayAdapter adapter = new RewardArrayAdapter(rootView.getContext(), FRUITS);
		listView.setAdapter((ListAdapter) adapter);
		return rootView;
	}
}
