package Model;

import java.util.Date;

public class Certificate {
    private int certificate_id;
    private String certificate_doc;
    private String certificate_name;
    private Date certificate_date;
    private Date certificate_validity;

    public int getCertificate_id() {
        return certificate_id;
    }

    public void setCertificate_id(int certificate_id) {
        this.certificate_id = certificate_id;
    }

    public String getCertificate_doc() {
        return certificate_doc;
    }

    public void setCertificate_doc(String certificate_doc) {
        this.certificate_doc = certificate_doc;
    }

    public String getCertificate_name() {
        return certificate_name;
    }

    public void setCertificate_name(String certificate_name) {
        this.certificate_name = certificate_name;
    }

    public Date getCertificate_date() {
        return certificate_date;
    }

    public void setCertificate_date(Date certificate_date) {
        this.certificate_date = certificate_date;
    }

    public Date getCertificate_validity() {
        return certificate_validity;
    }

    public void setCertificate_validity(Date certificate_validity) {
        this.certificate_validity = certificate_validity;
    }
}
