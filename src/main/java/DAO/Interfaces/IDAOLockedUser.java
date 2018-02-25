package DAO.Interfaces;

import Model.LockedUser;

import java.util.List;

public interface IDAOLockedUser {
    LockedUser getLockedUserById(int id);
    boolean addLockedUser(LockedUser lockedUser);
    boolean delLockedUser(LockedUser lockedUser);
    List<LockedUser> getAllLockedUsers();
}
