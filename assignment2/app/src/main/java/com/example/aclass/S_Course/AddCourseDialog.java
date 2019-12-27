package com.example.aclass.S_Course;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.aclass.Activitys.R;
import com.example.aclass.T_Course.TabCourse_T_Fragment;


public class AddCourseDialog extends DialogFragment {

    private EditText editText;
    private EditText editText2;
    private TextView TVSubmit;
    private OnCreateTaskListener listener;
    View view;
    TabCourse_S_Fragment course_S_fragment;
    TabCourse_T_Fragment coursefragment;
    public AddCourseDialog(TabCourse_S_Fragment coursefragment){
        this.course_S_fragment=coursefragment;
    }
    public AddCourseDialog(TabCourse_T_Fragment coursefragment){
        this.coursefragment=coursefragment;
    }
    public void passfragment(TabCourse_S_Fragment fragment){
        course_S_fragment=fragment;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_course, container);
        final EditText inputCourseName = (EditText) view.findViewById(R.id.course_name);
        final EditText inputTeacher = (EditText) view.findViewById(R.id.teacher_name);
        final EditText inputClassRoom = (EditText) view.findViewById(R.id.class_room);
        final EditText inputDay = (EditText) view.findViewById(R.id.day);
        final EditText inputStart = (EditText) view.findViewById(R.id.classes_begin);
        final EditText inputEnd = (EditText) view.findViewById(R.id.classes_ends);
        final Spinner inputWeek = (Spinner) view.findViewById(R.id.week_choose);
        Button backButton = (Button) view.findViewById(R.id.back_add);
        Button okButton = (Button) view.findViewById(R.id.okbtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = inputCourseName.getText().toString();
                String teacher = inputTeacher.getText().toString();
                String classRoom = inputClassRoom.getText().toString();
                String day = inputDay.getText().toString();
                String start = inputStart.getText().toString();
                String end = inputEnd.getText().toString();
                String week = inputWeek.getSelectedItem().toString();

                if (courseName.equals("") || day.equals("") || start.equals("") || end.equals("")) {
                    Toast.makeText(view.getContext(), "基本课程信息未填写", Toast.LENGTH_SHORT).show();
                }
                else {
                    Course course =new Course(courseName, teacher, classRoom,Integer.valueOf(day), Integer.valueOf(start), Integer.valueOf(end));
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    if(course_S_fragment!=null){
                        course_S_fragment.createLeftView(course);
                        course_S_fragment.createItemCourseView(course);
                    }else{
                        coursefragment.createLeftView(course);
                        coursefragment.createItemCourseView(course);
                    }
                    transaction.addToBackStack(null);
                    transaction.commit();
                    dismiss();
                }
            }
        });

        return view;
    }

    public void setOnCreateTaskListener(OnCreateTaskListener listener) {
        this.listener=listener;
    }
}
