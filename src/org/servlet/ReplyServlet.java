package org.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dao.ReplyDao;
import org.model.Reply;

/**
 * Servlet implementation class ReplyServlet
 */
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("gb2312");
		String method=request.getParameter("method");
		String id=request.getParameter("id");
		if(method.equals("select")) {
			
			ReplyDao replyDao=new ReplyDao();
			ArrayList<Reply> replyList=	replyDao.findMbInfo();
			request.setAttribute("list", replyList.stream().filter(x->x.getMid().equals(Integer.parseInt(id))).collect(Collectors.toList()));
			
			request.getRequestDispatcher("/replymain.jsp").forward(request, response);

			
		}else if(method.equals("add"))
		{
			request.setAttribute("id", id);
			request.getRequestDispatcher("/reply.jsp").forward(request, response);
			
		}else if(method.equals("reply"))
		{
			String message=request.getParameter("message")
					;
			ReplyDao replyDao=new ReplyDao();
			replyDao.insert(Integer.parseInt(id),message,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			response.sendRedirect("resultreply.jsp");          

			
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
