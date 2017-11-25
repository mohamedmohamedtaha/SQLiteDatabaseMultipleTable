package com.example.manasatt.sqlitedatabasewithmultipletables;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textservice.TextInfo;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MANASATT on 20/05/17.
 */

public class ListViewAdaptor extends BaseAdapter {
    private final LayoutInflater inflater;
    private final ArrayList<Tag>tags;

    public ListViewAdaptor(Context context, ArrayList<Tag> tags) {
        this.inflater = LayoutInflater.from(context);
        this.tags = tags;
    }

    @Override
    public int getCount() {
        return tags.size();
    }

    @Override
    public Object getItem(int position) {
        return tags.get(position);
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

        showIdTag.setText(String.valueOf(tags.get(position).getId()));
        showTag.setText(tags.get(position).getTag_name());
        showDateTag.setText(tags.get(position).getDate());
        return view;
    }
}
