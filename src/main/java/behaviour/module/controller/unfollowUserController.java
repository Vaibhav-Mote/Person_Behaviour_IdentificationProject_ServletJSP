package behaviour.module.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import behaviour.module.service.userService;
import behaviour.module.service.userServiceImpl;


@WebServlet("/unfollow")
public class unfollowUserController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userService userSer=new userServiceImpl();
			PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("userid");
        int registerid = Integer.parseInt(request.getParameter("registerid"));
		boolean b=userSer.isUnfollowUser(registerid, userid); 
		if(b) {
			RequestDispatcher r=request.getRequestDispatcher("following.jsp");
		    r.include(request, response);
			} else {
				RequestDispatcher r=request.getRequestDispatcher("following.jsp");
			    r.include(request, response);
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
