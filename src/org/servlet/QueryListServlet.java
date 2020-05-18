package org.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.LoginDao;
import org.model.MessBoar;

/**
 * Servlet implementation class QueryListServlet
 */
public class QueryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryListServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// TODO Auto-generated method stub
		String v = request.getParameter("v"); 
		System.out.println(v);

		List<MessBoar> list = new LoginDao().findMbInfo();
		List<MessBoar> listReturn = new ArrayList<>();

		for (MessBoar m : list) {
			Boolean isInsert = false;
			if (m.getTitle().contains(v)) {
				isInsert = true;

			}

			if (m.getMessage().contains(v)) {
				isInsert = true;
			   

			}
			if (isInsert) {
				listReturn.add(m);
			}
		}

		request.getSession().setAttribute("al", listReturn);

		request.getRequestDispatcher("main.jsp").forward(request, response);

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
