package Model;

import java.util.Date;

public class LockedUser {
    private int user_id;
    private Date lock_date;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getLock_date() {
        return lock_date;
    }

    public void setLock_date(Date lock_date) {
        this.lock_date = lock_date;
    }
}
