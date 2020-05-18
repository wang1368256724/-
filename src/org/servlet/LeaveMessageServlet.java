package org.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.dao.BanDao;
import org.dao.LoginDao;
import org.model.*;

public class LeaveMessageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置请求编码
		request.setCharacterEncoding("gb2312");
		// 设置响应编码
		response.setContentType("gb2312");
		// 获取title内容
		String title = request.getParameter("title");
		// 获取message内容
		String message = request.getParameter("message");
		// 从session中取出当前用户对象
		Login leaveMessageBoard = (Login) request.getSession().getAttribute("login");
		// 建立留言表对应JavaBean对象，把数据封装进去

		List<Ban> list = new BanDao().queryAll();

		List<Ban> listIDFilter = list.stream().filter(x -> (int)x.getBtype()==1).collect(Collectors.toList());

		
		String name = leaveMessageBoard.getName();

		Boolean isNo = false;  
		
		String ip = request.getRemoteAddr();
		/**
		* X-Forwarded-For:简称XFF头，它代表客户端，也就是HTTP的请求端真实的IP
		* 只有在通过了HTTP 代理或者负载均衡服务器时才会添加该项
		* 标准格式如下：X-Forwarded-For: client_ip, proxy1_ip, proxy2_ip
		* 此头是可构造的，因此某些应用中应该对获取到的ip进行验证
		*/
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    ip = request.getHeader("x-forwarded-for");
		}
		/**
		*在多级代理网络中，直接用getHeader("x-forwarded-for")可能获取到的是unknown信息
		*此时需要获取代理代理服务器重新包装的HTTP头信息，
		*/
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    //Apache+WebLogic搭配下出现的头
		    ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
		    //Apache+WebLogic搭配下出现的头
		    ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    //可通过http头伪造，是由代理服务器发送的请求头
		    ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    //可通过http头伪造，和X-Forwarded-For格式类似，以“,"分隔
		    ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		System.out.println(ip);
		
		
		for (Ban ban : listIDFilter) {
			if (ban.getBtext().equals(name)) {
				isNo = true;
			}
		}
		if (isNo == true) {
			request.setAttribute("error", "你的账号ID已被禁止留言，请联系管理员");
			request.getRequestDispatcher("/leavemessage.jsp").forward(request, response);
			return;
		}

		List<Ban> listIPFilter = list.stream().filter(x -> (int)x.getBtype()==2).collect(Collectors.toList());
		

		for (Ban ban : listIPFilter) {
			if (ban.getBtext().equals(ip)) {
				isNo = true;
			}  
		}
		if (isNo == true) {
			request.setAttribute("error", "你的IP已被禁止留言，请联系管理员");
			request.getRequestDispatcher("/leavemessage.jsp").forward(request, response);
			return;
		}
		
		

		MessBoar mb = new MessBoar();
		mb.setId(leaveMessageBoard.getId());
		// 参数为获取的当前时间
		mb.setName(leaveMessageBoard.getName());
		mb.setTime(new Date(System.currentTimeMillis()));
		mb.setTitle(title);
		mb.setMessage(message);
		// 调DB类中的方法判断是否插入成功
		if (new LoginDao().addInfo(mb)) {
			response.sendRedirect("success.jsp");
		}
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
