package com.example.aclass.Adapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.example.aclass.S_Class.bean.StuInfoBean;
import com.example.aclass.S_List.ShowViewHolder;

import java.util.List;

public class StuListAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<StuInfoBean> beanList;
    private ShowViewHolder viewHolder;
    public StuListAdapter(Context mContext, List<StuInfoBean> beans) {
//    public ShowAdapter(Context mContext, List<InfoBean> beans, OnShowTaskListener listener) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        beanList = beans;
//        this.listener=listener;
    }
}
