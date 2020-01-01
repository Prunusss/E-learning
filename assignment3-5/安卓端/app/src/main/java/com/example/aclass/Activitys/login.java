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
import android.widget.Toast;

import com.example.aclass.Service.StreamTools;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;


public class login extends Activity {



    public static EditText etUsername;
    public static EditText etPassword;

    Button login_btn;
    Button register_btn;
    LinearLayout linearLayout;
    private TextView showResponseview;
    private String s_msg;
    private String s_name;
    private String s_school;
    private String s_sex;
    private String s_id;
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
        etPassword= (EditText) findViewById(R.id.password_inputbox);
        etUsername = (EditText) findViewById(R.id.username_inputbox);
        login_btn = (Button) findViewById(R.id.login_btn);
        register_btn = (Button) findViewById(R.id.register_btn);
        showResponseview = (TextView) findViewById(R.id.tv_show_response);
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
//            Intent intent=new Intent(login.this, student.class);
//            startActivity(intent);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String s_id = etUsername.getText().toString();
                    String password = etPassword.getText().toString();
                    String identify = "student";
                    final String  response = loginByPost(s_id,password,identify);
                    if(response.equals("success")){

                        Intent intent=new Intent(login.this, student.class);
                        startActivity(intent);
                        showResponse(response);

                    }else{
                        showResponse("请求失败....");
                    }

                }
            }).start();
            Toast.makeText(this,"正在提交请求",Toast.LENGTH_LONG).show();
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
                showResponseview.setText(response);
            }
        });
    }



    public static String loginByGet(String username,String password,String identify){
        try {
            //提交数据到服务器
            //拼装路径
            String path = "http://10.0.2.2:8080/ClassServer/UserServlet";
            URL url = new URL(path);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();//打开连接

            conn.setRequestMethod("GET");//设置请求方式为get

            conn.setConnectTimeout(5000);//设置连接超时时间为5秒
            String data = "username="+ URLEncoder.encode("123")+"&password="
                    +URLEncoder.encode("123");
            System.out.println(data);
            conn.setRequestProperty("Content=Type", "application/x-wwww-form-urlencoded");
            conn.setRequestProperty("Content-length", data.length()+"");
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            int code = conn.getResponseCode();//获得请求码
            if(code == 200){
                InputStream is = conn.getInputStream();
                String text = StreamTools.readInputStream(is);
                return text;
            }else{
                return null;
            }
//            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //这里提交的路径一定要写准确，填写你当前所在局域网的ip + 项目名 + Servlet Url
    public String loginByPost(String userid,String password,String identify){
        try {
            System.out.println("进入方法");
            String path = "http://10.0.2.2:8080/ClassServer/LoginServlet?";
            String data = "userid="+URLEncoder.encode(userid)+"&password="
                    +URLEncoder.encode(password)+"&identify="+URLEncoder.encode(identify);
            path+=data;
            URL url = new URL(path);
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.setRequestMethod("POST");
//            String data = "userid="+URLEncoder.encode(userid)+"&password="
//                    +URLEncoder.encode(password)+"&identify="+URLEncoder.encode(identify);
            System.out.println(path);
//            conn.setRequestProperty("Content=Type", "application/x-wwww-form-urlencoded");
//            conn.setRequestProperty("Content-length", data.length()+"");
            //  conn.setRequestProperty("Content=Type", "application/json;charset=utf-8");
//            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            int code = conn.getResponseCode();
            if (code == 200) {

                InputStream in = new BufferedInputStream(conn.getInputStream());

                StringBuilder sb = new StringBuilder();
                BufferedReader r = new BufferedReader(new InputStreamReader(in),1000);
                for (String line = r.readLine(); line != null; line = r.readLine()) {
                    sb.append(line);
                }
                String result = sb.toString();
                if(result.equals("fail")){
                    return result;
                }else{
                    JSONObject jsonObject = new JSONObject(result);
                    s_msg=jsonObject.getString("msg");
                    s_school=jsonObject.getString("school");
                    s_name=jsonObject.getString("name");
                    s_sex=jsonObject.getString("sex");
                    return s_msg;
                }

            }else {
                return "fail";
            }




        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("111111");
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
