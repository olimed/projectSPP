package Model;

public class Agreements {
    private int agr_id;
    private String agr_templete;
    int parentServiceId;

    public int getParentServiceId() {
        return parentServiceId;
    }

    public void setParentServiceId(int parentServiceId) {
        this.parentServiceId = parentServiceId;
    }

    public int getAgr_id() {
        return agr_id;
    }
    //TODO what "setAgr_id(int agr_id) {this.agr_id = agr_id;}" means??????????????????
    public void setAgr_id(int agr_id) {
        this.agr_id = agr_id;
    }

    public String getAgr_templete() {
        return agr_templete;
    }

    public void setAgr_templete(String agr_templete) {
        this.agr_templete = agr_templete;
    }
}
