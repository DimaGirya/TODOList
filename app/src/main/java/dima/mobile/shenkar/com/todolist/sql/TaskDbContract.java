package dima.mobile.shenkar.com.todolist.sql;

/**
 * Created by Girya on 11/20/2015.
 */
import android.provider.BaseColumns;

public  class TaskDbContract {
    public  static final class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String  COLUMN_TASK_STR = "task_str";
        public static final String  COLUMN_TASK_DATA_TIME_STR = "task_data_time_str";
    }
}
