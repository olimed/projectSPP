package Model;


import java.util.Date;

public class Equipment {
    private int equipment_id;
    private String equipment_name;
    private String equipment_state_number;
    private String equipment_mark;
    private String equipment_model;
    private Date equipment_year;

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public String getEquipment_state_number() {
        return equipment_state_number;
    }

    public void setEquipment_state_number(String equipment_state_number) {
        this.equipment_state_number = equipment_state_number;
    }

    public String getEquipment_mark() {
        return equipment_mark;
    }

    public void setEquipment_mark(String equipment_mark) {
        this.equipment_mark = equipment_mark;
    }

    public String getEquipment_model() {
        return equipment_model;
    }

    public void setEquipment_model(String equipment_model) {
        this.equipment_model = equipment_model;
    }

    public Date getEquipment_year() {
        return equipment_year;
    }

    public void setEquipment_year(Date equipment_year) {
        this.equipment_year = equipment_year;
    }
}
