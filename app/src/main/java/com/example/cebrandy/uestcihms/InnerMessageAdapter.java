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

public class InnerMessageAdapter extends ArrayAdapter<InnerMessage> {
    private int resourseId;
    public InnerMessageAdapter(Context context, int textViewResourceId, List<InnerMessage> object)
    {
        super(context,textViewResourceId,object);
        resourseId=textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        InnerMessage innerMessage=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourseId,parent,false);
        TextView InnerMessageTitle=(TextView) view.findViewById(R.id.innerMessageTitle);
        TextView InnerMessageContent=(TextView) view.findViewById(R.id.innerMessageContent);
        TextView InnerMessageTime=(TextView)view.findViewById(R.id.innerMessageTime);
        InnerMessageContent.setText(innerMessage.getContent());
        InnerMessageTime.setText(innerMessage.getTime());
        InnerMessageTitle.setText(innerMessage.getTitle());
        return view;
    }
}
