package studentservlet;

import student.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 



import net.sf.json.JSONObject;
import service.UserService;
import teacher.TeacherInfo;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		String id = request.getParameter("userid");
		String name=request.getParameter("username");
		String password = request.getParameter("password");
		String sex=request.getParameter("sex");
		String tel=request.getParameter("tel");
		String school=request.getParameter("school");
		String department=request.getParameter("department");
		String identify=request.getParameter("identify");
		System.out.println(id+"-"+identify);
		
		
		if(identify.equals("student")){
			StudentInfo s=new StudentInfo();
			s.setUserid(id);
			s.setPassword(password);
			s.setUsername(name);
			s.setTel(tel);
			s.setSex(sex);
			s.setSchool(school);
			s.setDepartment(department);
			System.out.println(id+"-"+name+"-"+password);
			if(userService.register_s(s)) {
				
				
				Map map = new HashMap();
	            map.put("msg","success");
	            map.put("id", s.getUserid());
	            map.put("name",s.getUsername());
	            map.put("sex", s.getSex());
	            map.put("school", s.getSchool());
	            JSONObject json=JSONObject.fromObject(map);
	            response.getWriter().write(json.toString());
	            System.out.println(json.toString());	
				
	            System.out.println("注册成功...\n学号: " + s.getUserid() + "\n姓名: " + s.getUsername()+
	    				"\n性别: "+s.getSex());
			}
			else {
				Map map = new HashMap();
	            map.put("msg","fail");
	            map.put("reason", "学号已注册！");
	            JSONObject json=JSONObject.fromObject(map);
	            response.getWriter().write(json.toString());
	            System.out.println(json.toString());
			}
		}
		else{
			TeacherInfo t=new TeacherInfo();
			t.setUserid(id);
			t.setPassword(password);
			t.setUsername(name);
			t.setTel(tel);
			t.setSex(sex);
			t.setSchool(school);
			t.setDepartment(department);
			System.out.println(id+"-"+name+"-"+password);
			if(userService.register_t(t)) {
				
				
				Map map = new HashMap();
	            map.put("msg","success");
	            map.put("id", t.getUserid());
	            map.put("name",t.getUsername());
	            map.put("sex", t.getSex());
	            map.put("school", t.getSchool());
	            JSONObject json=JSONObject.fromObject(map);
	            response.getWriter().write(json.toString());
	            System.out.println(json.toString());	
				
	            System.out.println("注册成功...\n学号: " + t.getUserid() + "\n姓名: " + t.getUsername()+
	    				"\n性别: "+t.getSex());
			}
			else {
				Map map = new HashMap();
	            map.put("msg","fail");
	            map.put("reason", "工号已注册！");
	            JSONObject json=JSONObject.fromObject(map);
	            response.getWriter().write(json.toString());
	            System.out.println(json.toString());
			}
		}
		
		
	}
 
}
