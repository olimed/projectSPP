package DAO.Interfaces;

import Model.Material;

import java.util.List;

public interface IDAOMaterial {
    Material getMaterialById(int id);
    boolean addMaterial(Material material);
    boolean delMaterial(Material material);
    boolean editMaterial(Material material);
    List<Material> getAllMaterials();
}
