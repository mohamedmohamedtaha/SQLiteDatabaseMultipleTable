package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListTAGActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    DatabaseHelper db;
    ListView listViewTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tag);
        db = new DatabaseHelper(getApplicationContext());

        //Cancel Notification
        NotificationManager nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        nm.cancel(1);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*
        Tag tag=(Tag)parent.getItemAtPosition(position);
        Intent intent = new Intent(ListTAGActivity.this,)*/

    }

    @Override
    protected void onResume() {
        listViewTag =(ListView)findViewById(R.id.listViewTAG);
        db = new DatabaseHelper(this);
        ArrayList<Tag> tags = db.getAllTags();
        for (int i = 0;i<tags.size();i++){
            Tag tag = tags.get(i);
        }
        listViewTag.setAdapter(new ListViewAdaptor(this,tags));

        listViewTag.setOnItemClickListener(this);
        super.onResume();
    }
}
