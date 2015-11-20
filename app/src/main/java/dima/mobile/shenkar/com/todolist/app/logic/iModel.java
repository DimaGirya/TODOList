package dima.mobile.shenkar.com.todolist.app.logic;

import java.util.List;

/**
 * Created by Girya on 11/4/2015.
 */
public interface iModel {
    List<Task> getList();
    void addToList(Task task);
    void deleteFromList(String task);
    void updateElmList(Task task);

}


