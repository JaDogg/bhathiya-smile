package org.bhathiya.smilerpg.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * DataAccess Class
 * 
 * Create a new object & then call open() to use
 * 
 * @author bhathiya
 * 
 */
public class DataAccess {
	private final DatabaseOpenHelper helper;
	private SQLiteDatabase db = null;

	public DataAccess(Context context) {
		helper = new DatabaseOpenHelper(context);
	}

	/**
	 * Open the {@link SQLiteDatabase} db by getting 
	 * a writable database from {@link DatabaseOpenHelper}
	 */
	public void open() {
		try {
			db = helper.getWritableDatabase();
		} catch (Exception e) {

			Log.e(DataAccess.class.getName(), e.getMessage());
		}
	}
	/**
	 * close {@link SQLiteDatabase}
	 */
	public void close() {
		if (db != null) {
			db.close();
		}
	}
	/**
	 * Create a task
	 * @param task a {@link TaskDetails} object
	 * @return new id (auto increment)
	 */
	public long createTask(TaskDetails task) {

		ContentValues values = new ContentValues();
		values.put(DatabaseOpenHelper.COLUMN_TITLE, task.getTitle());

		long id = db.insert(DatabaseOpenHelper.TABLE_TASKS, null, values);

		return id;
	}
	/**
	 * get cursor
	 * @return {@link Cursor}
	 */
	public Cursor getTasksCursor() {

		String sql = "SELECT * FROM " + DatabaseOpenHelper.TABLE_TASKS;
		if (db == null) {
			open();
		}
		return db.rawQuery(sql, null);
	}

}
