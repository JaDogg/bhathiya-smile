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
	 * Open the {@link SQLiteDatabase} db by getting a writable database from
	 * {@link DatabaseOpenHelper}
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
	 * 
	 * @param task
	 *            a {@link TaskDetails} object
	 * @return new id (auto increment)
	 */
	public long createTask(TaskDetails task) {

		ContentValues values = new ContentValues();
		values.put(DatabaseOpenHelper.COLUMN_TITLE, task.getTitle());
		values.put(DatabaseOpenHelper.COLUMN_SUBTITLE, task.getSubTitle());
		values.put(DatabaseOpenHelper.COLUMN_GPHYSICAL, task.getGainPhysical());
		values.put(DatabaseOpenHelper.COLUMN_GMENTAL, task.getGainMental());
		values.put(DatabaseOpenHelper.COLUMN_GSCHOOL, task.getGainSchool());
		values.put(DatabaseOpenHelper.COLUMN_GHOUSE, task.getGainHouse());
		values.put(DatabaseOpenHelper.COLUMN_GSOCIAL, task.getGainSocial());
		values.put(DatabaseOpenHelper.COLUMN_REWARD, task.getReward());
		values.put(DatabaseOpenHelper.COLUMN_TEMP, task.isTemporary());

		long id = db.insert(DatabaseOpenHelper.TABLE_TASKS, null, values);

		return id;
	}

	/**
	 * update Task
	 * 
	 * @param task
	 *            a {@link TaskDetails} object
	 */
	public void updateTask(TaskDetails task) {
		ContentValues values = new ContentValues();
		values.put(DatabaseOpenHelper.COLUMN_TITLE, task.getTitle());
		values.put(DatabaseOpenHelper.COLUMN_SUBTITLE, task.getSubTitle());
		values.put(DatabaseOpenHelper.COLUMN_GPHYSICAL, task.getGainPhysical());
		values.put(DatabaseOpenHelper.COLUMN_GMENTAL, task.getGainMental());
		values.put(DatabaseOpenHelper.COLUMN_GSCHOOL, task.getGainSchool());
		values.put(DatabaseOpenHelper.COLUMN_GHOUSE, task.getGainHouse());
		values.put(DatabaseOpenHelper.COLUMN_GSOCIAL, task.getGainSocial());
		values.put(DatabaseOpenHelper.COLUMN_REWARD, task.getReward());
		values.put(DatabaseOpenHelper.COLUMN_TEMP, task.isTemporary());

		db.update(DatabaseOpenHelper.TABLE_TASKS, values, "WHERE _id = ?",
				new String[] { task.getIdAsString() });
	}

	/**
	 * delete a task
	 * 
	 * @param task
	 *            a {@link TaskDetails} object
	 */
	public void deleteTask(TaskDetails task) {
		db.delete(DatabaseOpenHelper.TABLE_TASKS, "WHERE _id = ?",
				new String[] { task.getIdAsString() });
	}
	/**
	 * Create a {@link TaskDetails} object from cursor
	 * @param cursor a {@link Cursor}
	 * @return {@link TaskDetails}
	 */
	public static TaskDetails cursorToTask(Cursor cursor) {
		TaskDetails task = new TaskDetails(""); // FIXME : need to change the
												// construct
		task.setId(cursor.getLong(0)); // FIXME : use predefined Constants
		task.setTitle(cursor.getString(1));
		task.setSubTitle(cursor.getString(2));
		task.setGainPhysical(cursor.getInt(3));
		task.setGainMental(cursor.getInt(4));
		task.setGainSchool(cursor.getInt(5));
		task.setGainHouse(cursor.getInt(6));
		task.setGainSocial(cursor.getInt(7));
		task.setReward(cursor.getInt(8));
		task.setTemporary(cursor.getInt(9) != 0); // FIXME: Create a util class
													// with int to boolean and
													// boolean to int
		return task;
	}

	/**
	 * get a cursor for all the tasks
	 * 
	 * @return {@link Cursor}
	 */
	public Cursor getTasksCursor() {

		String sql = "SELECT * FROM " + DatabaseOpenHelper.TABLE_TASKS + ";";
		if (db == null) {
			open();
		}
		return db.rawQuery(sql, null);
	}

}
