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
 * Created by 13982 on 2017/7/9.
 */

public class ReminderAdapter extends ArrayAdapter<ReminderMessage>
{
    private int resourseId;
    public ReminderAdapter(Context context, int textViewResourceId, List<ReminderMessage> object)
    {
        super(context,textViewResourceId,object);
        resourseId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ReminderMessage reminderMessage=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        TextView InnerMessageName=(TextView) view.findViewById(R.id.name);
        TextView InnerMessageDoctName=(TextView) view.findViewById(R.id.doctName);
        TextView InnerMessageNum=(TextView) view.findViewById(R.id.Num);
        TextView InnerMessagestu_tel=(TextView) view.findViewById(R.id.stu_tel);
        TextView InnerMessagedoc_tel=(TextView) view.findViewById(R.id.doc_tel);
        TextView InnerMessageTreatDep=(TextView)view.findViewById(R.id.treatDep);
        TextView InnerMessageARTime=(TextView)view.findViewById(R.id.ARTime);
        InnerMessageName.setText(reminderMessage.getName());
        InnerMessageDoctName.setText(reminderMessage.getDoctName());
        InnerMessageNum.setText(reminderMessage.getNum());
        InnerMessagestu_tel.setText(reminderMessage.getstu_tel());
        InnerMessagedoc_tel.setText(reminderMessage.getdoc_tel());
        InnerMessageTreatDep.setText(reminderMessage.getTreatDep());
        InnerMessageARTime.setText(reminderMessage.getARTime());
        return view;
    }
}
