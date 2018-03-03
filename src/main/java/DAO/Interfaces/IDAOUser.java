package DAO.Interfaces;

import Model.User;

import java.util.List;

public interface IDAOUser {
    User getUsersByID(int ID);
    boolean addUsers(User user);
    boolean delUser(User user);
    boolean editUser(User user);
    List<User> getAllUsers();
    List<Integer> getOrdersById(int id);
}
