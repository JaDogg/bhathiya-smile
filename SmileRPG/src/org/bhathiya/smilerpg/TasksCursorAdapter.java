package org.bhathiya.smilerpg;

import org.bhathiya.smilerpg.db.DataAccess;
import org.bhathiya.smilerpg.db.TaskDetails;
import org.bhathiya.util.BhathiUtil;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TasksCursorAdapter extends CursorAdapter {

	public TasksCursorAdapter(Context context, Cursor c, boolean autoRequery) {
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
		TextView title = (TextView) view.findViewById(R.id.txtTaskName);
		TextView subTitle = (TextView) view.findViewById(R.id.txtTaskType);
		TextView gainPhysical = (TextView) view
				.findViewById(R.id.txtLstPhysical);
		TextView gainMental = (TextView) view.findViewById(R.id.txtLstMental);
		TextView gainSchool = (TextView) view.findViewById(R.id.txtLstSchool);
		TextView gainHouse = (TextView) view.findViewById(R.id.txtLstHouse);
		TextView gainSocial = (TextView) view.findViewById(R.id.txtLstSocial);

		TaskDetails task = DataAccess.cursorToTask(cursor);
		title.setText(task.getTitle());
		subTitle.setText(task.getSubTitle());
		gainPhysical.setText(BhathiUtil.intToPlusOrMinusString(task
				.getGainPhysical()));
		gainMental.setText(BhathiUtil.intToPlusOrMinusString(task
				.getGainMental()));
		gainSchool.setText(BhathiUtil.intToPlusOrMinusString(task
				.getGainSchool()));
		gainHouse.setText(BhathiUtil.intToPlusOrMinusString(task
				.getGainHouse()));
		gainSocial.setText(BhathiUtil.intToPlusOrMinusString(task
				.getGainSocial()));

	}

}