package behaviour.module.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import behaviour.module.service.*;

@WebServlet("/likepost")
public class likeThePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int userid=Integer.parseInt(request.getParameter("registerid"));
		int postid=Integer.parseInt(request.getParameter("postid"));
		
		PostService postService = new PostServiceImpl();
		boolean b = postService.islikePost(userid, postid);
		
		if(b) {
			
		
			RequestDispatcher r=request.getRequestDispatcher("profile.jsp");
			r.include(request, response);
		}
		else {

			RequestDispatcher r=request.getRequestDispatcher("profile.jsp");
			r.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
