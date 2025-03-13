package DAO;

import Config.DbConfig;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    public void AddUser(User user) throws SQLException {
        String sql = "insert into user(nom,prenom,tele,username,password,role) values(?,?,?,?,?,?)";
        Connection connection = DbConfig.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, user.getNom());
        preparedStatement.setString(2, user.getPrenom());
        preparedStatement.setString(3, user.getTele());
        preparedStatement.setString(4, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole());
        preparedStatement.executeUpdate();

    }


    public List<User> getAllUser() {
        ArrayList<User> UserList = new ArrayList<>();
        try (Connection conn = DbConfig.getConnection()) {
            if (conn != null) {
                String sql = "SELECT * FROM user";
                try (PreparedStatement stmt = conn.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        User user = new User();
                        user.setIdUser(rs.getInt("idUser"));
                        user.setNom(rs.getString("nom"));
                        user.setPrenom(rs.getString("prenom"));
                        user.setTele(rs.getString("tele"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setRole(rs.getString("role"));

                        UserList.add(user);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return UserList;
    }

    public void updateUser(User user) {
        try (Connection conn = DbConfig.getConnection()) {
            if (conn != null) {

        String query = "UPDATE user SET nom = ?, prenom = ?, tele = ?, username = ?, password = ? , role = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getPrenom());
            stmt.setString(3, user.getTele());
            stmt.setString(4, user.getUsername());
            stmt.setString(5, user.getPassword());
            stmt.setInt(6, user.getIdUser());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
            e.printStackTrace();
        }
    }
} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int id) {
        try (Connection conn = DbConfig.getConnection()) {
            if (conn != null) {

        String query = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting person: " + e.getMessage());
            e.printStackTrace();
        }
    }


} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
