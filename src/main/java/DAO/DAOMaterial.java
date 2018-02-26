package DAO;

import DAO.Interfaces.IDAOMaterial;
import Model.Material;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOMaterial extends DAO implements IDAOMaterial {
    @Override
    public Material getMaterialById(int id) {
        Material material = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM materials WHERE material_id = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                material = new Material();
                material.setMaterial_id(result.getInt("material_id"));
                material.setMaterial_name(result.getString("material_name"));
                material.setMaterial_mark(result.getString("material_mark"));
                material.setMaterial_price(result.getFloat("material_price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return material;
    }

    @Override
    public boolean addMaterial(Material material) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO materials ('material_name', 'material_mark', 'material_price') VALUES(?, ?, ?)");

            statement.setString(1, material.getMaterial_name());
            statement.setString(2,material.getMaterial_mark());
            statement.setString(3,material.getMaterial_price());
            result = statement.execute();
            material.setMaterial_id(statement.getGeneratedKeys().getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delMaterial(Material material) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM materials WHERE material_id = ?");
            statement.setInt(1, material.getMaterial_id());
            result = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean editMaterial(Material material) {
        boolean result = false;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE materials SET material_name = ?, material_mark = ?, material_price = ? WHERE material_id = ?)");
            statement.setString(1, material.getMaterial_name());
            statement.setString(2, material.getMaterial_mark());
            statement.setFloat(3, Float.parseFloat(material.getMaterial_price()));
            statement.setInt(4, material.getMaterial_id());

            result = statement.execute();
            material.setMaterial_id(statement.getGeneratedKeys().getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Material> getAllMaterials() {
        List<Material> materialsList = new ArrayList<Material>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM materials");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Material material = new Material();
                material.setMaterial_name(result.getString("material_name"));
                material.setMaterial_mark(result.getString("material_mark"));
                material.setMaterial_price(Float.parseFloat(result.getString("material_price")));
                materialsList.add((material));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return materialsList;
    }
}
