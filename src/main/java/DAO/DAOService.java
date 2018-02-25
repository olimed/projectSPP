package DAO;

import DAO.Interfaces.IDAOService;
import Model.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOService extends DAO implements IDAOService{
    public Service getServiceById(int id) {
        Service service = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM service WHERE serv_id = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                service = new Service();
                service.setServ_id(result.getInt("serv_id"));
                service.setServ_name(result.getString("serv_name"));
                service.setServ_price(result.getFloat("serv_price"));
                service.setServ_time(result.getFloat("serv_time"));
                service.setServ_count_people(result.getInt("serv_count_people"));
                service.setServ_description(result.getString("serv_descriptiion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public boolean addService(Service service) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO service ('serv_name', 'serv_time', 'serv_price', 'serv_count_people', 'serv_description') VALUES(?, ?, ?, ?, ?)");

            statement.setString(1, service.getServ_name());
            statement.setFloat(1, service.getServ_time());
            statement.setFloat(1, service.getServ_price());
            statement.setInt(1, service.getServ_count_people());
            statement.setString(1, service.getServ_description());
            result = statement.execute();
            service.setServ_id(statement.getGeneratedKeys().getInt(1)); // андрей не знает работает ли это
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delService(Service service) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM service WHERE serv_id = ?");
            statement.setInt(1, service.getServ_id());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean editService(Service service) {
        boolean result = false;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE service SET serv_name = ?, serv_time = ?, serv_count_people = ?, serv_price = ?, serv_description = ? WHERE serv_id = ?)");
            statement.setString(1, service.getServ_name());
            statement.setFloat(2, service.getServ_time());
            statement.setInt(3, service.getServ_count_people());
            statement.setFloat(4, service.getServ_price());
            statement.setString(5, service.getServ_description());
            statement.setInt(5, service.getServ_id());

            result = statement.execute();
            service.setServ_id(statement.getGeneratedKeys().getInt(1)); //и здесь андрей тоже ничего не знает
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Service> getAllServices() {
        List<Service> servicesList = new ArrayList<Service>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM service");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Service service = new Service();
                service.setServ_name(result.getString("serv_name"));
                service.setServ_price(result.getFloat("serv_price"));
                service.setServ_time(result.getFloat("serv_time"));
                service.setServ_count_people(result.getInt("serv_count_people"));
                service.setServ_description(result.getString("serv_descriptiion"));
                servicesList.add((service));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return servicesList;
    }

}
