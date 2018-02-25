package Model;

import java.util.Date;

public class Comment {
    private int comment_id;
    private String comment_teat;
    private Date comment_date;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_teat() {
        return comment_teat;
    }

    public void setComment_teat(String comment_teat) {
        this.comment_teat = comment_teat;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }
}
