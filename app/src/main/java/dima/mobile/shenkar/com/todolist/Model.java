package dima.mobile.shenkar.com.todolist;

import android.content.Context;
import android.widget.Toast;
import dima.mobile.shenkar.com.todolist.MainActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Girya on 11/4/2015.
 */
public class Model implements iModel {
    Context context;
    private List<String> taskList;
    public Model(Context context) {
        this.context =  context;
     String [] tasks = new String[]{"Hw android","Hw Linux","Hw Web","Hw sql","Hw networking","Go sleep","Get Milk", "Clean my house", "Find a job","Extra task 1","Extra task 2","Extra task 3","Extra task 4","Extra task 5","Extra task 6"};
        taskList = new ArrayList<String>();
        for(int i = 0; i< tasks.length;i++){
            taskList.add(tasks[i]);
        }
        java.util.Collections.sort(taskList);
    }

    @Override
    public List<String> getList() {

        return taskList;
    }

    @Override
    public void addToList(String task) {
        taskList.add(task);
      //  java.util.Collections.sort(taskList);
    }

    @Override
    public void deleteFromList(String task) {
        for(int i=0;i<taskList.size();i++)
        {
            if(taskList.get(i).equals(task)) {
                Toast.makeText(context,"Task done:"+taskList.get(i).toString(),Toast.LENGTH_LONG).show();
                taskList.remove(i);
                break;
            }
        }
       // java.util.Collections.sort(taskList);
    }

    @Override
    public void updateElmList(String task) {    // not ready?

    }
}
