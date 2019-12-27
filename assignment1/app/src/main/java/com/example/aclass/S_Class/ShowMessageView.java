package com.example.aclass.S_Class;

import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Activitys.R;

public class ShowMessageView extends RecyclerView.ViewHolder{

    public TextView time;
    public TextView name;
    public TextView neirong;
    public ShowMessageView(@NonNull View itemView) {
        super(itemView);
        time=(TextView)itemView.findViewById(R.id.mtime);
        name=(TextView)itemView.findViewById(R.id.mname);
        neirong=(TextView)itemView.findViewById(R.id.mcontent);
    }
}
