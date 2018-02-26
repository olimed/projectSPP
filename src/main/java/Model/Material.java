package Model;

public class Material {
    private int material_id;
    private String material_name;
    private String material_mark;
    private String material_price;

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public String getMaterial_mark() {
        return material_mark;
    }

    public void setMaterial_mark(String material_mark) {
        this.material_mark = material_mark;
    }

    public String getMaterial_price() {
        return material_price;
    }

    public void setMaterial_price(float material_price) {
        this.material_price = material_price;
    }
}
