package Model;

public class Service {
    private int serv_id;
    private String serv_name;
    private float serv_time;
    private float serv_price;
    private int serv_count_people;

    public int getServ_id() {
        return serv_id;
    }

    public void setServ_id(int serv_id) {
        this.serv_id = serv_id;
    }

    public String getServ_name() {
        return serv_name;
    }

    public void setServ_name(String serv_name) {
        this.serv_name = serv_name;
    }

    public float getServ_time() {
        return serv_time;
    }

    public void setServ_time(float serv_time) {
        this.serv_time = serv_time;
    }

    public float getServ_price() {
        return serv_price;
    }

    public void setServ_price(float serv_price) {
        this.serv_price = serv_price;
    }

    public int getServ_count_people() {
        return serv_count_people;
    }

    public void setServ_count_people(int serv_count_people) {
        this.serv_count_people = serv_count_people;
    }
}
