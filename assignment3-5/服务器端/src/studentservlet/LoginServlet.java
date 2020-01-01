package studentservlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.standard.MediaSize.Other;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.UserService;
import student.StudentInfo;
import teacher.TeacherInfo;

import com.mysql.jdbc.Buffer;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8"); 
		InputStream is = request.getInputStream();
		StringBuffer sb = new StringBuffer();
		int len = 0;
		byte[]buf = new byte[1024];
		while((len = is.read(buf)) != -1) {
			sb.append(new String(buf,0,len));
		}
		System.out.println(sb.toString());
		
		
		String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        String identify = request.getParameter("identify");
        System.out.println("userid"+userid);
        System.out.println("password"+password);
        
        
        if(identify.equals("student")){
        	StudentInfo s=new StudentInfo();
            s.setUserid(userid);
    		s.setPassword(password);
    		if(userService.login_s(s)) {
    			
                System.out.println("ok");	
                Map map = new HashMap();
                map.put("msg","success");
                map.put("name",s.getUsername());
                map.put("sex", s.getSex());
                map.put("school", s.getSchool());
                JSONObject json=JSONObject.fromObject(map);
                response.getWriter().write(json.toString());
                System.out.println(json.toString());	
            }else {
            	Map map = new HashMap();
                map.put("msg","fail");
                map.put("reason", "登陆失败！！学号不存在或密码错误！");
                JSONObject json=JSONObject.fromObject(map);
                response.getWriter().write(json.toString());
                System.out.println(json.toString());
                 
            }
        }
        else{
        	TeacherInfo t=new TeacherInfo();
        	t.setUserid(userid);
        	
        	t.setPassword(password);
    		if(userService.login_t(t)) {
    			
                System.out.println("ok");	
                Map map = new HashMap();
                map.put("msg","success");
                map.put("name",t.getUsername());
                map.put("sex", t.getSex());
                map.put("school", t.getSchool());
                JSONObject json=JSONObject.fromObject(map);
                response.getWriter().write(json.toString());
                System.out.println(json.toString());	
            }else {
            	Map map = new HashMap();
                map.put("msg","fail");
                map.put("reason", "登陆失败！！学号不存在或密码错误！");
                JSONObject json=JSONObject.fromObject(map);
                response.getWriter().write(json.toString());
                System.out.println(json.toString());
                 
            }
        }
        

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
