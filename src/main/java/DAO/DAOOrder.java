package DAO;

import DAO.Interfaces.IDAOOrder;
import DAO.DAO;
import Model.Order;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOOrder extends DAO implements IDAOOrder {
    public Order getOrdersByID(int ID) {
        Order order = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE ord_id=?");
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                order = new Order();
                order.setOrd_id(result.getInt("ord_id"));
                order.setOrd_date(result.getDate("ord_date").toLocalDate());
                order.setOrd_price(result.getFloat("ord_price"));
                order.setUser_id(result.getInt("user_id"));
                order.setArg_id(result.getInt("arg_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public boolean addOrders(Order order) {
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO orders ('arg_id', 'user_id', 'ord_price', 'ord_date') VALUES (?,?,?,?)");
            statement.setInt(1, order.getArg_id());
            statement.setInt(2, order.getUser_id());
            statement.setFloat(3, order.getOrd_price());
            statement.setDate(4, Date.valueOf(order.getOrd_date())) ;
            boolean result = statement.executeUpdate() != 0;
            //TODO проверить правильность индекса
            order.setOrd_id(getLastAddedId(statement));

            return result;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delOrder(Order order) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM orders WHERE ord_id = ?");
            statement.setInt(1, order.getOrd_id());
            result = statement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean editOrder(Order order) {
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE orders SET agr_id = ?, user_id = ?, ord_price = ?, ord_date = ? WHERE ord_id = ?)");
            statement.setInt(1, order.getArg_id());
            statement.setInt(2, order.getUser_id());
            statement.setFloat(3, order.getOrd_price());
            statement.setDate(4, Date.valueOf(order.getOrd_date())) ;
            statement.setInt(5, order.getOrd_id());
            boolean result = statement.executeUpdate() != 0;
            return result;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Order> getAllOrders() {
        List<Order> ordersList = new ArrayList<Order>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Order order = new Order();
                order.setOrd_id(result.getInt("ord_id"));
                order.setOrd_date(result.getDate("ord_date").toLocalDate());
                order.setOrd_price(result.getFloat("ord_price"));
                //TODO Проверить правильность установки родительских ключей
                order.setUser_id(result.getInt("user_id"));
                order.setArg_id(result.getInt("arg_id"));

                ordersList.add(order);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ordersList;
    }
}
