package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    Connection connection = ConnectionManager.getConnection();

    public int getLastAddedId(PreparedStatement preparedStatement) {
        int ret = -1;
        try {
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next())
                ret = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

}