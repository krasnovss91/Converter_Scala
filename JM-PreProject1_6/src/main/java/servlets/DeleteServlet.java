package servletrs;

import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;



@WebServlet(urlPatterns = {"/Delete"})
public class DeleteServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        String[] deleteList = (String[]) request.getParameterValues("deleteList");
        if (deleteList == null) {
            request.setAttribute("message", "No Users to delete!");
        } else {
            Arrays.asList(deleteList).forEach(id -> {
                if (userService.deleteUser(Long.valueOf(id))) {
                    request.setAttribute("message", "Users successfully deleted!");
                } else {
                    request.setAttribute("message", "Users not deleted!");
                }
            });
        }
        response.sendRedirect("/Table");
    }
}