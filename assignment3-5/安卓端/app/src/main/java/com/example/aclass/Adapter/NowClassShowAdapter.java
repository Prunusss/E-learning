package com.example.aclass.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Activitys.ClassDetail;
import com.example.aclass.Activitys.R;
import com.example.aclass.S_Class.bean.ClassBean;

import java.util.List;


public class NowClassShowAdapter extends RecyclerView.Adapter <NowClassShowAdapter.LinearViewHolder>{
    private Context mContext;
    private List<ClassBean> nowClass;

    public NowClassShowAdapter(Context context, List<ClassBean> beans){
        this.mContext=context;
        nowClass = beans;
    }//构造方法
    @Override
    //返回一个ViewHolder
    //public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    public LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.class_item_layout,parent,false));
    }

    @Override
    //绑定ViewHolder
    //public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    public void onBindViewHolder(LinearViewHolder holder, final int position) {
        holder.className.setText(nowClass.get(position).getClassName());
        holder.classTeacher.setText(nowClass.get(position).getTeacher());
        holder.classDidian.setText(nowClass.get(position).getDidian());
        holder.time.setText(nowClass.get(position).getDate());
        //添加点击监听事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, "调到资源", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, ClassDetail.class);
                mContext.startActivity(intent);
            }
        });


    }
    @Override
    //获取列表长度
    public int getItemCount() {
        return nowClass != null ? nowClass.size() : 0;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        public TextView className;
        public TextView classTeacher;
        public TextView classDidian;
        public TextView time;
//
//        public LinearLayout layout;

        public LinearViewHolder(View itemView) {
            super(itemView);

//        int[] customizedColors = itemView.getResources().getIntArray(R.array.customizedColors);
//        int customizedColor = customizedColors[new Random().nextInt(customizedColors.length)];
//        itemView.setBackgroundColor(customizedColor);

            className = (TextView) itemView.findViewById(R.id.tv_className);
            classTeacher = (TextView) itemView.findViewById(R.id.tv_classTeacher);
            classDidian = (TextView) itemView.findViewById(R.id.tv_tv_classDidian);
            time = (TextView) itemView.findViewById(R.id.tv_date);
//            layout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        }
    }



    public interface OnItemClickLitener {
        void onItemClick(View view, int position);
    }

}

