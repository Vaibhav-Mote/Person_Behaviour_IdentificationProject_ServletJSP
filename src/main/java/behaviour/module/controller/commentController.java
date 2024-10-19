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

import behaviour.module.service.PostService;
import behaviour.module.service.PostServiceImpl;

@WebServlet("/comment")
public class commentController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        PostService postService = new PostServiceImpl();
        String comment = request.getParameter("commentt");
        int postid = Integer.parseInt(request.getParameter("postid"));
        HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("userid");
       boolean b = postService.isCommenPost(userid, postid, comment);
       if(b) {
    	   RequestDispatcher r=request.getRequestDispatcher("profile.jsp");
			r.include(request, response);
       }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
