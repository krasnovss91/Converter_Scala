package service;

import DAO.UserDAO;
import exception.DBException;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    UserDAO dao = UserDAO.getUserDAO();

    public UserService() {
    }


    public User getUserById(long id) {
        return dao.getUserById(id);
    }

    public List<User> getAllUser() {
        return dao.getAllUser();
    }

    public boolean deleteUser(Long id) {
        return dao.deleteUser(id);
    }

    public boolean addUser(User User) {
        if (isNotUniqueUser(User.getName())) {
            return false;
        } else {
            dao.addUser(User);
            return true;
        }
    }

    public void createTable() throws DBException {
        UserDAO dao = UserDAO.getUserDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public void updateUser(User User) {
        dao.updateUser(User);
    }

    public boolean isNotUniqueUser(String name) {
        return dao.isNotUniqueUser(name);
    }
}
