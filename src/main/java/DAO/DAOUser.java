package DAO;

import DAO.Interfaces.IDAOUser;
import Model.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users ('user_login', 'user_passwd', 'user_name', 'user_mail', 'user_telephone') VALUES (?,?,?,?,?)");
            statement.setString(1, user.getUser_login());
            statement.setString(2, user.getUser_password());
            statement.setString(3, user.getUser_name());
            statement.setString(4, user.getUsre_mail());
            statement.setString(5, user.getUsre_telephone());

            boolean result = statement.executeUpdate() != 0;
            //TODO проверить правильность индекса
            user.setUser_id(getLastAddedId(statement));
            return result;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delUser(User user) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM users WHERE user_id = ?");
            statement.setInt(1, user.getUser_id());
            result = statement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean editUser(User user) {
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET user_login = ?, user_passwd = ?, user_name = ?, user_mail = ?, user_telephone = ?) WHERE user_id = ?)");

            statement.setString(1, user.getUser_login());
            statement.setString(2, user.getUser_password());
            statement.setString(3, user.getUser_name());
            statement.setString(4, user.getUsre_mail());
            statement.setString(5, user.getUsre_telephone());
            statement.setInt(6,user.getUser_id());

            boolean result = statement.executeUpdate() != 0;
            return result;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<User>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                User user = new User();

                user.setUser_id(result.getInt("user_id"));
                user.setUser_login(result.getString("user_login"));
                user.setUser_password(result.getString("user_passwd"));
                user.setUser_name(result.getString("user_name"));
                user.setUsre_mail(result.getString("user_mail"));
                user.setUsre_telephone(result.getString("user_telephone"));
                usersList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public List<Integer> getOrdersById(int id) {
        List<Integer> ordersIdList = new ArrayList<Integer>();

        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT ord_id FROM orders WHERE user_id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                ordersIdList.add(result.getInt("ord_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersIdList;
    }
}
