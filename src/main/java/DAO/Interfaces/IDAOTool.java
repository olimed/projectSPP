package DAO.Interfaces;

import Model.Tool;

import java.util.List;

public interface IDAOTool {
    //TODO один запрос на возвращение всех tool услуги
    Tool getToolById(int id);
    boolean addTool(Tool tool);
    boolean delTool(Tool tool);
    boolean editTool(Tool tool);
    List<Tool> getAllTools();

}
