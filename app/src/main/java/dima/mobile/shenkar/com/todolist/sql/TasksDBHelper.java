package dima.mobile.shenkar.com.todolist.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Girya on 11/20/2015.
 */
public class TasksDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tasks.db";

    public TasksDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_LOCATION_TABLE = "CREATE TABLE "
                + TaskDbContract.TaskEntry.TABLE_NAME + " (" + TaskDbContract.TaskEntry._ID
                + " INTEGER PRIMARY KEY," + TaskDbContract.TaskEntry.COLUMN_TASK_STR
                + " TEXT NOT NULL  UNIQUE ON CONFLICT REPLACE)";
        db.execSQL(SQL_CREATE_LOCATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TaskDbContract.TaskEntry.TABLE_NAME);
        onCreate(db);
    }
}
