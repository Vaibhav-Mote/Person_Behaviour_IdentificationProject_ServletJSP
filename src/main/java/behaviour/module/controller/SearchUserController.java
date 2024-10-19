package behaviour.module.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import behaviour.module.model.UserInfoModel;
import behaviour.module.service.userService;
import behaviour.module.service.userServiceImpl;

@WebServlet("/search")
public class SearchUserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		userService userSer = new userServiceImpl();
		response.setContentType("text/html");
		String name = request.getParameter("n");
		List<UserInfoModel> list = userSer.isgetAllUsersInfoByName(name);
		for (UserInfoModel m : list) {
			out.println("<div id='pointedDiv'>");
			out.println("<a id='anker' href='profile.jsp?registerid="+ m.getId()+ "'>");
			out.println("<div class='followerInfo'>");
			out.println("<div class='logo'></div>");
			out.println("<div class='username'>");
			out.println("<span>" + m.getUsername() + "</span><br>");
			out.println(m.getName());
			out.println("</div>");
			out.println("</div>");
			out.println("</a>");
			out.println("</div>");

			 
			 
			 
			 
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
