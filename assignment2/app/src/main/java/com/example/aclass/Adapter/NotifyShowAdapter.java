package com.example.aclass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Activitys.R;
import com.example.aclass.S_Class.bean.NotifyBean;

import java.util.List;


public class NotifyShowAdapter extends RecyclerView.Adapter <NotifyShowAdapter.LinearViewHolder>{
    private Context mContext;
    private List<NotifyBean> notifyList;

    public NotifyShowAdapter(Context context, List<NotifyBean> beans){
        this.mContext=context;
        notifyList = beans;
    }//构造方法
    @Override
    //返回一个ViewHolder
    //public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    public NotifyShowAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.notify_item,parent,false));
    }

    @Override
    //绑定ViewHolder
    //public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    public void onBindViewHolder(NotifyShowAdapter.LinearViewHolder holder, final int position) {
        holder.title.setText(notifyList.get(position).getTitle());
        holder.time.setText(notifyList.get(position).getTime());
        if(notifyList.get(position).getType()=="签到")
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "向后端发送请求~", Toast.LENGTH_SHORT).show();
            }
        });



    }
    @Override
    //获取列表长度
    public int getItemCount() {
        return notifyList != null ? notifyList.size() : 0;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView time;
        public LinearViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            time = (TextView) itemView.findViewById(R.id.tv_time);

        }
    }



    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

}

