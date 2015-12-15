package dima.mobile.shenkar.com.todolist.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.DatePicker;

import java.io.Serializable;

import dima.mobile.shenkar.com.todolist.R;


public class AddTaskActivity extends Activity {
    Button submitTask;
    EditText textView;
    EditText dataText;
    EditText timeText;
    int myHour = 0;
    int myMinute = 0;
    int myYear = 2015, myMonth = 12, myDay = 15;
    String time;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        submitTask = (Button) findViewById(R.id.submitTaskButton);
        textView = (EditText) findViewById(R.id.textAddTask);
        dataText = (EditText) findViewById(R.id.dataSetField);
        timeText = (EditText) findViewById(R.id.timeSetField);
    }


    public void onClickSubmitTaskButton(View v) {
        String newTaskString = textView.getText().toString();
        if (newTaskString.equals("")) {
            Toast.makeText(this, "You need to input text in text field", Toast.LENGTH_SHORT).show();
        } else {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("textTask", newTaskString);
            returnIntent.putExtra("timeTask",time);
            returnIntent.putExtra("dataTask", data);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        }
    }

    public void setTime(View view) {
        TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time = hourOfDay + ":" + minute;
                timeText.setText("Time:" + time);
            }
        };
        TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, myHour, myMinute, true);
        tpd.show();
    }

    public void setData(View view) {
        DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                monthOfYear++; // wtf month??
                data =  year + ":" + monthOfYear + ":"+dayOfMonth;
                dataText.setText("Data:" + data);
            }
        };
        DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myYear, myMonth, myDay);
        tpd.show();
    }
}

