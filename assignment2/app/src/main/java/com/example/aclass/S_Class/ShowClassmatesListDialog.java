package com.example.aclass.S_Class;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.aclass.Activitys.R;
import com.example.aclass.Adapter.StuListAdapter;
import com.example.aclass.S_Class.bean.StuInfoBean;
import com.example.aclass.S_Course.Course;
import com.example.aclass.S_Course.OnCreateTaskListener;
import com.example.aclass.S_Course.TabCourse_S_Fragment;

import java.util.ArrayList;


public class ShowClassmatesListDialog extends DialogFragment {


    private OnCreateTaskListener listener;
    View view;
    ArrayList<StuInfoBean> stulist;
    public ShowClassmatesListDialog(ArrayList<StuInfoBean> stulist){
        this.stulist=stulist;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_classmates_list_dialog, container);

        Button backButton = (Button) view.findViewById(R.id.close_list);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        StuListAdapter usersAdapter = new StuListAdapter(view.getContext(), stulist);
        ListView listView = view.findViewById(R.id.classmates_view);
        listView.setAdapter(usersAdapter);
        return view;
    }

    public void setOnCreateTaskListener(OnCreateTaskListener listener) {
        this.listener=listener;
    }
}
