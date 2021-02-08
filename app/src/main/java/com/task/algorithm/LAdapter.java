package com.task.algorithm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LAdapter extends BaseAdapter {

    public ArrayList<String> ST;
    public ArrayList<String> ET;
    public ArrayList<String> Profit;
    LayoutInflater inflater;
    Context context;

    public LAdapter(Context context, ArrayList<String> ST,ArrayList<String> ET,ArrayList<String> Profit)
    {
        this.context = context;
        this.ET = ET;
        this.ST = ST;
        this.Profit = Profit;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return ST.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = inflater.inflate(R.layout.list_add, null);
        TextView Title = v.findViewById(R.id.title);
        Title.setText("New Titile");
        return v;
    }
}