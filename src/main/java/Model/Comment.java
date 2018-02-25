package Model;

//import java.util.Date;
import java.sql.Date;

public class Comment {
    private int comment_id;
    private String comment_text;
    private Date comment_date;
    private int comment_user_id;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }

    public  int getComment_user_id(){return comment_user_id;}

    public void setComment_user_id(int comment_user_id){this.comment_user_id = comment_user_id;}
}
