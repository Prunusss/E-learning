package com.example.aclass.Activitys;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Adapter.ZiyuanShowAdapter;
import com.example.aclass.S_Me.Ziyuan_bean;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class ziyuanqu extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    private List<Ziyuan_bean> ziyuanList=new ArrayList<>();
    @Override
    public void onClick(View v) {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ziyuanqu);
        initView();
    }
    private void initView() {
        initShowData();
        recyclerView = findViewById(R.id.rv_showZiyuan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ZiyuanShowAdapter(this,ziyuanList));
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("资源区");
    }

    private void initShowData() {
        /*
        测试数据
         */
        ziyuanList.add(new Ziyuan_bean("安卓ppt","2019-12-27 14:00"));
        ziyuanList.add(new Ziyuan_bean("FirstDemo","2019-12-27 14:10"));
        ziyuanList.add(new Ziyuan_bean("SecondDemo","2019-12-27 15:00"));

//        if(showList!=null) {
//            showList.clear();
////            showList.addAll(DBManager.getInstance().getInfoList());
//        }
    }

}
