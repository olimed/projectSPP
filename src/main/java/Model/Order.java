package Model;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private int ord_id;
    private float ord_price;
    private LocalDate ord_date;
    private int user_id;
    private int arg_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getArg_id() {
        return arg_id;
    }

    public void setArg_id(int arg_id) {
        this.arg_id = arg_id;
    }

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

    public LocalDate getOrd_date() {
        return ord_date;
    }

    public void setOrd_date(LocalDate ord_date) {
        this.ord_date = ord_date;
    }
}
