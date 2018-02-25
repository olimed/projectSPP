package DAO;

import java.sql.Connection;

public class DAO {
    Connection connection = ConnectionManager.getConnection();
}
