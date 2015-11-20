package dima.mobile.shenkar.com.todolist.app.logic;

/**
 * Created by Girya on 11/20/2015.
 */
public class Task {

    private String taskStr;
    private boolean done;

    public Task(String taskStr) {
        this.taskStr = taskStr;
        done = false;
    }

    public String getTaskStr() {
        return taskStr;
    }

    public void setTaskStr(String taskStr) {
        this.taskStr = taskStr;
    }

}
