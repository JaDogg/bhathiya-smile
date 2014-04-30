package org.bhathiya.smilerpg;



import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
 
public class TasksArrayAdapter extends CursorAdapter {
	


	public TasksArrayAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);

	}
	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 
		View rowView = inflater.inflate(R.layout.list_task, parent, false);
		return rowView;
	}
	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView a = (TextView) view.findViewById(R.id.txtTaskName);
		a.setText(cursor.getString(1));
		
	}
 

}