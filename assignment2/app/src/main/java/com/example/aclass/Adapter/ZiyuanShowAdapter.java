package com.example.aclass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Activitys.R;
import com.example.aclass.S_Me.Ziyuan_bean;

import java.util.List;

public class ZiyuanShowAdapter extends RecyclerView.Adapter <ZiyuanShowAdapter.LinearViewHolder>{
    private Context mContext;
    private List<Ziyuan_bean> ziyuanList;

    public ZiyuanShowAdapter(Context context, List<Ziyuan_bean> beans){
        this.mContext=context;
        ziyuanList = beans;
    }//构造方法
    @Override
    //返回一个ViewHolder
    //public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    public ZiyuanShowAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.ziyuan_item,parent,false));
    }

    @Override
    //绑定ViewHolder
    //public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    public void onBindViewHolder(ZiyuanShowAdapter.LinearViewHolder holder, final int position) {
        holder.title.setText(ziyuanList.get(position).getTitle());
        holder.time.setText(ziyuanList.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "向后端发送请求~", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btn_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "下载文件写在这！~", Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    //获取列表长度
    public int getItemCount() {
        return ziyuanList != null ? ziyuanList.size() : 0;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView time;
        public Button btn_down;
        public LinearViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            btn_down=(Button)itemView.findViewById(R.id.tv_queren_down);
        }
    }



    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

}

