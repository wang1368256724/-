package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.BanDao;
import org.model.Ban;

/**
 * Servlet implementation class BanServlet
 */
public class BanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BanServlet() {
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
		String type = request.getParameter("type");
		String v = request.getParameter("v");
		if (type.equals("0")) {
			// id
			Ban ban=new Ban();
			ban.setBtype(1);
			ban.setBtext(v);
          new BanDao().add(ban);
          request.setAttribute("mm", 1);
          request.getRequestDispatcher("/banid.jsp").forward(request, response);
		} else {
			Ban ban=new Ban();
			ban.setBtype(2);
			ban.setBtext(v);  
          new BanDao().add(ban);
          request.setAttribute("mm", 1);
          request.getRequestDispatcher("/banip.jsp").forward(request, response);
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
