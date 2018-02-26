package DAO;

import DAO.Interfaces.IDAOEquipment;
import Model.Equipment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEquipment extends DAO implements IDAOEquipment{
    @Override
    public Equipment getEquipmentById(int id) {
        Equipment equipment = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM equipments WHERE equipment_id = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                equipment = new Equipment();
                equipment.setEquipment_id(result.getInt("equipment_id"));
                equipment.setEquipment_name(result.getString("equipment_name"));
                equipment.setEquipment_mark(result.getString("equipment_mark"));
                equipment.setEquipment_model(result.getString("equipment_model"));
                equipment.setEquipment_state_number(result.getString("equipment_state_number"));
                equipment.setEquipment_year(result.getDate("equipment_issue_year"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipment;
    }

    @Override
    public boolean addEquipment(Equipment equipment) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO equipments ('equipment_name', 'equipment_state_number', 'equipment_mark', 'equipment_model', 'equipment_issue_year') VALUES(?, ?, ?, ?, ?)");

            statement.setString(1, equipment.getEquipment_name());
            statement.setString(2, equipment.getEquipment_state_number());
            statement.setString(3, equipment.getEquipment_mark());
            statement.setString(4, equipment.getEquipment_model());
            statement.setDate(5, equipment.getEquipment_year());
            result = statement.execute();
            equipment.setEquipment_id(statement.getGeneratedKeys().getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delEquipment(Equipment equipment) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM equipments WHERE equipment_id = ?");
            statement.setInt(1, equipment.getEquipment_id());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean editEquipment(Equipment equipment) {
        boolean result = false;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE equipments SET equipment_name = ?, equipment_state_number = ?, equipment_mark = ?, equipment_model = ?, equipment_issure_year = ? WHERE equipment_id = ?)");
            statement.setString(1, equipment.getEquipment_name());
            statement.setString(2, equipment.getEquipment_state_number());
            statement.setString(3, equipment.getEquipment_mark());
            statement.setString(4, equipment.getEquipment_model());
            statement.setDate(5, equipment.getEquipment_year());

            result = statement.execute();
            equipment.setEquipment_id(statement.getGeneratedKeys().getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Equipment> getAllEquipments() {
        List<Equipment> equipmentsList = new ArrayList<Equipment>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM equipments");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Equipment equipment = new Equipment();
                equipment.setEquipment_name(result.getString("material_name"));
                equipment.setEquipment_mark(result.getString("equipment_mark"));
                equipment.setEquipment_model(result.getString("equipment_model"));
                equipment.setEquipment_state_number(result.getString("equipment_state_number"));
                equipment.setEquipment_year(result.getDate("equipment_issue_year"));
                equipmentsList.add((equipment));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return equipmentsList;
    }
}
