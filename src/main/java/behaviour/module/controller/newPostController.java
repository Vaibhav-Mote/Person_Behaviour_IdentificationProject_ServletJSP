package behaviour.module.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import behaviour.module.service.PostService;
import behaviour.module.service.PostServiceImpl;

@WebServlet("/newpost")
@MultipartConfig
public class newPostController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        int registerid = (Integer) session.getAttribute("userid");
        PostService postService = new PostServiceImpl();
        String post = request.getParameter("post");

        // Handle file upload
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        System.out.println(filePart.getSubmittedFileName());
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // Get file name
        String uploadDir = getServletContext().getRealPath("") + File.separator + "uploads"; // Directory to save the file
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) uploadDirFile.mkdir(); // Create directory if it doesn't exist

        File file = new File(uploadDir + File.separator + fileName);
        try (InputStream input = filePart.getInputStream()) {
            // Save file to server
            java.nio.file.Files.copy(input, file.toPath());
        }

        // Process post and file data
        boolean b = postService.isAddPost(post, registerid, fileName); // Pass fileName to service
        if (b) {
            request.setAttribute("message", "Posted Successfully");
        } else {
            request.setAttribute("message", "Posted not Successfully ");
        }

        RequestDispatcher r = request.getRequestDispatcher("newPost.jsp");
        r.include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
