package com.example.aclass.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class login extends Activity {



    public static EditText etUsername;
    public static EditText etPassword;

    Button login_btn;
    Button register_btn;
    LinearLayout linearLayout;
    private TextView showResponse;
    int locationX ,locationY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //不显示程序的标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //不显示系统的标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        init();
    }
    void init() {
        linearLayout = (LinearLayout) findViewById(R.id.userName_layout);
        etUsername = (EditText) findViewById(R.id.password_inputbox);
        etPassword = (EditText) findViewById(R.id.username_inputbox);
        login_btn = (Button) findViewById(R.id.login_btn);
        register_btn = (Button) findViewById(R.id.register_btn);
        showResponse = (TextView) findViewById(R.id.tv_show_response);
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, Register.class);
                startActivity(intent);
            }
        });

    }

    public void login_btn_click(View v) {


        //还没写好校验 测试方便直接跳转
        RadioGroup rg = (RadioGroup)findViewById(R.id.rg_group);;//这里用构造有点问题，一般用xml，再FindVieyById(id)
        RadioButton rb = (RadioButton)rg.getChildAt(0);
        if(rb.isChecked()){
            Intent intent=new Intent(login.this, teacher.class);
            startActivity(intent);
        }else {
            Intent intent=new Intent(login.this, student.class);
            startActivity(intent);
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    String username = etUsername.getText().toString();
//                    String password = etPassword.getText().toString();
//                    String identify = "student";
//                    final String  response = LoginService.loginByPost(username,password,identify);
//                    if(response.equals("success")){
//                        //showResponse(response);
//                        Intent intent=new Intent(login.this, student.class);
//                        startActivity(intent);
//                    }else{
//                        showResponse("请求失败....");
//                    }
//
//                }
//            }).start();
//            Toast.makeText(this,"正在提交请求",Toast.LENGTH_LONG).show();
        }


    }


//    public void register_btn_click(View v)  {
//        Intent intent=new Intent(login.this, Register.class);
//        startActivity(intent);
//    }

    private void showResponse(final  String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showResponse.setText(response);
            }
        });
    }


}
