package dima.mobile.shenkar.com.todolist.app.logic;

import android.content.Context;

import java.util.List;

/**
 * Created by Girya on 11/4/2015.
 */
public class Controller implements IController {

    private  iModel data;

    public Controller(Context context ) {
       data = new Model(context);
    }

    @Override
    public void addTask(Task task) {
        data.addToList(task);
    }

    @Override
    public void deleteTask(String task) {
        data.deleteFromList(task);
    }

    @Override
    public void updateTask(Task task) {
    data.updateElmList(task);
    }

    @Override
    public List<Task> getList() {
        return data.getList();
    }
}
