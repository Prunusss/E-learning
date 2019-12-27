package com.example.aclass.S_Class;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Activitys.R;
import com.example.aclass.Adapter.NotifyShowAdapter;
import com.example.aclass.S_Class.bean.NotifyBean;

import java.util.ArrayList;
import java.util.List;

public class Notify_Fragment extends Fragment {

    RecyclerView recyclerView;
    private List<NotifyBean> notifyList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_class_notify,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initShowData();
        recyclerView = view.findViewById(R.id.rv_showNotify);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new NotifyShowAdapter(view.getContext(),notifyList));


    }
    private void initShowData() {
        /*
        测试数据
         */
        notifyList.add(new NotifyBean("周老师发布：开始写安卓","2019-12-27 14:00","通知"));
        notifyList.add(new NotifyBean("周老师发布：签到","2019-12-27 14:10","签到"));
        notifyList.add(new NotifyBean("周老师发布：周日安卓答辩","2019-12-27 15:00","签到"));

//        if(showList!=null) {
//            showList.clear();
////            showList.addAll(DBManager.getInstance().getInfoList());
//        }
    }



}
