package DAO;

import DAO.Interfaces.IDAOLockedUser;
import Model.LockedUser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOLockedUser extends DAO implements IDAOLockedUser{

    public LockedUser getLockedUserById(int id) {
        LockedUser lockedUser = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM locked_users WHERE comment_id = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                lockedUser = new LockedUser();
                lockedUser.setUser_id(result.getInt("user_id"));
                lockedUser.setLock_date(result.getDate("user_lock_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lockedUser;
    }

    public boolean addLockedUser(LockedUser lockedUser) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO locked_users ('user_lock_date') VALUES(?)");

            statement.setDate(1, lockedUser.getLock_date());
            result = statement.execute();
            lockedUser.setUser_id(statement.getGeneratedKeys().getInt(1)); // андрей не знает работает ли это
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delLockedUser(LockedUser lockedUser) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM locked_users WHERE user_id = ?");
            statement.setInt(1, lockedUser.getUser_id());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<LockedUser> getAllLockedUsers() {
        List<LockedUser> lockedUsersList = new ArrayList<LockedUser>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM locked_users");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                LockedUser lockedUser = new LockedUser();
                lockedUsersList.add((lockedUser));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return lockedUsersList;
    }
}
