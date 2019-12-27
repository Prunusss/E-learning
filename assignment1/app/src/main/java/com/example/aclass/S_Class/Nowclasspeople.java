package com.example.aclass.S_Class;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aclass.Activitys.R;
import com.example.aclass.Activitys.taolunqu;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Nowclasspeople.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Nowclasspeople#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Nowclasspeople extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button tlq_button;
    private Button sl_button;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Nowclasspeople() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Nowclasspeople.
     */
    // TODO: Rename and change types and number of parameters
    public static Nowclasspeople newInstance(String param1, String param2) {
        Nowclasspeople fragment = new Nowclasspeople();
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
        return inflater.inflate(R.layout.fragment_nowclasspeople, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onNowclasspeopleFragmentInteraction("tlq");
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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tlq_button = (Button) getActivity().findViewById(R.id.tlq_btn);

        tlq_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从fragment跳转到activity中
//                mListener.onNowclasspeopleFragmentInteraction("tlq");
                Intent intent = new Intent(getActivity(), taolunqu.class);
                startActivity(intent);
            }
        });
        sl_button = (Button) getActivity().findViewById(R.id.slteacher_btn);
        sl_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //从fragment跳转到activity中
                mListener.onNowclasspeopleFragmentInteraction("siliao");
            }
        });

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onNowclasspeopleFragmentInteraction(String choice);
    }
}
