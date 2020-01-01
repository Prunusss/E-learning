package studentservlet;
import service.UserService;
import student.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/JoinXiaoZuServlet")
public class JoinXiaoZuServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain;charset = utf-8");
		response.setHeader("Content-type", "text/html;charset=utf-8");
		String kename = request.getParameter("kename");
		String xuehao = request.getParameter("xuehao");
		String zuhao = request.getParameter("zuhao");
		//System.out.println(userId+"-"+password);
		
		if(userService.joinxiaozu(kename, xuehao, zuhao)) {
			
			response.getOutputStream().write((kename+"-"+zuhao+"-"+xuehao).getBytes("utf-8"));
			System.out.println(kename+"-"+zuhao+"-"+xuehao);
		}
		else {
			response.getOutputStream().write(("登录失败...\n请检查用户名和密码是否正�?").getBytes("utf-8"));
		}
		
	}
}