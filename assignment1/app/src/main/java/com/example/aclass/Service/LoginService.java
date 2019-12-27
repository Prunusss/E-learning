package com.example.aclass.Service;

/**
 * Created by zhangwei on 2018/3/10.
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/*该类演示了四种方法提交数据到服务器，并将服务器解析后的数据以字符串的形式返回*/
public class LoginService {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    public static String loginByGet(String username,String password,String identify){
        try {
            //提交数据到服务器
            //拼装路径
            String path = "http://10.0.2.2:8080/WebServer/UserServlet";
            URL url = new URL(path);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();//打开连接

            conn.setRequestMethod("GET");//设置请求方式为get

            conn.setConnectTimeout(5000);//设置连接超时时间为5秒
            String data = "username="+URLEncoder.encode("123")+"&password="
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
    public static String loginByPost(String username,String password,String identify){
        try {
            String path = "http://10.0.2.2:8080/WebServer/UserServlet";
            URL url = new URL(path);
            HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.setRequestMethod("POST");
            String data = "username="+URLEncoder.encode(username)+"&password="
                    +URLEncoder.encode(password)+"&identify="+URLEncoder.encode("student");
            System.out.println(data);
            conn.setRequestProperty("Content=Type", "application/x-wwww-form-urlencoded");
            conn.setRequestProperty("Content-length", data.length()+"");
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(data.getBytes());
            int code = conn.getResponseCode();
            if (code == 200) {
                InputStream is = conn.getInputStream();
                String text = StreamTools.readInputStream(is);
                return text;
            }else {
                return null;
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("111111");
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

