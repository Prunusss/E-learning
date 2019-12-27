package com.example.aclass.S_Class;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.aclass.Activitys.R;
import com.example.aclass.Adapter.Adapter_ChatMessage;
import com.example.aclass.S_Class.bean.ChatMessage;

import java.util.ArrayList;
import java.util.List;

import static com.example.aclass.Activitys.R.layout;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SiliaoTeacher_Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SiliaoTeacher_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SiliaoTeacher_Fragment extends Fragment {

    private EditText et_content;
    private ListView listView;
    private Button btn_send;
    private List<ChatMessage> chatMessageList = new ArrayList<>();//消息列表
    private Adapter_ChatMessage adapter_chatMessage;
    private ChatMessageReceiver chatMessageReceiver;

    private View view;
    private Context mContext;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SiliaoTeacher_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SiliaoTeacher_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SiliaoTeacher_Fragment newInstance(String param1, String param2) {
        SiliaoTeacher_Fragment fragment = new SiliaoTeacher_Fragment();
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
//        // Inflate the layout for this fragment
        view=inflater.inflate(layout.fragment_siliao_teacher, container, false);
        mContext=view.getContext();

        findViewById();
        initView();
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = et_content.getText().toString();
                if (content.length() <= 0) {
                    mListener.onSiliaoTeacherFragmentInteraction("warning");
                    return;
                }


                    //暂时将发送的消息加入消息列表，实际以发送成功为准（也就是服务器返回你发的消息时）
                    ChatMessage chatMessage=new ChatMessage();
                    chatMessage.setContent(content);
                    chatMessage.setIsMeSend(1);
                    chatMessage.setIsRead(1);
                    chatMessage.setTime(System.currentTimeMillis()+"");
                    chatMessageList.add(chatMessage);
                    initChatMsgListView();
                    et_content.setText("");
            }
        });
        return view;

    }
    private void findViewById() {
        listView = view.findViewById(R.id.chatmsg_listView);
        btn_send = view.findViewById(R.id.btn_send);
        et_content = view.findViewById(R.id.et_content);
    }
    private void initChatMsgListView(){
        adapter_chatMessage = new Adapter_ChatMessage(mContext, chatMessageList);
        listView.setAdapter(adapter_chatMessage);
        listView.setSelection(chatMessageList.size());
    }
    private void initView() {
        //监听输入框的变化
        et_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (et_content.getText().toString().length() > 0) {
                    btn_send.setVisibility(View.VISIBLE);
                } else {
                    btn_send.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void initiSiliao()
    {

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSiliaoTeacherFragmentInteraction("ok");
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
        // TODO: Update argument type and name
        void onSiliaoTeacherFragmentInteraction(String message);
    }
    private class ChatMessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String message=intent.getStringExtra("message");
            ChatMessage chatMessage=new ChatMessage();
            chatMessage.setContent(message);
            chatMessage.setIsMeSend(0);
            chatMessage.setIsRead(1);
            chatMessage.setTime(System.currentTimeMillis()+"");
            chatMessageList.add(chatMessage);
            initChatMsgListView();
        }
    }
}
