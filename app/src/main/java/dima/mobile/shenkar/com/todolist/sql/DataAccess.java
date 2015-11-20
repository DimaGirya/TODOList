package dima.mobile.shenkar.com.todolist.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dima.mobile.shenkar.com.todolist.app.logic.Task;

/**
 * Created by Girya on 11/20/2015.
 */
public class DataAccess implements iDataAccess {
    private static final String TAG = "TODOLog";
    SQLiteDatabase database;
    private static DataAccess instance;
    private Context context;
    private TasksDBHelper dbHelper;
    private String[] taskColumns = { TaskDbContract.TaskEntry._ID,TaskDbContract.TaskEntry.COLUMN_TASK_STR};

    private DataAccess(Context context) {	//private constructor(singleton)
        this.context = context;
        dbHelper = new TasksDBHelper(this.context);
    }

    public static DataAccess getInstatnce(Context context) {
        if (instance == null)
            instance = new DataAccess(context);
        return instance;
    }
    @Override
    public void addTask(Task task) {
        database = null;
        try {
            database = dbHelper.getReadableDatabase();
            if (task == null) {
                return; //need log
            }
            ContentValues values = new ContentValues();
            values.put(TaskDbContract.TaskEntry.COLUMN_TASK_STR, task.getTaskStr());
            long insertId = database.insert(TaskDbContract.TaskEntry.TABLE_NAME, null, values);
            Cursor cursor = database.query(TaskDbContract.TaskEntry.TABLE_NAME, taskColumns,
                    TaskDbContract.TaskEntry._ID + " = " + insertId, null, null, null, null);
            cursor.moveToFirst();
            cursor.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (database != null) {
                database.close();
            }
        }
    }

    @Override
    public void deleteTask(String task) {   // need to change to Task task
         database = null;
        try {
            database = dbHelper.getReadableDatabase();
            Log.d(TAG,"Deleting from data base");
            database.delete(TaskDbContract.TaskEntry.TABLE_NAME, TaskDbContract.TaskEntry.COLUMN_TASK_STR + " = " + "'" + task + "'", null);
            Toast.makeText(context, "Task done:" +task, Toast.LENGTH_LONG).show();
            Log.d(TAG, "Delete done");
        }
        catch (Exception  e){
            Log.d(TAG, "Error:",e);
        }
        finally {
            if(database != null){
                database.close();
            }
        }
    }

    @Override
    public List<Task> getList() {
        try {
            database = dbHelper.getReadableDatabase();
            List<Task> taskList = new ArrayList<Task>();

            Cursor cursor = database.query(TaskDbContract.TaskEntry.TABLE_NAME, taskColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Task task = getTaskFromCursor(cursor);
                taskList.add(task);
                cursor.moveToNext();
            }
           // java.util.Collections.sort(taskList);
            cursor.close();
            return taskList;
        } finally {
            if (database != null) {
                database.close();
            }
        }
    }

    private Task getTaskFromCursor(Cursor cursor) {
        String taskStr = cursor.getString(cursor.getColumnIndex(TaskDbContract.TaskEntry.COLUMN_TASK_STR));
        Task task = new Task(taskStr);
        return task;
    }

    @Override
    public void updateTask(Task task) {

    }


}
