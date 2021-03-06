package dima.mobile.shenkar.com.todolist.app.logic;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import dima.mobile.shenkar.com.todolist.sql.DataAccess;
import dima.mobile.shenkar.com.todolist.sql.iDataAccess;

/**
 * Created by Girya on 11/4/2015.
 */
public class Controller implements IController {    // need? If the DataAccess is not a singeltone its the same!

    private iDataAccess data;
    List<Task> taskList;
    public Controller(Context context)
    {
        data = DataAccess.getInstatnce(context);
        taskList = getList();
    }

    public iDataAccess getDataAccess() {
        return data;
    }

    @Override
    public void addTask(Task task) {
        data.addTask(task);
     //   taskList.add(task);
    }

    @Override
    public void deleteTask(String task) {
        data.deleteTask(task);
    }

    @Override
    public void updateTask(Task task) {
    data.updateTask(task);
    }

    @Override
    public List<Task> getList() {

        return data.getList();
    }
}
