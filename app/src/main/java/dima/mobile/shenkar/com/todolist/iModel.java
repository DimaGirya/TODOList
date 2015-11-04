package dima.mobile.shenkar.com.todolist;

import java.util.List;

/**
 * Created by Girya on 11/4/2015.
 */
public interface iModel {
    List<String> getList();
    void addToList(String task);
    void deleteFromList(String task);
    void updateElmList(String task);

}


