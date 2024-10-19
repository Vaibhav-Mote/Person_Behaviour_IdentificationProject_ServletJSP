package behaviour.module.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import behaviour.module.service.PostService;
import behaviour.module.service.PostServiceImpl;

@WebServlet("/deletePostOnIndex")
public class deletePostOnIndex extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PostService postService = new PostServiceImpl();
		  int postid=Integer.parseInt(request.getParameter("postid"));
		  int registerid=Integer.parseInt(request.getParameter("registerid"));
		  boolean b=postService.isdeletePost(postid);
		  System.out.println(b);
		  RequestDispatcher r=request.getRequestDispatcher("index.jsp?registerid="+registerid);
		  r.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
