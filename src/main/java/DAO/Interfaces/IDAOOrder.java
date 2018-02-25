package DAO.Interfaces;

import Model.Order;

import java.util.List;

public interface IDAOOrder {
    Order getOrdersByID(int ID);
    boolean addOrders(Order order);
    boolean delOrder(Order order);
    boolean editOrder(Order order);
    List<Order> getAllOrders();
}
