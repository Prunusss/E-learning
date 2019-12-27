package com.example.aclass.T_Class;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.aclass.Activitys.R;
import com.example.aclass.Adapter.QqhAdapter;

import java.util.ArrayList;

public class StuXiaoXi extends AppCompatActivity {

    private ListView qqhlist_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_xiao_xi);
        qqhlist_view=findViewById(R.id.sx_listview);
        ArrayList<Message> arrayOfUsers = new ArrayList<Message>();
        arrayOfUsers.add(new Message("2019-12-26","老师我不会"));
        arrayOfUsers.add(new Message("2019-12-25", "老师我不会"));

        QqhAdapter qqhAdapter = new QqhAdapter(this, arrayOfUsers);

        qqhlist_view.setAdapter(qqhAdapter);
    }
}
