package com.example.aclass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Activitys.R;
import com.example.aclass.S_Class.bean.ClassBean;

import java.util.List;

public class ClassShowAdapter extends RecyclerView.Adapter <ClassShowAdapter.LinearViewHolder>{

    private Context mContext;
    private List<ClassBean>todayClass ;

    public ClassShowAdapter(Context context, List<ClassBean> beans){
        this.mContext=context;
        todayClass = beans;
    }//构造方法


    @Override
    //返回一个ViewHolder
    //public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    public ClassShowAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.class_item_layout,parent,false));
    }


    @Override
    //绑定ViewHolder
    //public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    public void onBindViewHolder(ClassShowAdapter.LinearViewHolder holder, final int position) {
        holder.className.setText(todayClass.get(position).getClassName());
        holder.classTeacher.setText(todayClass.get(position).getTeacher());
        holder.classDidian.setText(todayClass.get(position).getDidian());
        holder.time.setText(todayClass.get(position).getDate());


    }

    @Override
    //获取列表长度
    //获取列表长度
    public int getItemCount() {
        return todayClass != null ? todayClass.size() : 0;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder {
        public TextView className;
        public TextView classTeacher;
        public TextView classDidian;
        public TextView time;



        public LinearViewHolder(View itemView) {
            super(itemView);

//        int[] customizedColors = itemView.getResources().getIntArray(R.array.customizedColors);
//        int customizedColor = customizedColors[new Random().nextInt(customizedColors.length)];
//        itemView.setBackgroundColor(customizedColor);

            className = (TextView) itemView.findViewById(R.id.tv_className);
            classTeacher = (TextView) itemView.findViewById(R.id.tv_classTeacher);
            classDidian = (TextView) itemView.findViewById(R.id.tv_tv_classDidian);
            time = (TextView) itemView.findViewById(R.id.tv_date);

        }
    }
}

