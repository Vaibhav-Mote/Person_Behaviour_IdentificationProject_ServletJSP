package behaviour.module.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import behaviour.config.DBParent;


@WebServlet("/adlogin")
public class adminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String path=request.getServletContext().getRealPath("/")+"resources\\db.properties";
		DBParent.path=path;
		PrintWriter out=response.getWriter();
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		if(name.compareTo("vaibhav")==0 &&(pass.compareTo("1234")==0)) {
			HttpSession session = request.getSession(true);
            session.setAttribute("name", name);
		   response.sendRedirect("adminIndex.jsp");
		}
		else {
			out.println("invalid");
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
