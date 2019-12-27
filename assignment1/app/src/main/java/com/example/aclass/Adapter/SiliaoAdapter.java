package com.example.aclass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.S_Class.Message;
import com.example.aclass.S_Class.ShowMessageView;

import java.util.List;

//import com.example.aclass.S_Class.Taolunqu;

public class SiliaoAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<Message> messageList;
    private ShowMessageView viewHolder;



    public SiliaoAdapter(Context context, List<Message> messages) {

        this.mContext=context;
        mInflater=  LayoutInflater.from(mContext);
        messageList=messages;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        viewHolder=(ShowMessageView) holder;
        viewHolder.time.setText(messageList.get(position).getTime());
        viewHolder.name.setText(messageList.get(position).getName());
        viewHolder.neirong.setText(messageList.get(position).getNeirong());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
