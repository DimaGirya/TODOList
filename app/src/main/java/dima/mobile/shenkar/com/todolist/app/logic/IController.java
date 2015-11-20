package dima.mobile.shenkar.com.todolist.app.logic;

import java.util.List;

/**
 * Created by Girya on 11/4/2015.
 */
public interface IController {
    void addTask(Task task);
    void deleteTask(String task);
    void updateTask(Task task);
    List<Task> getList();
}
