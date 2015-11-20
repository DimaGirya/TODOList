package dima.mobile.shenkar.com.todolist.app.logic;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Girya on 11/4/2015.
 */
public class Model  {
    Context context;
    private List<Task> taskList;
    public Model(Context context) {
        this.context =  context;
      String [] strTask = new String[]{"Hw android","Hw Linux","Hw Web","Hw sql","Hw networking","Go sleep","Get Milk", "Clean my house", "Find a job","Extra task 1","Extra task 2","Extra task 3","Extra task 4","Extra task 5","Extra task 6"};
        Task [] tasks = new Task[strTask.length];

        taskList = new ArrayList<Task>();
        for(int i = 0; i< tasks.length;i++){
            tasks[i] = new Task(strTask[i]);
            taskList.add(tasks[i]);
        }
 //       java.util.Collections.sort(taskList);
    }


    public List<Task> getList() {

        return taskList;
    }


    public void addToList(Task task) {
        taskList.add(task);
      //  java.util.Collections.sort(taskList);
    }


    public void deleteFromList(String task) {
        for(int i=0;i<taskList.size();i++)
        {
            if(taskList.get(i).getTaskStr().equals(task)) {
                Toast.makeText(context,"Task done:"+taskList.get(i).getTaskStr().toString(),Toast.LENGTH_LONG).show();
                taskList.remove(i);
                break;
            }
        }
       // java.util.Collections.sort(taskList);
    }


    public void updateElmList(Task task) {    // not ready?

    }
}
