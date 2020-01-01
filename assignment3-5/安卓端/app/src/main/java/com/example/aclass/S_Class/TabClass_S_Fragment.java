package com.example.aclass.S_Class;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aclass.Activitys.R;
import com.example.aclass.Adapter.ClassShowAdapter;
import com.example.aclass.Adapter.NowClassShowAdapter;
import com.example.aclass.S_Class.bean.ClassBean;
import com.example.aclass.S_Class.bean.StuInfoBean;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabClass_S_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabClass_S_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabClass_S_Fragment extends Fragment  implements View.OnClickListener {


        // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    View view;
    private Button tozy_button;
    private Button toclasspeople_button;
    private Nowclasspeople nowclasspeople_fragment;
    private RollPagerView mRollViewPager;
    private Button moreclassmates;
    RecyclerView nowRecyclerView;
    RecyclerView recyclerView;
    private List<ClassBean> nowClass=new ArrayList<>();
    private List<ClassBean> todayClass=new ArrayList<>();
    public TabClass_S_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabClass_S_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabClass_S_Fragment newInstance(String param1, String param2) {
        TabClass_S_Fragment fragment = new TabClass_S_Fragment();
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
        //测试传输
        view=inflater.inflate(R.layout.fragment_s_tab_class, container, false);

        //走马灯
        mRollViewPager = (RollPagerView) view.findViewById(R.id.roll_view_pager);

        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());
        mRollViewPager.setHintView(new ColorPointHintView(view.getContext(),Color.YELLOW,Color.WHITE));




        return view;
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.mipmap.class1,
                R.mipmap.class2,
                R.mipmap.class3,
                R.mipmap.class4,

        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
        // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onClassFragmentInteraction("");
//        }
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

    @Override
    public void onClick(View view) {

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
    private void initShowData() {
        /*
        测试数据
         */
        todayClass.add(new ClassBean("操作系统","思源208","邢薇薇","10:00-12:00"));
        todayClass.add(new ClassBean("数据库","逸夫708","王方石","14:00-16:00"));

        nowClass.add(new ClassBean("移动应用开发","逸夫513","曾立刚","10:00-12:00"));



//        if(showList!=null) {
//            showList.clear();
////            showList.addAll(DBManager.getInstance().getInfoList());
//        }
    }


    public interface OnFragmentInteractionListener {
        public void onClassFragmentInteraction(String choice);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        moreclassmates= (Button) getActivity().findViewById(R.id.more);

        moreclassmates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "查看同学名单", Toast.LENGTH_LONG).show();
                //从fragment跳转到activity中
               // mListener.onClassFragmentInteraction("toCourse");
                ArrayList<StuInfoBean> arrayOfUsers = new ArrayList<StuInfoBean>();
                arrayOfUsers.add(new StuInfoBean("17301086", "zsm","1703"));
                arrayOfUsers.add(new StuInfoBean("17301099", "lt","1704"));
                ShowClassmatesListDialog classmatesListView=new ShowClassmatesListDialog(arrayOfUsers);

                classmatesListView.show(getChildFragmentManager(), "show classmates list");

            }
        });
        initShowData();
        recyclerView = view.findViewById(R.id.rv_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ClassShowAdapter(view.getContext(),todayClass));

        nowRecyclerView=view.findViewById(R.id.rv_showNow);
        nowRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        nowRecyclerView.setAdapter(new NowClassShowAdapter(view.getContext(),nowClass));


//        toclasspeople_button= (Button) getActivity().findViewById(R.id.toclasspeoplebtn);
//
//        toclasspeople_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "nihao", Toast.LENGTH_LONG).show();
//                //从fragment跳转到activity中
//                mListener.onClassFragmentInteraction(Uri.parse("content://" + "com.fengge.demo" + "/people"));
//            }
//        });
//        tozy_button=(Button) getActivity().findViewById(R.id.enterzy_btn);
//        tozy_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "nihao", Toast.LENGTH_LONG).show();
//                //从fragment跳转到activity中
//                mListener.onClassFragmentInteraction(Uri.parse("content://" + "com.fengge.demo" + "/people"));
//            }
//        });

    }

}
