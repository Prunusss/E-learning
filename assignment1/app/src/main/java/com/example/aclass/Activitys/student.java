package com.example.aclass.Activitys;

import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.aclass.S_Class.Nowclasspeople;
import com.example.aclass.S_Class.SiliaoTeacher;
import com.example.aclass.S_Class.TabClass_S_Fragment;
//import com.example.aclass.S_Class.Taolunqu;
import com.example.aclass.S_Course.TabCourse_S_Fragment;
import com.example.aclass.S_Me.TabMe_S_Fragment;
import com.example.aclass.S_List.TabList_S_Fragment;

public class student extends AppCompatActivity
        implements TabClass_S_Fragment.OnFragmentInteractionListener, TabCourse_S_Fragment.OnFragmentInteractionListener,
TabList_S_Fragment.OnFragmentInteractionListener, TabMe_S_Fragment.OnFragmentInteractionListener,Nowclasspeople.OnFragmentInteractionListener,
        SiliaoTeacher.OnFragmentInteractionListener{
//    SiliaoTeacher.OnFragmentInteractionListener, Taolunqu.OnFragmentInteractionListener {
    private RadioGroup mRgGroup;
    private FragmentManager fragmentManager;

    private static final String[] FRAGMENT_TAG = {"tab_class","tab_course", "tab_list","tab_me"};

    private final int show_class = 1;//课堂
    private final int show_course = 0;//课程
    private final int show_list = 2;//list
    private final int show_me = 3;//我的
    private int mrIndex = show_class;//默认选中课堂

    private int index = -100;// 记录当前的选项
    /**
     * 上一次界面 onSaveInstanceState 之前的tab被选中的状态 key 和 value
     */
    private static final String PRV_SELINDEX = "PREV_SELINDEX";
    private TabClass_S_Fragment tabClassSFragment;
    private TabCourse_S_Fragment tabCourseSFragment;
    private TabList_S_Fragment tabListSFragment;
    private TabMe_S_Fragment tabMeSFragment;


    private Nowclasspeople nowclasspeople_fragment;
//    private Taolunqu tlq_fragment;
    private SiliaoTeacher siliao_fragment;
    //private
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //解决底部选项按钮被输入文字框顶上去
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //显示界面
        setContentView(R.layout.activity_student);

        fragmentManager = getSupportFragmentManager();

        //防止app闪退后fragment重叠
        if (savedInstanceState != null) {
            //读取上一次界面Save的时候tab选中的状态
            mrIndex = savedInstanceState.getInt(PRV_SELINDEX, mrIndex);

            tabClassSFragment = (TabClass_S_Fragment)fragmentManager.findFragmentByTag(FRAGMENT_TAG[1]);
            tabCourseSFragment = (TabCourse_S_Fragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[0]);
            tabListSFragment = (TabList_S_Fragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[2]);
            tabMeSFragment = (TabMe_S_Fragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[3]);
            String sno="17301086";
            String sname="周诗梦";
            nowclasspeople_fragment=Nowclasspeople.newInstance(sno,sname);
        }

        //初始化
        initView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(PRV_SELINDEX, mrIndex);
        super.onSaveInstanceState(outState);
    }
    protected void initView() {
        //获得RadioGroup控件
        mRgGroup = (RadioGroup)findViewById(R.id.rg_group);
        //选择设置Fragment
        setTabSelection(show_class);
        //点击事件
        mRgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.bo_class://class
                        setTabSelection(show_class);
                        break;
                    case R.id.bo_course://course
                        setTabSelection(show_course);
                        break;
                    case R.id.bo_list://list
                        setTabSelection(show_list);
                        break;
                    case R.id.bo_me://我的
                        setTabSelection(show_me);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param id 传入的选择的fragment
     */
    private void setTabSelection(int id) {    //根据传入的index参数来设置选中的tab页。
        if (id == index) {
            return;
        }
        index = id;
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 设置切换动画
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case show_course://course的fragment
                mRgGroup.check(R.id.bo_course);
                if (tabCourseSFragment == null) {
                    tabCourseSFragment = new TabCourse_S_Fragment();
                    transaction.add(R.id.fl_container, tabCourseSFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(tabCourseSFragment);
                }
                transaction.commit();
                break;
            case show_list://list的fragment
                mRgGroup.check(R.id.bo_list);
                if (tabListSFragment == null) {
                    tabListSFragment = new TabList_S_Fragment();
                    transaction.add(R.id.fl_container, tabListSFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(tabListSFragment);
                }
                transaction.commit();
                break;
            case show_class://class的fragment
                mRgGroup.check(R.id.bo_class);//设置商城被选中
                if (tabClassSFragment == null) {
                    tabClassSFragment = new TabClass_S_Fragment();
                    transaction.add(R.id.fl_container, tabClassSFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(tabClassSFragment);
                }
                transaction.commit();
                break;
            case show_me://我的的fragment
                mRgGroup.check(R.id.bo_me);//我的的fragmen
                if (tabMeSFragment == null) {
                    tabMeSFragment = new TabMe_S_Fragment();
                    transaction.add(R.id.fl_container, tabMeSFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(tabMeSFragment);
                }
                transaction.commit();
                break;
            default:
                break;
        }
    }

    /**
     * 隐藏fragment
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (tabClassSFragment != null) {
            transaction.hide(tabClassSFragment);
        }
        if (tabCourseSFragment != null) {
            transaction.hide(tabCourseSFragment);
        }
        if (tabListSFragment != null) {
            transaction.hide(tabListSFragment);
        }
        if (tabMeSFragment != null) {
            transaction.hide(tabMeSFragment);
        }
        if (nowclasspeople_fragment !=null){
            transaction.hide(nowclasspeople_fragment);
        }
    }

    public void onClassFragmentInteraction(Uri uri){
        Toast.makeText(student.this,"测试成功！",Toast.LENGTH_SHORT).show();
        nowclasspeople_fragment=Nowclasspeople.newInstance("123","123");

        fragmentManager.beginTransaction()
                .replace(R.id.fl_container,nowclasspeople_fragment,null)
                .addToBackStack(null)
                .commit();

    }

    public void onCourseFragmentInteraction(Uri uri){
        //做不同的东西

    }

    public void onListFragmentInteraction(Uri uri){
        // Do stuff
    }

    public void onMeFragmentInteraction(Uri uri){
        //做不同的东西
    }

    public void onNowclasspeopleFragmentInteraction(String choice) {
        Toast.makeText(student.this,choice,Toast.LENGTH_SHORT).show();
//        if(choice.equals("tlq")){
//            tlq_fragment=Taolunqu.newInstance("123","123");
//            fragmentManager.beginTransaction()
//                    .replace(R.id.fl_container,tlq_fragment,null)
//                    .addToBackStack(null)
//                    .commit();
//        }
        if(choice.equals("siliao")){
            siliao_fragment=SiliaoTeacher.newInstance("123","123");
            fragmentManager.beginTransaction()
                    .replace(R.id.fl_container,siliao_fragment,null)
                    .addToBackStack(null)
                    .commit();
        }

    }
    public void onSiliaoTeacherFragmentInteraction(String message) {
        Toast.makeText(student.this,message,Toast.LENGTH_SHORT).show();

    }
    public void onTaolunquFragmentInteraction(Uri uri) {

    }
}

