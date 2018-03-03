package DAO;

import DAO.Interfaces.IDAOAgreements;
import Model.Agreements;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOAgreements extends DAO implements IDAOAgreements {

    public Agreements getAgreementsByID(int ID) {
        Agreements agreement = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `agreements` WHERE adr_id=?");
            statement.setInt(1, ID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                agreement = new Agreements();
                agreement.setAgr_id(result.getInt("agr_id"));
                agreement.setAgr_templete(result.getString("agr_template"));
                agreement.setParentServiceId(result.getInt("service_serv_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agreement;
    }

    public boolean addAgreements(Agreements agreement){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `agreements` (agr_template, service_serv_id) VALUES (?,?)");
            //TODO добавить FK на service_serv_id
            statement.setString(1, agreement.getAgr_templete());
            statement.setInt(2,agreement.getParentServiceId());
            boolean result = statement.executeUpdate()!=0;
            //TODO проверить правильность индекса
            agreement.setAgr_id(getLastAddedId(statement));
            return result;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean delAgreements(Agreements agreement) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM `agreements` WHERE agr_id = ?");
            statement.setInt(1, agreement.getAgr_id());
            result = statement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean editAgreement(Agreements agreement) {
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE `agreements` SET agr_template = ?, service_serv_id = ? WHERE agr_id = ?)");
            statement.setString(1, agreement.getAgr_templete());
            statement.setInt(2,agreement.getParentServiceId());
            statement.setInt(3,agreement.getAgr_id());
            boolean result = statement.executeUpdate() != 0;
            return result;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Agreements> getAllAgreements() {
        List<Agreements> agreementsList = new ArrayList<Agreements>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `agreements`");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Agreements agreement = new Agreements();
                agreement.setAgr_id(result.getInt("agr_id"));
                agreement.setAgr_templete(result.getString("agr_template"));
                //TODO Проверить правильность установки родительской услуги
                agreement.setParentServiceId(result.getInt("service_serv_id"));
                agreementsList.add((agreement));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return agreementsList;
    }
}
