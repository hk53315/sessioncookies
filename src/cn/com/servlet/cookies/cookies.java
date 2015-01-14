package cn.com.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cookies extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<a href='/servlet_2/deletecookie'>����ϴη���ʱ��</a>");
		out.println("���ϴη��ʵ�ʱ���ǣ�");
		
		Cookie[] cookies = req.getCookies();
		
		for(int i=0; cookies!=null && i<cookies.length; i++){
			System.out.println(cookies[i].getName());
			if("lastAccessTime".equals(cookies[i].getName())){
				long cookieValue = Long.parseLong(cookies[i].getValue());
				Date date = new Date(cookieValue);
				out.print(date.toLocaleString());
				break;
			}
		}
		
		Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
		cookie.setMaxAge(1*30*24*3600);
		//�������·��������cookie ��������Ϊ�����վ�����������
		cookie.setPath("/servlet_2");
		
		resp.addCookie(cookie);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	
	
}
