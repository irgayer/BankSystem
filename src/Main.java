import Entities.User;
import Implementations.Repositories.UserRepository;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            var connection = createConnection();

            UserRepository userRepository = new UserRepository(connection);
            var users = userRepository.get();

            for (var user : users) {
                System.out.println(user.getFullName());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static Connection createConnection() throws SQLException {
        String url = String.format("jdbc:%s://localhost:5432/%s", JdbcOptions.DRIVER, JdbcOptions.DB_NAME);

        var properties = new Properties();
        properties.setProperty("user", JdbcOptions.USERNAME);
        properties.setProperty("password", JdbcOptions.PASSWORD);
        properties.setProperty("ssl", "false");
        Connection connection = DriverManager.getConnection(url, properties);

        return connection;
    }
}