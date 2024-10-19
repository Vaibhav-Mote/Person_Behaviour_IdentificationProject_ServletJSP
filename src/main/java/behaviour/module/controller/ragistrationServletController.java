package behaviour.module.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import behaviour.config.DBParent;
import behaviour.module.model.PostLikeCount;
import behaviour.module.model.UserInfoModel;
import behaviour.module.service.*;


@WebServlet("/registr")
public class ragistrationServletController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	String path=request.getServletContext().getRealPath("/")+"resources\\db.properties";
	DBParent.path=path;
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	UserInfoModel model=new UserInfoModel();
	userService userService=new userServiceImpl();
	model.setName(name);
	model.setEmail(email);
	model.setUsername(username);
	model.setPass(password);
	boolean b = userService.isAddUser(model);
	if(b) {
		request.setAttribute("message", "Register Successfully");
	}
	else {
		request.setAttribute("message", "Registration failed");
	}
	RequestDispatcher r=request.getRequestDispatcher("registrationPage.jsp");
	r.include(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
