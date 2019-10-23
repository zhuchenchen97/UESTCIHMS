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
 * Created by cebrandy on 2017/11/20.
 */

public class BaoGaoAdapter extends ArrayAdapter<BaoGao> {
    private int resourseId;
    public BaoGaoAdapter(Context context, int textViewResourceId, List<BaoGao> object)
    {
        super(context,textViewResourceId,object);
        resourseId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BaoGao baogao=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        TextView stu_name=(TextView) view.findViewById(R.id.stu_name);
        TextView stu_num=(TextView) view.findViewById(R.id.stu_num);
        TextView doc_name=(TextView) view.findViewById(R.id.doc_name);
        TextView symptom=(TextView) view.findViewById(R.id.symptom);
        TextView diagnosis=(TextView) view.findViewById(R.id.diagnosis);
        TextView time=(TextView) view.findViewById(R.id.time);
        stu_name.setText(baogao.getstu_name());
        stu_num.setText(baogao.getstu_num());
        doc_name.setText(baogao.getdoc_name());
        symptom.setText(baogao.getsymptom());
        diagnosis.setText(baogao.getdiagnosis());
        time.setText(baogao.gettime());

        return view;
    }
}
