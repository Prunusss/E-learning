package com.example.aclass.S_List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aclass.Activitys.R;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<InfoBean> beanList;
    private ShowViewHolder viewHolder;

    public ShowAdapter(Context mContext, List<InfoBean> beans) {
//    public ShowAdapter(Context mContext, List<InfoBean> beans, OnShowTaskListener listener) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        beanList = beans;
//        this.listener=listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ShowViewHolder(mInflater.inflate(R.layout.recyclerview_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        viewHolder = (ShowViewHolder) holder;
        viewHolder.content.setText(beanList.get(position).getContent());
        viewHolder.title.setText(beanList.get(position).getTitle());
        viewHolder.date.setText(beanList.get(position).getDate());

        if(beanList.get(position).getAttribute()== true) {
            Glide.with(mContext).load(R.drawable.finish).into(viewHolder.icon);
            viewHolder.attribute.setText(mContext.getResources().getString(R.string.tv_mark_no));
            viewHolder.attribute.setBackgroundColor(mContext.getResources().getColor(R.color.textColor));
        } else {
            Glide.with(mContext).load(R.drawable.unfinish).into(viewHolder.icon);
            viewHolder.attribute.setText(mContext.getResources().getString(R.string.tv_mark_done));
            viewHolder.attribute.setBackgroundColor(mContext.getResources().getColor(R.color.Color3));
        }
    }

    @Override
    public int getItemCount() {
        return beanList != null ? beanList.size() : 0;
    }


    public void removeItem(int position) {
        /*
        连接数据库，从数据库中删除
         */
//        DBManager.getInstance().deleteToInfoTable(beanList.get(position).getTitle());
        beanList.remove(position);

    }
    public void markItem(int position){
        if(beanList.get(position).getAttribute()==true) {
         /*
        连接数据库，从数据库中修改
         */
//            DBManager.getInstance().updateToInfoTable(beanList.get(position).getId(),DBConstant.DEFAULT);
            InfoBean bean = new InfoBean(beanList.get(position).getTitle(),beanList.get(position).getContent(),
                 false,beanList.get(position).getDate());
            beanList.remove(position);
            beanList.add(bean);
        } else {
//            DBManager.getInstance().updateToInfoTable(beanList.get(position).getId(),DBConstant.DONE);
            InfoBean bean = new InfoBean(beanList.get(position).getTitle(),beanList.get(position).getContent(),
                    true,beanList.get(position).getDate());
            beanList.remove(position);
            beanList.add(0,bean);
        }
        notifyDataSetChanged();
    }
}
