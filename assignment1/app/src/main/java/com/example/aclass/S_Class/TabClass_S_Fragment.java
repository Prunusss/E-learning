package com.example.aclass.S_Class;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aclass.Activitys.R;


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
    View tabclass_s_view;
    private Button tozy_button;
    private Button toclasspeople_button;
    private Nowclasspeople nowclasspeople_fragment;

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
        tabclass_s_view=inflater.inflate(R.layout.fragment_s_tab_class, container, false);




//        toclassinfo_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(nowclasspeople_fragment==null){
//                    String sno="17301086";
//                    String sname="周诗梦";
//                    nowclasspeople_fragment=Nowclasspeople.newInstance(sno,sname);
//                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                    // 用这个fragment替换任何在fragment_container中的东西
//                    // 并添加事务到back stack中以便用户可以回退到之前的状态
//                    transaction
//                            .addToBackStack(null)  //将当前fragment加入到返回栈中
//                            .replace(R.id.fl_container,nowclasspeople_fragment)
//                            .show(nowclasspeople_fragment)
//                            .commit();
//
//                }
//            }
//        });
        // Inflate the layout for this fragment



        return tabclass_s_view;






    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onClassFragmentInteraction(uri);
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

    public interface OnFragmentInteractionListener {
        public void onClassFragmentInteraction(Uri uri);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toclasspeople_button= (Button) getActivity().findViewById(R.id.toclasspeoplebtn);

        toclasspeople_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "nihao", Toast.LENGTH_LONG).show();
                //从fragment跳转到activity中
                mListener.onClassFragmentInteraction(Uri.parse("content://" + "com.fengge.demo" + "/people"));
            }
        });
        tozy_button=(Button) getActivity().findViewById(R.id.enterzy_btn);
        tozy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "nihao", Toast.LENGTH_LONG).show();
                //从fragment跳转到activity中
                mListener.onClassFragmentInteraction(Uri.parse("content://" + "com.fengge.demo" + "/people"));
            }
        });

    }

}
