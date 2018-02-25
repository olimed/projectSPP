package DAO;

import DAO.Interfaces.IDAOAgreements;
import Model.Agreements;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAOAgreements extends DAO implements IDAOAgreements {

    public Agreements getAgreementsByID(int ID) {
        Connection connection = ConnectionManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM service");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Service service = new Service();
                service.setServ_name(result.getString("serv_name"));
                servicesList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
    public static List<Service> readAll() {
        Connection connection = ConnectionManager.getConnection();
        List<Service> servicesList = new ArrayList<Service>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM service");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Service service = new Service();
                service.setServ_name(result.getString("serv_name"));
                servicesList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicesList;
    }