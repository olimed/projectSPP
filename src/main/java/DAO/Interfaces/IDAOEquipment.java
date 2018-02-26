package DAO.Interfaces;

import Model.Equipment;

import java.util.List;

public interface IDAOEquipment {
    Equipment getEquipmentById(int id);
    boolean addEquipment(Equipment equipment);
    boolean delEquipment(Equipment equipment);
    boolean editEquipment(Equipment equipment);
    List<Equipment> getAllEquipments();
}
