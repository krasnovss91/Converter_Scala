package servletrs;

import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns =  {"/", "/Table"})
public class TableServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userList", new UserService().getAllUser());
        request.getRequestDispatcher("/tablePage.jsp").forward(request, response);
    }
}