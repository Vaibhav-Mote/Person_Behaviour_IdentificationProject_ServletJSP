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

import behaviour.config.DBParent;
import behaviour.module.service.*;




/**
 * Servlet implementation class loginServletController
 */
@WebServlet("/login")
public class loginServletController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String path=request.getServletContext().getRealPath("/")+"resources\\db.properties";
		DBParent.path=path;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		userService userSer=new userServiceImpl();
		int registerid=userSer.isgetregisterid(username, password);
		if(registerid!=-1) {
			HttpSession session = request.getSession(true);
            session.setAttribute("userid", registerid);
            response.sendRedirect("index.jsp?registerid=" + registerid); // Redirect to index.jsp with query parameter
       
		}
		else {
			out.println("invaid");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
