package com.example.aclass.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private Button sendRequest;
    // private Button register_btn;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etSno;
    private EditText etSsex;
    private EditText etStel;
    private EditText etSdepartment;
    private EditText etSclass;
    private EditText etSschool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }
    private void initView(){
        sendRequest = (Button)findViewById(R.id.reg_button);
        //register_btn=(Button)findViewById(R.id.register_button);
        etUsername = (EditText)findViewById(R.id.sname_edit);
        etPassword = (EditText)findViewById(R.id.spassword_edit);
        etSno = (EditText)findViewById(R.id.sno);
        etSsex = (EditText)findViewById(R.id.ssex);
        etStel = (EditText)findViewById(R.id.stel);
        etSclass = (EditText)findViewById(R.id.sclass);
        etSschool = (EditText)findViewById(R.id.sschool);
//        etSdepartment = (EditText)findViewById(R.id.sdepartment);
//        sendRequest.setOnClickListener((View.OnClickListener) this);
    }

    public void back_click(View view) {
        Intent intent=new Intent(Register.this, login.class);
        startActivity(intent);
    }
}
