package Model;

import java.util.Date;

public class Order {
    private int ord_id;
    private float ord_price;
    private Date ord_date;

    public int getOrd_id() {
        return ord_id;
    }

    public void setOrd_id(int ord_id) {
        this.ord_id = ord_id;
    }

    public float getOrd_price() {
        return ord_price;
    }

    public void setOrd_price(float ord_price) {
        this.ord_price = ord_price;
    }

    public Date getOrd_date() {
        return ord_date;
    }

    public void setOrd_date(Date ord_date) {
        this.ord_date = ord_date;
    }
}
