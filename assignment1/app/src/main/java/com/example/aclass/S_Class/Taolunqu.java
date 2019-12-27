//package com.example.aclass.S_Class;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.net.Uri;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ExpandableListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.fragment.app.Fragment;
//
//import com.example.aclass.Activitys.R;
//import com.example.aclass.Adapter.CommentExpandAdapter;
//import com.example.aclass.S_Class.bean.CommentBean;
//import com.example.aclass.S_Class.bean.CommentDetailBean;
//import com.example.aclass.S_Class.bean.ReplyDetailBean;
//import com.google.android.material.appbar.CollapsingToolbarLayout;
//import com.google.android.material.bottomsheet.BottomSheetBehavior;
//import com.google.android.material.bottomsheet.BottomSheetDialog;
//import com.google.gson.Gson;
//
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link Taolunqu.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link Taolunqu#newInstance} factory method to
// * create an instance of this fragment.
// */
//public class Taolunqu extends Fragment implements View.OnClickListener {
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private View view;
//    private static final String TAG = "讨论区输出：";
//    private Toolbar toolbar;
//    private String mParam1;
//    private String mParam2;
//    private TextView bt_comment;
//    private CommentExpandableListView expandableListView;
//    private CommentExpandAdapter adapter;
//    private CommentBean commentBean;
//    private List<CommentDetailBean> commentsList;
//    private BottomSheetDialog dialog;
//    private String testJson = "{\n" +
//            "\t\"code\": 1000,\n" +
//            "\t\"message\": \"查看评论成功\",\n" +
//            "\t\"data\": {\n" +
//            "\t\t\"total\": 3,\n" +
//            "\t\t\"list\": [{\n" +
//            "\t\t\t\t\"id\": 42,\n" +
//            "\t\t\t\t\"nickName\": \"程序猿\",\n" +
//            "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
//            "\t\t\t\t\"content\": \"时间是一切财富中最宝贵的财富。\",\n" +
//            "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
//            "\t\t\t\t\"replyTotal\": 1,\n" +
//            "\t\t\t\t\"createDate\": \"三分钟前\",\n" +
//            "\t\t\t\t\"replyList\": [{\n" +
//            "\t\t\t\t\t\"nickName\": \"沐風\",\n" +
//            "\t\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
//            "\t\t\t\t\t\"id\": 40,\n" +
//            "\t\t\t\t\t\"commentId\": \"42\",\n" +
//            "\t\t\t\t\t\"content\": \"时间总是在不经意中擦肩而过,不留一点痕迹.\",\n" +
//            "\t\t\t\t\t\"status\": \"01\",\n" +
//            "\t\t\t\t\t\"createDate\": \"一个小时前\"\n" +
//            "\t\t\t\t}]\n" +
//            "\t\t\t},\n" +
//            "\t\t\t{\n" +
//            "\t\t\t\t\"id\": 41,\n" +
//            "\t\t\t\t\"nickName\": \"设计狗\",\n" +
//            "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
//            "\t\t\t\t\"content\": \"这世界要是没有爱情，它在我们心中还会有什么意义！这就如一盏没有亮光的走马灯。\",\n" +
//            "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
//            "\t\t\t\t\"replyTotal\": 1,\n" +
//            "\t\t\t\t\"createDate\": \"一天前\",\n" +
//            "\t\t\t\t\"replyList\": [{\n" +
//            "\t\t\t\t\t\"nickName\": \"沐風\",\n" +
//            "\t\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
//            "\t\t\t\t\t\"commentId\": \"41\",\n" +
//            "\t\t\t\t\t\"content\": \"时间总是在不经意中擦肩而过,不留一点痕迹.\",\n" +
//            "\t\t\t\t\t\"status\": \"01\",\n" +
//            "\t\t\t\t\t\"createDate\": \"三小时前\"\n" +
//            "\t\t\t\t}]\n" +
//            "\t\t\t},\n" +
//            "\t\t\t{\n" +
//            "\t\t\t\t\"id\": 40,\n" +
//            "\t\t\t\t\"nickName\": \"产品喵\",\n" +
//            "\t\t\t\t\"userLogo\": \"http://ucardstorevideo.b0.upaiyun.com/userLogo/9fa13ec6-dddd-46cb-9df0-4bbb32d83fc1.png\",\n" +
//            "\t\t\t\t\"content\": \"笨蛋自以为聪明，聪明人才知道自己是笨蛋。\",\n" +
//            "\t\t\t\t\"imgId\": \"xcclsscrt0tev11ok364\",\n" +
//            "\t\t\t\t\"replyTotal\": 0,\n" +
//            "\t\t\t\t\"createDate\": \"三天前\",\n" +
//            "\t\t\t\t\"replyList\": []\n" +
//            "\t\t\t}\n" +
//            "\t\t]\n" +
//            "\t}\n" +
//            "}";
//
//
//    private OnFragmentInteractionListener mListener;
//    public Taolunqu() {
//        // Required empty public constructor
//    }
//
//    // TODO: Rename and change types and number of parameters
//    public static Taolunqu newInstance(String param1, String param2) {
//        Taolunqu fragment = new Taolunqu();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        view=inflater.inflate(R.layout.fragment_taolunqu, container, false);
//        toolbar =view.findViewById(R.id.toolbar);
//        expandableListView =view.findViewById(R.id.detail_page_lv_comment);
//        bt_comment = (TextView) view.findViewById(R.id.detail_page_do_comment);
//        bt_comment.setOnClickListener(this);
//
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        setHasOptionsMenu(true);
//
//        CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
//        collapsingToolbar.setTitle("详情");
//        commentsList = generateTestData();
//        initExpandableListView(commentsList);
//
//
////        tlq_list = (ListView) rootView.findViewById(R.id.tlqview);
//        //initList();
//        return view;
//    }
//    /**
//     * 初始化评论和回复列表
//     */
//    private void initExpandableListView(final List<CommentDetailBean> commentList){
//        expandableListView.setGroupIndicator(null);
//        //默认展开所有回复
//        adapter = new CommentExpandAdapter(view.getContext(), commentList);
//        expandableListView.setAdapter(adapter);
//        for(int i = 0; i<commentList.size(); i++){
//            expandableListView.expandGroup(i);
//        }
//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
//                boolean isExpanded = expandableListView.isGroupExpanded(groupPosition);
//                Log.e(TAG, "onGroupClick: 当前的评论id>>>"+commentList.get(groupPosition).getId());
////                if(isExpanded){
////                    expandableListView.collapseGroup(groupPosition);
////                }else {
////                    expandableListView.expandGroup(groupPosition, true);
////                }
//                showReplyDialog(groupPosition);
//                return true;
//            }
//        });
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
//                Toast.makeText(getActivity(),"点击了回复",Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
//
//        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                //toast("展开第"+groupPosition+"个分组");
//
//            }
//        });
//
//    }
//
//    /**
//     * by moos on 2018/04/20
//     * func:生成测试数据
//     * @return 评论数据
//     */
//    private List<CommentDetailBean> generateTestData(){
//        Gson gson = new Gson();
//        commentBean = gson.fromJson(testJson, CommentBean.class);
//        List<CommentDetailBean> commentList = commentBean.getData().getList();
//        return commentList;
//    }
//
//    //    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        if(item.getItemId() == android.R.id.home){
////            finish();
////            return true;
////        }
////        return super.onOptionsItemSelected(item);
////    }
//    @Override
//    public void onClick(View v) {
//        if(view.getId() == R.id.detail_page_do_comment){
//
//            showCommentDialog();
//        }
//    }
//
//    /**
//     * by moos on 2018/04/20
//     * func:弹出评论框
//     */
//    private void showCommentDialog(){
//        dialog = new BottomSheetDialog(view.getContext());
//        View commentView = LayoutInflater.from(view.getContext()).inflate(R.layout.comment_dialog_layout,null);
//        final EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
//        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
//        dialog.setContentView(commentView);
//        /**
//         * 解决bsd显示不全的情况
//         */
//        View parent = (View) commentView.getParent();
//        BottomSheetBehavior behavior = BottomSheetBehavior.from(parent);
//        commentView.measure(0,0);
//        behavior.setPeekHeight(commentView.getMeasuredHeight());
//
//        bt_comment.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                String commentContent = commentText.getText().toString().trim();
//                if(!TextUtils.isEmpty(commentContent)){
//
//                    //commentOnWork(commentContent);
//                    dialog.dismiss();
//                    CommentDetailBean detailBean = new CommentDetailBean("小明", commentContent,"刚刚");
//                    adapter.addTheCommentData(detailBean);
//                    Toast.makeText(getActivity(),"评论成功",Toast.LENGTH_SHORT).show();
//
//                }else {
//                    Toast.makeText(getActivity(),"评论内容不能为空",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        commentText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if(!TextUtils.isEmpty(charSequence) && charSequence.length()>2){
//                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"));
//                }else {
//                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"));
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        dialog.show();
//    }
//
//    /**
//     * by moos on 2018/04/20
//     * func:弹出回复框
//     */
//    private void showReplyDialog(final int position){
//        dialog = new BottomSheetDialog(view.getContext());
//        View commentView = LayoutInflater.from(view.getContext()).inflate(R.layout.comment_dialog_layout,null);
//        final EditText commentText = (EditText) commentView.findViewById(R.id.dialog_comment_et);
//        final Button bt_comment = (Button) commentView.findViewById(R.id.dialog_comment_bt);
//        commentText.setHint("回复 " + commentsList.get(position).getNickName() + " 的评论:");
//        dialog.setContentView(commentView);
//        bt_comment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String replyContent = commentText.getText().toString().trim();
//                if(!TextUtils.isEmpty(replyContent)){
//
//                    dialog.dismiss();
//                    ReplyDetailBean detailBean = new ReplyDetailBean("小红",replyContent);
//                    adapter.addTheReplyData(detailBean, position);
//                    expandableListView.expandGroup(position);
//                    Toast.makeText(getActivity(),"回复成功",Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(getActivity(),"回复内容不能为空",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        commentText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if(!TextUtils.isEmpty(charSequence) && charSequence.length()>2){
//                    bt_comment.setBackgroundColor(Color.parseColor("#FFB568"));
//                }else {
//                    bt_comment.setBackgroundColor(Color.parseColor("#D8D8D8"));
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//        dialog.show();
//    }
//
//
//
//
//
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onTaolunquFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onTaolunquFragmentInteraction(Uri uri);
//    }
//
//
//
//
//
//}
