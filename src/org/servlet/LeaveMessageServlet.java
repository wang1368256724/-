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
		// �����������
		request.setCharacterEncoding("gb2312");
		// ������Ӧ����
		response.setContentType("gb2312");
		// ��ȡtitle����
		String title = request.getParameter("title");
		// ��ȡmessage����
		String message = request.getParameter("message");
		// ��session��ȡ����ǰ�û�����
		Login leaveMessageBoard = (Login) request.getSession().getAttribute("login");
		// �������Ա��ӦJavaBean���󣬰����ݷ�װ��ȥ

		List<Ban> list = new BanDao().queryAll();

		List<Ban> listIDFilter = list.stream().filter(x -> (int)x.getBtype()==1).collect(Collectors.toList());

		
		String name = leaveMessageBoard.getName();

		Boolean isNo = false;  
		
		String ip = request.getRemoteAddr();
		/**
		* X-Forwarded-For:���XFFͷ��������ͻ��ˣ�Ҳ����HTTP���������ʵ��IP
		* ֻ����ͨ����HTTP ������߸��ؾ��������ʱ�Ż���Ӹ���
		* ��׼��ʽ���£�X-Forwarded-For: client_ip, proxy1_ip, proxy2_ip
		* ��ͷ�ǿɹ���ģ����ĳЩӦ����Ӧ�öԻ�ȡ����ip������֤
		*/
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    ip = request.getHeader("x-forwarded-for");
		}
		/**
		*�ڶ༶���������У�ֱ����getHeader("x-forwarded-for")���ܻ�ȡ������unknown��Ϣ
		*��ʱ��Ҫ��ȡ���������������°�װ��HTTPͷ��Ϣ��
		*/
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    //Apache+WebLogic�����³��ֵ�ͷ
		    ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknow".equalsIgnoreCase(ip)) {
		    //Apache+WebLogic�����³��ֵ�ͷ
		    ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    //��ͨ��httpͷα�죬���ɴ�����������͵�����ͷ
		    ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		    //��ͨ��httpͷα�죬��X-Forwarded-For��ʽ���ƣ��ԡ�,"�ָ�
		    ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		System.out.println(ip);
		
		
		for (Ban ban : listIDFilter) {
			if (ban.getBtext().equals(name)) {
				isNo = true;
			}
		}
		if (isNo == true) {
			request.setAttribute("error", "����˺�ID�ѱ���ֹ���ԣ�����ϵ����Ա");
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
			request.setAttribute("error", "���IP�ѱ���ֹ���ԣ�����ϵ����Ա");
			request.getRequestDispatcher("/leavemessage.jsp").forward(request, response);
			return;
		}
		
		

		MessBoar mb = new MessBoar();
		mb.setId(leaveMessageBoard.getId());
		// ����Ϊ��ȡ�ĵ�ǰʱ��
		mb.setName(leaveMessageBoard.getName());
		mb.setTime(new Date(System.currentTimeMillis()));
		mb.setTitle(title);
		mb.setMessage(message);
		// ��DB���еķ����ж��Ƿ����ɹ�
		if (new LoginDao().addInfo(mb)) {
			response.sendRedirect("success.jsp");
		}
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
