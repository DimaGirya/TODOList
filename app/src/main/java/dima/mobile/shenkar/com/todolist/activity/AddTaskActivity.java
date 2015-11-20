package dima.mobile.shenkar.com.todolist.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import dima.mobile.shenkar.com.todolist.R;


public class AddTaskActivity extends Activity implements View.OnClickListener{
    Button submitTask;
    EditText textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        submitTask = (Button)findViewById(R.id.submitTaskButton);
        textView = (EditText)findViewById(R.id.textAddTask);
        submitTask.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String newTask = textView.getText().toString();
        Intent returnIntent = new Intent();
         returnIntent.putExtra("result",newTask);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
