package Implementations.Repositories;

import Entities.User;
import Interfaces.IRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class UserRepository implements IRepository<User> {
    private Connection connection;

    private PreparedStatement getAllStatement;
    private PreparedStatement getByIdStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement updateStatement;

    public UserRepository(Connection connection) throws SQLException {
        this.connection = connection;
        getAllStatement = connection.prepareStatement("select * from users");
        getByIdStatement = connection.prepareStatement("select * from users where id = (?)");
        insertStatement = connection.prepareStatement("insert into users (first_name, last_name, iin, phone, password) " + "VALUES (?, ?, ?, ?, ?)");
        deleteStatement = connection.prepareStatement("delete from users where id = (?)");
        updateStatement = connection.prepareStatement("update users set first_name=(?), last_name=(?), iin=(?), phone=(?), password=(?)" + "where id = (?)");
    }

    @Override
    public ArrayList<User> get() {
        ArrayList<User> result = new ArrayList<>();

        ResultSet rs = null;
        try {
            rs = getAllStatement.executeQuery();

            while (rs.next()) {
                result.add(fromResultSet(rs));
            }
        } catch (SQLException e) {}

        return result;
    }

    @Override
    public User getById(int id) {
        User user = null;

        try {
            getByIdStatement.setInt(1, id);
            ResultSet rs = getByIdStatement.executeQuery();

            while (rs.next()) {
                user = fromResultSet(rs);
            }

            return user;
        } catch (SQLException e) {}

        return null;
    }

    @Override
    public void add(User user) {
        try {
            insertStatement.setString(1, user.getFirstName());
            insertStatement.setString(2, user.getLastName());
            insertStatement.setString(3, user.getIIN().toString());
            insertStatement.setString(4, user.getPhone());
            insertStatement.setString(5, user.getPassword());

            insertStatement.executeUpdate();
        } catch (SQLException e) {}
    }

    @Override
    public void delete(int id) {
        try {
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {}
    }

    @Override
    public void update(User user, int id) {
        try {
            updateStatement.setString(1, user.getFirstName());
            updateStatement.setString(2, user.getLastName());
            updateStatement.setString(3, user.getIIN());
            updateStatement.setString(4, user.getPhone());
            updateStatement.setString(5, user.getPassword());
            updateStatement.setInt(6, id);

            updateStatement.executeUpdate();
        } catch (SQLException e) {}
    }

    private User fromResultSet(ResultSet rs) {
        try {
            int id = rs.getInt("id");
            String phone = rs.getString("phone");
            String password = rs.getString("password");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String iin = rs.getString("iin");
            User user = new User(phone, password, firstName, lastName, iin);
            user.setId(id);
            return user;
        } catch (SQLException e) {}

        return null;
    }
}
