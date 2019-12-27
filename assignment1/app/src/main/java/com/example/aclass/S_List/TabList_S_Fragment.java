package com.example.aclass.S_List;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.aclass.Activitys.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TabList_S_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TabList_S_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabList_S_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    private ImageView IVCreate;
    private CreateDialog createDialog;
//    private ShowDialog showDialog;
    private SwipeRecyclerView recyclerView;
    private ShowAdapter adapter;
    private List<InfoBean> showList=new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TabList_S_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabList_S_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TabList_S_Fragment newInstance(String param1, String param2) {
        TabList_S_Fragment fragment = new TabList_S_Fragment();
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

        view =inflater.inflate(R.layout.fragment_s_tab_list, container, false);
//        BarUtil.setColor((Activity) view.getContext(),getResources().getColor(R.color.blue),0);

//        showDialog=new ShowDialog();
        createDialog=new CreateDialog();
        createDialog.setOnCreateTaskListener(new OnCreateTaskListener() {
            @Override
            public void onCreateTask() {
                resetShowData();
            }
        });
        IVCreate=(ImageView)view.findViewById(R.id.iv_create);
        IVCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog.show(getChildFragmentManager(), "AddEventDialogFragment");
            }
        });
        initShowData();
        recyclerView=(SwipeRecyclerView)view.findViewById(R.id.rv_show);

        adapter=new ShowAdapter(view.getContext(), showList );

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setOnItemClickListener(new OnItemChangeListener() {


            @Override
            public void onMarkClick(int position) {
                adapter.markItem(position);
            }

            @Override
            public void onDeleteClick(int position) {
                adapter.removeItem(position);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
    private void initShowData() {
        /*
        测试数据
         */

        showList.add(new InfoBean("测试","不错哈",false,"2019-12-22"));
        showList.add(new InfoBean("测试2","不错哈",false,"2019-12-22"));



//        if(showList!=null) {
//            showList.clear();
////            showList.addAll(DBManager.getInstance().getInfoList());
//        }
    }

    private void resetShowData() {
        if(showList!=null) {
            showList.clear();
//            showList.addAll(DBManager.getInstance().getInfoList());
        }
        adapter.notifyDataSetChanged();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onListFragmentInteraction(uri);
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
        public void onListFragmentInteraction(Uri uri);
    }
}
