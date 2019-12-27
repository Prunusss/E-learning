package com.example.aclass.S_Course;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.aclass.Activitys.R;

//import android.support.v7.widget.Toolbar;

//import androidx.appcompat.widget.Toolbar;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabCourse_S_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabCourse_S_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabCourse_S_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    LayoutInflater inflater;
    Context context;
    //星期几
    private RelativeLayout day;

    private View view;
    int currentCoursesNumber = 0;
    int maxCoursesNumber = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private Button add_button;

    AddCourseDialog c_dialog;
    public TabCourse_S_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabCourse_S_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabCourse_S_Fragment newInstance(String param1, String param2) {
        TabCourse_S_Fragment fragment = new TabCourse_S_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        view=inflater.inflate(R.layout.fragment_s_tab_course, container, false);

        context=view.getContext();

        add_button=view.findViewById(R.id.addcoursebtn);
        Course c=new Course("test","test","yf",1,1,2);

        createLeftView(c);
        createItemCourseView(c);
        c_dialog=new AddCourseDialog(this);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                c_dialog.setOnCreateTaskListener(new OnCreateTaskListener() {
//                    @Override
//                    public void onCreateTask() {
//                        resetShowData();
//                    }
//                });
                c_dialog.show(getChildFragmentManager(), "AddEventDialogFragment");
            }
        });
        return view;
    }

    //创建"第几节数"视图
    public void createLeftView(Course course) {
        int endNumber = course.getEnd();
        if (endNumber > maxCoursesNumber) {
            for (int i = 0; i < endNumber-maxCoursesNumber; i++) {

                View view1 = LayoutInflater.from(context).inflate(R.layout.left_view, null);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(110,180);
                view1.setLayoutParams(params);

                TextView text = view1.findViewById(R.id.class_number_text);
                text.setText(String.valueOf(++currentCoursesNumber));

                LinearLayout leftViewLayout = view.findViewById(R.id.left_view_layout);
                leftViewLayout.addView(view1);
            }
            maxCoursesNumber = endNumber;
        }
    }

    //创建单个课程视图
    public void createItemCourseView(final Course course) {
        int getDay = course.getDay();
        if ((getDay < 1 || getDay > 7) || course.getStart() > course.getEnd())
            Toast.makeText(context, "星期几没写对,或课程结束时间比开始时间还早~~", Toast.LENGTH_LONG).show();
        else {
            int dayId = 0;
            switch (getDay) {
                case 1: dayId = R.id.monday; break;
                case 2: dayId = R.id.tuesday; break;
                case 3: dayId = R.id.wednesday; break;
                case 4: dayId = R.id.thursday; break;
                case 5: dayId = R.id.friday; break;
                case 6: dayId = R.id.saturday; break;
                case 7: dayId = R.id.weekday; break;
            }
            day = view.findViewById(dayId);

            int height = 180;
            final View v = LayoutInflater.from(context).inflate(R.layout.course_card, null); //加载单个课程布局
            v.setY(height * (course.getStart()-1)); //设置开始高度,即第几节课开始
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.MATCH_PARENT,(course.getEnd()-course.getStart()+1)*height - 8); //设置布局高度,即跨多少节课
            v.setLayoutParams(params);
            TextView text = v.findViewById(R.id.text_view);
            text.setText(course.getCourseName() + "\n" + course.getTeacher() + "\n" + course.getClassRoom()); //显示课程名
            day.addView(v);
            //长按删除课程
            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    v.setVisibility(View.GONE);//先隐藏
                    day.removeView(v);//再移除课程视图
//                    SQLiteDatabase sqLiteDatabase =  databaseHelper.getWritableDatabase();
//                    sqLiteDatabase.execSQL("delete from courses where course_name = ?", new String[] {course.getCourseName()});
                    return true;
                }
            });
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onCourseFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onCourseFragmentInteraction(Uri uri);

    }


}
