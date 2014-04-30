package org.bhathiya.smilerpg.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * {@link SQLiteOpenHelper} for SmileRPG
 * @author bhathiya
 *
 */
public class DatabaseOpenHelper extends SQLiteOpenHelper {
		
	  public static final String TABLE_TASKS = "tasks";
	  public static final String TABLE_REWARDS = "rewards";
	  //columns
	  public static final String COLUMN_ID = "_id";
	  
	  public static final String COLUMN_TITLE = "title";
	  public static final String COLUMN_SUBTITLE = "subtitle";
	  
	  public static final String COLUMN_TEMP = "istemp";
	  
	  
	  public static final String COLUMN_GPHYSICAL = "physical";
	  public static final String COLUMN_GMENTAL = "mental";
	  public static final String COLUMN_GSCHOOL = "school";
	  public static final String COLUMN_GHOUSE = "house";
	  public static final String COLUMN_GSOCIAL = "social";
	  
	  public static final String COLUMN_REWARD = "reward";
	  public static final String COLUMN_COST = "cost";
	  
	  //--
	  private static final String DATABASE_NAME = "smile.db";
	  private static final int DATABASE_VERSION = 1;

	  private static final String CREATE_TABLE_TASK = "CREATE TABLE "
			  + TABLE_TASKS + "(" + COLUMN_ID
			  + " integer primary key autoincrement, " + COLUMN_TITLE
			  + " text    , " + COLUMN_SUBTITLE
			  + " text    , "  + COLUMN_GPHYSICAL
			  + " integer , " + COLUMN_GMENTAL
			  + " integer , " + COLUMN_GSCHOOL
			  + " integer , " + COLUMN_GHOUSE
			  + " integer , " + COLUMN_GSOCIAL
			  + " integer , " + COLUMN_REWARD
			  + " integer , " + COLUMN_TEMP
			  + " integer );";
	  
	  private static final String CREATE_TABLE_REWARD = "CREATE TABLE "
			  + TABLE_REWARDS + "(" + COLUMN_ID
			  + " integer primary key autoincrement, " + COLUMN_TITLE
			  + " text not null, " + COLUMN_SUBTITLE
			  + " text not null, " + COLUMN_COST
			  + " integer not null, " + COLUMN_TEMP
			  + " integer not null);";
	/**
	 * Default Constructor  
	 * @param context Context
	 */
	public DatabaseOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_TASK);
		db.execSQL(CREATE_TABLE_REWARD);	
		db.execSQL("INSERT INTO " + TABLE_TASKS + " ("+COLUMN_TITLE+") VALUES ('First Taska');");
		db.execSQL("INSERT INTO " + TABLE_TASKS + " ("+COLUMN_TITLE+") VALUES ('Second Taska');");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// re create the database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REWARDS + ";");
        onCreate(db); 
	}

}
