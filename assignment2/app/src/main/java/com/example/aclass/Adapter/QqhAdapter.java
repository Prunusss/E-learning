package com.example.aclass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.aclass.Activitys.R;
import com.example.aclass.T_Class.Message;

import java.util.ArrayList;

public class QqhAdapter  extends ArrayAdapter<Message> {
    public QqhAdapter(Context context, ArrayList<Message> messages) {
        super(context, 0, messages);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Message bean = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_item, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.nm_name);
        TextView tvTime = (TextView) convertView.findViewById(R.id.nm_time);
        TextView tvNeirong = (TextView) convertView.findViewById(R.id.nm_neirong);
        ImageView im=(ImageView) convertView.findViewById(R.id.nm_tx);

        tvName.setText(bean.time+"      "+bean.name);
        tvNeirong.setText(bean.neirong);
        switch (bean.getIndex()){
            case 0:
                im.setImageResource(R.drawable.contact_head_icon);
                break;
            case 1:
                im.setImageResource(R.drawable.gg);
                break;
            case 2:
                im.setImageResource(R.drawable.qd);
                break;
            case 3:
                im.setImageResource(R.drawable.zy);
                break;
            default:
                im.setImageResource(R.drawable.xx);
                break;
        }


        return convertView;
    }
}
