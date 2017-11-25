package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListTodoTagActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    DatabaseHelper db;
    ListView listViewTodoTag;
    String intentSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_todo_tag);

          intentSpinner=getIntent().getExtras().getString("getValueSpinner");
    }

    @Override
    protected void onResume() {
        listViewTodoTag=(ListView)findViewById(R.id.listViewTodoTag);
        db=new DatabaseHelper(this);
        ArrayList<Todo> todos = db.getAllToDosByTag(intentSpinner);
        for (int i=0;i<todos.size();i++){
            Todo todo=todos.get(i);
        }
        listViewTodoTag.setAdapter(new ListViewAdaptorTODOandTAG(this,todos));
        listViewTodoTag.setOnItemClickListener(this);
        super.onResume();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
