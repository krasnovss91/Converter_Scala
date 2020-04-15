package servletrs;

import model.User;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = {"/Update"})
public class UpdateServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        request.setAttribute("user", userService.getUserById(Long.parseLong(id)));
        request.setAttribute("message", "User successfully found to update!");

        request.getRequestDispatcher("/updatePage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String password = request.getParameter("password");
        String age = request.getParameter("age");

        if (name == "" | surname == "" | password == "" | age == "") {
            request.setAttribute("message", "Input correct data to updater!");
            doGet(request, response);
        }

        if (userService.isNotUniqueUser(name)) { // not unique user validation
            request.setAttribute("message", "User already exists!");
        } else { // update user
            userService.updateUser(new User(Long.parseLong(id), name, password, surname, Integer.parseInt(age)));
            request.setAttribute("message", "User successfully updated!");
        }
        response.sendRedirect("/Table");
    }
}