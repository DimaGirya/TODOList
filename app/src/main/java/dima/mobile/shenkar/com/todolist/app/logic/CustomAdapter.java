package dima.mobile.shenkar.com.todolist.app.logic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import dima.mobile.shenkar.com.todolist.R;

/**
 * Created by Girya on 11/4/2015.
 */
public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<Task> items;

    public CustomAdapter(Context context, List<Task> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewRow viewRow;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_row, null);
            TextView taskText = (TextView)convertView.findViewById(R.id.taskText);
            Button buttonDone = (Button)convertView.findViewById(R.id.doneButton);
            viewRow = new ViewRow(taskText,buttonDone);
            convertView.setTag(viewRow);
        }
        else
        {
            viewRow = (ViewRow) convertView.getTag();
        }
        viewRow.textView.setText(items.get(position).getTaskStr());
        return convertView;
        }

}
