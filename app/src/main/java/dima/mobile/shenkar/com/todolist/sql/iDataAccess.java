package dima.mobile.shenkar.com.todolist.sql;

import java.util.List;

import dima.mobile.shenkar.com.todolist.app.logic.Task;

/**
 * Created by Girya on 11/4/2015.
 */
public interface iDataAccess {
    List<Task> getList();
    void addTask(Task task);
    void deleteTask(String task);
    void updateTask(Task task);

}


