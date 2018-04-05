package DAO;

import DAO.Interfaces.IDAOService;
import Model.Service;
import Model.Tool;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOService extends DAO implements IDAOService{
    public Service getServiceById(int id) {
        Service service = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT serv_id, serv_name, serv_price, serv_time, serv_count_people, serv_description FROM `service` WHERE serv_id = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                service = new Service();
                service.setServ_id(result.getInt("serv_id"));
                service.setServ_name(result.getString("serv_name"));
                service.setServ_price(result.getFloat("serv_price"));
                service.setServ_time(result.getFloat("serv_time"));
                service.setServ_count_people(result.getInt("serv_count_people"));
                service.setServ_description(result.getString("serv_description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public boolean addService(Service service) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `service` (serv_name, serv_time, serv_price, serv_count_people, serv_description) VALUES(?, ?, ?, ?, ?)");

            statement.setString(1, service.getServ_name());
            statement.setFloat(2, service.getServ_time());
            statement.setFloat(3, service.getServ_price());
            statement.setInt(4, service.getServ_count_people());
            statement.setString(5, service.getServ_description());
            result = statement.executeUpdate() != 0;

            //TODO проверить правильность индекса
            service.setServ_id(getLastAddedId(statement));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delService(Service service) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `service` WHERE serv_id = ?");
            statement.setInt(1, service.getServ_id());
            result = statement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean editService(Service service) {
        boolean result = false;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE `service` SET serv_name = ?, serv_time = ?, serv_count_people = ?, serv_price = ?, serv_description = ? WHERE serv_id = ?");
            statement.setString(1, service.getServ_name());
            statement.setFloat(2, service.getServ_time());
            statement.setInt(3, service.getServ_count_people());
            statement.setFloat(4, service.getServ_price());
            statement.setString(5, service.getServ_description());
            statement.setInt(6, service.getServ_id());

            result = statement.executeUpdate() != 0;
            //service.setServ_id(getLastAddedId(statement));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Service> getAllServices() {
        List<Service> servicesList = new ArrayList<Service>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT serv_id, serv_name, serv_price, serv_time, serv_count_people, serv_description FROM `service`");
            //TODO заменить * последовательностью полей
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Service service = new Service();
                service.setServ_id(result.getInt("serv_id"));
                service.setServ_name(result.getString("serv_name"));
                service.setServ_price(result.getFloat("serv_price"));
                service.setServ_time(result.getFloat("serv_time"));
                service.setServ_count_people(result.getInt("serv_count_people"));
                service.setServ_description(result.getString("serv_description"));
                servicesList.add((service));
            }

        }catch (SQLException e){
            e.printStackTrace();
            //где мое сообщенько!!!
        }

        return servicesList;
    }

    @Override
    public List<Integer> getToolsById(int id) {
        List<Integer> toolIdsList = new ArrayList<Integer>();

        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT tool_id FROM `m2m_serv_tool` WHERE serv_id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                toolIdsList.add(result.getInt("tool_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toolIdsList;
    }

    @Override
    public List<Integer> getMaterialssById(int id) {
        List<Integer> materialIdsList = new ArrayList<Integer>();

        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT material_id FROM `m2m_serv_material` WHERE serv_id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                materialIdsList.add(result.getInt("material_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materialIdsList;
    }

    @Override
    public List<Integer> getEquipmentsById(int id) {
        List<Integer> equipmentIdsList = new ArrayList<Integer>();

        try
        {
            PreparedStatement statement = connection.prepareStatement("SELECT equipment_id FROM `m2m_serv_equipment` WHERE serv_id = ?");
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                equipmentIdsList.add(result.getInt("equipment_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipmentIdsList;
    }
}
