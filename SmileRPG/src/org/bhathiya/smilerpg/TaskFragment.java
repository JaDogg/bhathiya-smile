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
public class TaskFragment extends Fragment {

	private static TaskFragment fragment = null;
	
	static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
		"Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
		"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };
	
	/**
	 * @return static instance
	 */
	public static TaskFragment getInstance() {
		if (fragment == null) {
			fragment = new TaskFragment();
		}
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_tasks, container,
				false);
		ListView listView = (ListView) rootView.findViewById(R.id.lstTasks);
		TasksArrayAdapter adapter = new TasksArrayAdapter(rootView.getContext(), FRUITS);
		listView.setAdapter((ListAdapter) adapter);
		return rootView;
	}
}
