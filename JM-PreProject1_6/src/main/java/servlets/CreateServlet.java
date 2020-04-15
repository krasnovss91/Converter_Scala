
package servletrs;

import model.User;
import service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(urlPatterns = {"/Create"})
public class CreateServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        UserService userService = new UserService();
        try {
            userService.createTable();
            resp.setStatus(200);
        } catch (exception.DBException e) {
            resp.setStatus(400);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/createPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String password = request.getParameter("password");
        String age = request.getParameter("age");

        if (name == "" | country == "" | password == "" | age == "") {
            request.setAttribute("message", "Input correct data to register!");
            doGet(request, response);
        }
        if (userService.isNotUniqueUser(name)) { // not unique user validation
            request.setAttribute("message", "User already exists!");
        } else { // create user
            userService.addUser(new User(name, password, country, Integer.parseInt(age)));
            request.setAttribute("message", "User successfully created!");
        }
        response.sendRedirect("/Table");
    }
}