package DAO;

import DAO.Interfaces.IDAOTool;
import Model.Tool;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOTool extends DAO implements IDAOTool{
    public Tool getToolById(int id) {
        Tool tool = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tools WHERE tool_id = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                tool = new Tool();
                tool.setTool_id(result.getInt("tool_id"));
                tool.setTool_name(result.getString("tool_name"));
                tool.setTool_mark(result.getString("tool_mark"));
                tool.setTool_model(result.getString("tool_model"));
                tool.setTool_year(result.getDate("tool_issue_year").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tool;
    }

    public boolean addTool(Tool tool) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tools ('tool_name', 'tool_mark', 'tool_model', 'tool_issure_year') VALUES(?, ?, ?, ?)");

            statement.setString(1, tool.getTool_name());
            statement.setString(1, tool.getTool_mark());
            statement.setString(1, tool.getTool_model());
            statement.setDate(1, Date.valueOf(tool.getTool_year()));
            result = statement.execute();
            tool.setTool_id(statement.getGeneratedKeys().getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delTool(Tool tool) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM tools WHERE tool_id = ?");
            statement.setInt(1, tool.getTool_id());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean editTool(Tool tool) {
        boolean result = false;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE tools SET tool_name = ?, tool_mark = ?, tool_model = ?, tool_issure_year = ? WHERE tool_id = ?)");
            statement.setString(1, tool.getTool_name());
            statement.setString(2, tool.getTool_mark());
            statement.setString(3, tool.getTool_model());
            statement.setDate(4, Date.valueOf(tool.getTool_year()));
            statement.setInt(5, tool.getTool_id());

            result = statement.execute();
            tool.setTool_id(statement.getGeneratedKeys().getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Tool> getAllTools() {
        List<Tool> toolsList = new ArrayList<Tool>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tools");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Tool tool = new Tool();
                tool.setTool_name(result.getString("tool_name"));
                tool.setTool_mark(result.getString("tool_mark"));
                tool.setTool_model(result.getString("tool_model"));
                tool.setTool_year(result.getDate("tool_issue_year").toLocalDate());
                toolsList.add((tool));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return toolsList;
    }
}
