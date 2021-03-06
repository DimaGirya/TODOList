package dima.mobile.shenkar.com.todolist.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import dima.mobile.shenkar.com.todolist.app.logic.Controller;
import dima.mobile.shenkar.com.todolist.sql.iDataAccess;
import dima.mobile.shenkar.com.todolist.app.logic.CustomAdapter;
import dima.mobile.shenkar.com.todolist.app.logic.IController;
import dima.mobile.shenkar.com.todolist.R;
import dima.mobile.shenkar.com.todolist.app.logic.Task;
import dima.mobile.shenkar.com.todolist.sql.DataAccess;

public class MainActivity extends Activity {
    private Controller controller;
    private CustomAdapter adapter;
    private Button createTaskButton;
    private Button doneButton;
    private ListView listView;
    final int REQUEST_CREATE_TASK = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller =  new Controller(this);
        createTaskButton = (Button) findViewById(R.id.addTaskButton);
        listView = (ListView) findViewById(R.id.listTask);
        doneButton = (Button) findViewById(R.id.doneButton);
        adapter = new CustomAdapter(this, controller.getList(),controller.getDataAccess());
        listView.setAdapter(adapter);
    }

    public void onClickAddTask(View v) {
        Intent intent = new Intent(this,AddTaskActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
   if(requestCode == REQUEST_CREATE_TASK){
    if(resultCode==Activity.RESULT_OK){
        String textTask=data.getStringExtra("textTask");
        String timeTask=data.getStringExtra("timeTask");
        String dataTask=data.getStringExtra("dataTask");
        Toast.makeText(this,"Task added: "+textTask+" Data:"+dataTask+" Time: "+timeTask, Toast.LENGTH_SHORT).show();
        Task task = new Task(textTask);
        controller.addTask(task);
        adapter.notifyDataSetChanged();
    }
       else {
        Toast.makeText(this,"Task not added", Toast.LENGTH_SHORT).show();
    }
   }
        else{
       Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
   }
}

    public void OnClickDone(View v) {
        View view = (View) v.getParent();
        TextView taskDone = (TextView)view.findViewById(R.id.taskText);
        controller.deleteTask(taskDone.getText().toString());
        adapter.notifyDataSetChanged();
    }
}
