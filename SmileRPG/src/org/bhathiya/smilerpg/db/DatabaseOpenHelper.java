package org.bhathiya.smilerpg.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * {@link SQLiteOpenHelper} for SmileRPG
 * 
 * @author bhathiya
 * 
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {

	public static final String TABLE_TASKS = "tasks";
	public static final String TABLE_REWARDS = "rewards";
	// columns common
	public static final String COLUMN_ID = "_id";

	public static final String COLUMN_TITLE = "title";
	public static final String COLUMN_SUBTITLE = "subtitle";

	public static final String COLUMN_TEMP = "istemp";
	// columns TABLE_TASKS

	public static final String COLUMN_GPHYSICAL = "physical";
	public static final String COLUMN_GMENTAL = "mental";
	public static final String COLUMN_GSCHOOL = "school";
	public static final String COLUMN_GHOUSE = "house";
	public static final String COLUMN_GSOCIAL = "social";

	public static final String COLUMN_REWARD = "reward";

	// columns TABLE_REWARDS
	public static final String COLUMN_COST = "cost";

	// ---
	private static final String DATABASE_NAME = "smile.db";
	private static final int DATABASE_VERSION = 1;

	private static final String CREATE_TABLE_TASK = "CREATE TABLE "
			+ TABLE_TASKS + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_TITLE
			+ " text not null, " + COLUMN_SUBTITLE + " text not null, "
			+ COLUMN_GPHYSICAL + " integer not null, " + COLUMN_GMENTAL
			+ " integer not null, " + COLUMN_GSCHOOL + " integer not null, "
			+ COLUMN_GHOUSE + " integer not null, " + COLUMN_GSOCIAL
			+ " integer not null, " + COLUMN_REWARD + " integer not null, "
			+ COLUMN_TEMP + " integer not null);";

	private static final String CREATE_TABLE_REWARD = "CREATE TABLE "
			+ TABLE_REWARDS + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_TITLE
			+ " text not null, " + COLUMN_SUBTITLE + " text not null, "
			+ COLUMN_COST + " integer not null, " + COLUMN_TEMP
			+ " integer not null);";

	/**
	 * Default Constructor
	 * 
	 * @param context
	 *            {@link Context}
	 */
	public DatabaseOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_TASK);
		db.execSQL(CREATE_TABLE_REWARD);
		// FIXME : Spell check strings
		db.execSQL("INSERT INTO " + TABLE_TASKS + " (" + COLUMN_TITLE + ","
				+ COLUMN_SUBTITLE + "," + COLUMN_GPHYSICAL + ","
				+ COLUMN_GMENTAL + "," + COLUMN_GSCHOOL + "," + COLUMN_GHOUSE
				+ "," + COLUMN_GSOCIAL + "," + COLUMN_REWARD + ","
				+ COLUMN_TEMP
				+ ") VALUES ('Goto the gym','Exercise',10,-1,0,1,2,10,0);");
		db.execSQL("INSERT INTO " + TABLE_TASKS + " (" + COLUMN_TITLE + ","
				+ COLUMN_SUBTITLE + "," + COLUMN_GPHYSICAL + ","
				+ COLUMN_GMENTAL + "," + COLUMN_GSCHOOL + "," + COLUMN_GHOUSE
				+ "," + COLUMN_GSOCIAL + "," + COLUMN_REWARD + ","
				+ COLUMN_TEMP
				+ ") VALUES ('Ride bicycle for 1hr','Exercise',7,2,0,0,0,8,0);");
		db.execSQL("INSERT INTO " + TABLE_TASKS + " (" + COLUMN_TITLE + ","
				+ COLUMN_SUBTITLE + "," + COLUMN_GPHYSICAL + ","
				+ COLUMN_GMENTAL + "," + COLUMN_GSCHOOL + "," + COLUMN_GHOUSE
				+ "," + COLUMN_GSOCIAL + "," + COLUMN_REWARD + ","
				+ COLUMN_TEMP
				+ ") VALUES ('Take a full body bath','Hygine',4,0,0,0,0,4,0);");
		db.execSQL("INSERT INTO " + TABLE_TASKS + " (" + COLUMN_TITLE + ","
				+ COLUMN_SUBTITLE + "," + COLUMN_GPHYSICAL + ","
				+ COLUMN_GMENTAL + "," + COLUMN_GSCHOOL + "," + COLUMN_GHOUSE
				+ "," + COLUMN_GSOCIAL + "," + COLUMN_REWARD + ","
				+ COLUMN_TEMP
				+ ") VALUES ('Take a bath','Hygine',2,0,0,0,0,2,0);");
		// db.execSQL("INSERT INTO " + TABLE_TASKS +
		// " ("+COLUMN_TITLE+") VALUES ('Take a bath','Hygine',1,0,0,0,0,2,0);");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// re create the database
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS + ";");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_REWARDS + ";");
		onCreate(db);
	}

}
