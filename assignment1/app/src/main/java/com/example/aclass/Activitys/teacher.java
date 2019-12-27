package com.example.aclass.Activitys;

import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.aclass.S_Course.TabCourse_S_Fragment;
import com.example.aclass.S_List.TabList_S_Fragment;
import com.example.aclass.S_Me.TabMe_S_Fragment;
import com.example.aclass.T_Class.TabClass_T_Fragment;

public class teacher extends AppCompatActivity
        implements TabClass_T_Fragment.OnFragmentInteractionListener, TabCourse_S_Fragment.OnFragmentInteractionListener,
        TabList_S_Fragment.OnFragmentInteractionListener, TabMe_S_Fragment.OnFragmentInteractionListener{
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
    private TabClass_T_Fragment tabClassTFragment;
    private TabCourse_S_Fragment tabCourseSFragment;
    private TabList_S_Fragment tabListSFragment;
    private TabMe_S_Fragment tabMeSFragment;

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

            tabClassTFragment = (TabClass_T_Fragment)fragmentManager.findFragmentByTag(FRAGMENT_TAG[1]);
            tabCourseSFragment = (TabCourse_S_Fragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[0]);
            tabListSFragment = (TabList_S_Fragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[2]);
            tabMeSFragment = (TabMe_S_Fragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG[3]);
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
                if (tabClassTFragment == null) {
                    tabClassTFragment = new TabClass_T_Fragment();
                    transaction.add(R.id.fl_container, tabClassTFragment, FRAGMENT_TAG[index]);
                } else {
                    transaction.show(tabClassTFragment);
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
        if (tabClassTFragment != null) {
            transaction.hide(tabClassTFragment);
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
    }

    public void onClassTFragmentInteraction(Uri uri){
        // Do stuff
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
}

