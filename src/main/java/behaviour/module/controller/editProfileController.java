package behaviour.module.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import behaviour.module.model.UserInfoModel;
import behaviour.module.service.*;

@WebServlet("/editProfile")
public class editProfileController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        userService userService = new userServiceImpl();
        PrintWriter out = response.getWriter();
        
        int userid=Integer.parseInt(request.getParameter("registerid"));
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
            UserInfoModel model = new UserInfoModel();
            model.setName(name);
            model.setEmail(email);
            model.setUsername(username);
            boolean b=userService.UpdateUserData(model, userid);
           if(b)
            out.println("Profile updated successfully!");
        else 
            out.println("Username is already taken. Please choose another one.");
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
