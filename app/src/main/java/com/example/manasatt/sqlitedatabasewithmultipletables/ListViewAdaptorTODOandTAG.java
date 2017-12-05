package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MANASATT on 20/05/17.
 */

public class ListViewAdaptorTODOandTAG extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<Todo>todos;

    public ListViewAdaptorTODOandTAG(Context context,ArrayList<Todo> todos) {
        this.inflater =LayoutInflater.from(context);
        this.todos = todos;
    }

    @Override
    public int getCount() {
        return todos.size();
    }

    @Override
    public Object getItem(int position) {
        return todos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =inflater.inflate(R.layout.row_tag,parent,false);
        TextView showIdTag=(TextView)view.findViewById(R.id.showIdTag);
        TextView showTag=(TextView)view.findViewById(R.id.showTag);
        TextView showDateTag=(TextView)view.findViewById(R.id.showDateTag);
        showIdTag.setText(String.valueOf(todos.get(position).getId()));
        showTag.setText(todos.get(position).getNote());
        showDateTag.setText(todos.get(position).getTag_name());

        return view;
    }



















}
