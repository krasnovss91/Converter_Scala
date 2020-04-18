package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import model.User;
import service.UserService;

@WebListener
public class ContextListener implements ServletContextListener {
    private Map<Integer, User> users;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        users = new ConcurrentHashMap<>();

        servletContext.setAttribute("users", users);

        final User user = UserService.createStubUser(1, "Первый", 10);
        this.users.put(user.getId(), user);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        users = null;
    }
}
