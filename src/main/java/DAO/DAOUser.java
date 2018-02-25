package DAO;

import DAO.Interfaces.IDAOUser;
import Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAOUser extends DAO implements IDAOUser {
    @Override
    public User getUsersByID(int ID) {
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE user_id=?");
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                user = new User();
                user.setUser_id(result.getInt("user_id"));
                user.setUser_login(result.getString("user_login"));
                user.setUser_name(result.getString("user_name"));
                user.setUser_password(result.getString("user_passwd"));
                user.setUsre_mail(result.getString("user_mail"));
                user.setUsre_telephone(result.getString("user_telephone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean addUsers(User user) {
        return false;
    }

    @Override
    public boolean delUser(User user) {
        return false;
    }

    @Override
    public boolean editUser(User user) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }
}
