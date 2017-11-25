package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListTODOActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    DatabaseHelper db;
    ListView listViewTODO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_todo);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected void onResume() {
        listViewTODO =(ListView)findViewById(R.id.listViewTODO);
        db = new DatabaseHelper(this);
        ArrayList<Todo> todos = db.getAllToDos();
        for (int i = 0;i<todos.size();i++){
            Todo todo = todos.get(i);
        }
        listViewTODO.setAdapter(new ListViewAdaptorTODO(this,todos));

        listViewTODO.setOnItemClickListener(this);
        super.onResume();
    }
}
