package com.example.cebrandy.uestcihms;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by cebrandy on 2017/11/25.
 */

public class ResultAdapter extends ArrayAdapter<Result> {
    private int resourseId;
    public ResultAdapter(Context context, int textViewResourceId, List<Result> object)
    {
        super(context,textViewResourceId,object);
        resourseId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Result result=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        TextView Name=(TextView) view.findViewById(R.id.name);
        TextView Gailv=(TextView) view.findViewById(R.id.gailv);
        TextView Zhengzhuang=(TextView) view.findViewById(R.id.zhengzhuang);

        Name.setText(result.getName());
        Gailv.setText(result.getGailv());
        Zhengzhuang.setText(result.getZhengzhuang());
        return view;
    }
}
