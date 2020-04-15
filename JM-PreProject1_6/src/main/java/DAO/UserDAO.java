package DAO;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();

        try (Statement stmt = connection.createStatement()) {
            stmt.execute("SELECT * FROM users");
            ResultSet result = stmt.getResultSet();
            while (result.next()) {
                list.add(new User(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getString("password"),
                        result.getString("country"),
                        result.getInt("age")
                ));
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public User getUserById(long ID) {

        User user = new User();

        try (Statement stmt = connection.createStatement()) {

            stmt.execute("SELECT * FROM users WHERE id='" + ID + "'");
            ResultSet result = stmt.getResultSet();

            result.next();

            user.setId(ID);
            user.setName(result.getString("name"));
            user.setPassword(result.getString("password"));
            user.setCountry(result.getString("country"));
            user.setAge(result.getInt("age"));

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public boolean isNotUniqueUser(String name) {
        return  getAllUser()
                .stream()
                .map(User::getName)
                .anyMatch(el -> el.equals(name));
    }


    public void addUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, password, country, age) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("UPDATE users SET " +
                    "name='" + user.getName() + "', " +
                    "password='" + user.getPassword() + "', " +
                    "country='"+ user.getCountry() + "', " +
                    "age='" + user.getAge() + "' " +
                    "WHERE id='" + user.getId() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean deleteUser(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from users where id= ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS users (id bigint auto_increment, name varchar(256), password varchar(256), country varchar(256), age bigint, primary key (id)");
        stmt.close();
    }

    public void dropTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS users");
        stmt.close();
    }

    public static UserDAO getUserDAO() {
        return new UserDAO(getMysqlConnection());
    }

    public static Connection getMysqlConnection() {

        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());
            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("users?").          //db name
                    append("user=root&").          //login
                    append("password=password");       //password
            System.out.println("URL: " + url + "\n");
            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
