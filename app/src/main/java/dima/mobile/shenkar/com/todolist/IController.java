package dima.mobile.shenkar.com.todolist;

import java.util.List;

/**
 * Created by Girya on 11/4/2015.
 */
public interface IController {
    void addTask(String task);
    void deleteTask(String task);
    void updateTask(String task);
    List<String> getList();
}
