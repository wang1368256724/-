package org.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.LoginDao;
import org.model.Login;
import org.model.MessBoar;

/**
 * Servlet implementation class FindPasswordServlet
 */
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String sum = request.getParameter("sum");
		String datetime = request.getParameter("datetime");
System.out.println(datetime);
		Login login = new LoginDao().getLoginByName(name);

		if (null == login) {
			request.setAttribute("error", "找回密码失败，无此用户名");
			request.getRequestDispatcher("/findpassword.jsp").forward(request, response);

		} else {

			List<MessBoar> list = new LoginDao().findMbInfo();

			list = list.stream().filter(x -> x.getName().equals(name.trim())).collect(Collectors.toList());

			int size = list.size();
			int sum1 = (int) Integer.parseInt(sum);
			if (size == sum1) {

				if (login.getLastlogin().equals(datetime)) {
					request.setAttribute("name", login.getName());
					request.getRequestDispatcher("/updatepass.jsp").forward(request, response);


				} else {
					System.out.println(datetime);
					request.setAttribute("error", "找回密码失败，账号信息不匹配");
					request.getRequestDispatcher("/findpassword.jsp").forward(request, response);
				}

			} else {
				request.setAttribute("error", "找回密码失败，账号信息不匹配");
				request.getRequestDispatcher("/findpassword.jsp").forward(request, response);
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
