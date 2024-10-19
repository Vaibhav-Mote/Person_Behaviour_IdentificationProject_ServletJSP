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
import behaviour.module.service.*;


@WebServlet("/removef")
public class removeFollowersController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		userService userSer=new userServiceImpl();
		HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("userid");
        int registerid = Integer.parseInt(request.getParameter("registerid"));
		boolean b=userSer.isRemoveFollower(registerid, userid); 
		if(b) {
		RequestDispatcher r=request.getRequestDispatcher("followers.jsp");
	    r.include(request, response);
		} else {
			RequestDispatcher r=request.getRequestDispatcher("followers.jsp");
		    r.include(request, response);
		}
        
  
     
      
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
