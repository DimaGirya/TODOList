package dima.mobile.shenkar.com.todolist.app.logic;

/**
 * Created by Girya on 11/20/2015.
 */
public class Task  {

    private String taskStr;
    private String dataDone;
    private boolean done;

    public Task(String taskStr) {
        this.taskStr = taskStr;
        this.dataDone = "";
        done = false;
    }

    public String getTaskStr() {
        return taskStr;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDataDone() {
        return dataDone;
    }

    public void setDataDone(String dataDone) {
        this.dataDone = dataDone;
    }

    public void setTaskStr(String taskStr) {
        this.taskStr = taskStr;
    }


}
