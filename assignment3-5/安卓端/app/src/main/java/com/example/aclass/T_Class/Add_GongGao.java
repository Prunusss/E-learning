package com.example.aclass.T_Class;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aclass.Activitys.R;

public class Add_GongGao extends AppCompatActivity {

    //private View gongGaoView;
    private EditText gonggao_text;
    private EditText gongao_title;
    private Button ok_btn;
    private Button clear_btn;
    private SharedPreferences sp;
    private AlertDialog dialog;
    private static final int SUCCESS = 0X0000000;

    private boolean inputok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__gong_gao);
        gongao_title= (EditText) findViewById(R.id.gonggao_title);
        gonggao_text= (EditText) findViewById(R.id.gonggao_txt);
        ok_btn= (Button) findViewById(R.id.fabu_btn);
        clear_btn=(Button)findViewById(R.id.qingkong_btn);
        inputok=false;
        registControlerListerner();

    }
    private void registControlerListerner() {
        TextWatcher mytextwatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//               EveryExcucet();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputok=EveryExcucet();
            }

            @Override
            public void afterTextChanged(Editable s) {
//                EveryExcucet();
            }
        };
        gonggao_text.addTextChangedListener(mytextwatcher);
        gongao_title.addTextChangedListener(mytextwatcher);
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextClear();
            }

            private void editTextClear() {
                gonggao_text.setText("");
            }
        });
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gongao_title.getText().length()==0){
                    Toast.makeText(Add_GongGao.this,"请填入标题",Toast.LENGTH_SHORT).show();
                }
                if(gonggao_text.getText().length()==0){
                    Toast.makeText(Add_GongGao.this,"不能发布空内容",Toast.LENGTH_SHORT).show();

                }else {

                    saveGongGao();

                };
            }
        });
    }

    public  boolean EveryExcucet(){
        if(gonggao_text.getText().length()>0&&gongao_title.getText().length()>0){
            return true;
        }
        else{
            return false;
        }
    }



    private void saveGongGao() {
        //编写保存公告部分----与数据库进行通讯
//        if (!isNetworkConnected(getActivity())) {
//            new BToast(getActivity()).showText(getActivity(), getResources().getString(R.string.meiyouwangluo));
//        } else {
//            String noticeTitle=gongao_title.getText().toString();
//            String noticetext=gonggao_text.getText().toString();
//            String teacherNo=sp.getString("myuserid","");
//            String paramJson="{"+
//                    "\"TeacherNo\""+":"+"\""+teacherNo+"\""+","+
//                    "\"NoticeTitle\""+":"+"\""+noticeTitle+"\""+","+
//                    "\"NoticeContent\""+":"+"\""+noticetext+"\""+
//                    "}";
//            Log.e("s",myip() + Urls.NoticeINFO_URL);
//            Log.e("tetx", URLEncoder.encode(paramJson));
//            OkHttpUtils
//                    .post()
//                    .url(myip() + Urls.NoticeINFO_URL)
//                    .addHeader("param", URLEncoder.encode(paramJson))
//                    .build()
//                    .execute(new StringCallback() {
//                        @Override
//                        public void onError(Call call, Exception e, int id) {
//
//                            Log.e("onError",e.toString());//224312  367172
//                        }
//
//                        @Override
//                        public void onResponse(String response, int id) {
//                            Log.e("onResponse",response);
//                            try {
//                                JSONObject object = new JSONObject(response);
//                                if (object.getBoolean("success")){
//                                    Toast(object.getString("message"));
//                                    handler.sendEmptyMessage(SUCCESS);
//                                }else{
//                                    Toast(object.getString("message"));
//                                }
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//        }
    }
}
