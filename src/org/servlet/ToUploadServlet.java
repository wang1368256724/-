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
import org.dao.ReplyDao;
import org.model.MessBoar;
import org.model.Reply;

/**
 * Servlet implementation class ToUploadServlet
 */
public class ToUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToUploadServlet() {
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

		request.setCharacterEncoding("gb2312");
		String id = request.getParameter("id");

		LoginDao loginDao=new LoginDao();
		
		List<MessBoar> messBoars= loginDao.findMbInfo();  
		
		request.setAttribute("msg",
				messBoars.stream().filter(x -> x.getId()==(int)Integer.parseInt(id)).collect(Collectors.toList()).get(0));

		request.getSession().setAttribute("uploadid", id);
		
		request.getRequestDispatcher("/uploadfile.jsp").forward(request, response);

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
