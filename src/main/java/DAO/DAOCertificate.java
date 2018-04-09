package DAO;

import DAO.Interfaces.IDAOCertificate;
import Model.Certificate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCertificate extends DAO implements IDAOCertificate{

    public Certificate getCertificateById(int id){
        Certificate certificate = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT certificate_id, certificate_doc, certificate_name, certificate_date, certificate_validity FROM `certificates` WHERE certificate_id = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                certificate = new Certificate();
                certificate.setCertificate_id(result.getInt("certificate_id"));
                certificate.setCertificate_doc(result.getString("certificate_doc"));
                certificate.setCertificate_name(result.getString("certificate_name"));
                certificate.setCertificate_date(result.getDate("certificate_date"));
                certificate.setCertificate_validity(result.getDate("certificate_validity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return certificate;
    }

    public boolean addCertificate(Certificate certificate) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO `certificates` (certificate_doc, certificate_name, certificate_date, certificate_validity) VALUES(?, ?, ?, ?)");

            statement.setString(1, certificate.getCertificate_doc());
            statement.setString(2, certificate.getCertificate_name());
            statement.setDate(3, certificate.getCertificate_date());
            statement.setDate(4, certificate.getCertificate_validity());
            result = statement.executeUpdate() != 0;
            certificate.setCertificate_id(getLastAddedId(statement));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delCertificate(Certificate certificate) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM `certificates` WHERE certificate_id = ?");
            statement.setInt(1, certificate.getCertificate_id());
            result = statement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean editCertificate(Certificate certificate) {
        boolean result = false;
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE `certificates` SET certificate_doc = ?, certificate_name = ?, certificate_date = ?, certificate_validity = ? WHERE certificate_id = ?");
            statement.setString(1, certificate.getCertificate_doc());
            statement.setString(2, certificate.getCertificate_name());
            statement.setDate(3, certificate.getCertificate_date());
            statement.setDate(4, certificate.getCertificate_validity());
            statement.setInt(5, certificate.getCertificate_id());

            result = statement.executeUpdate() != 0;
            certificate.setCertificate_id(getLastAddedId(statement));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Certificate> getAllCertificates() {
        List<Certificate> certificatesList = new ArrayList<Certificate>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT certificate_id, certificate_doc, certificate_name, certificate_date, certificate_validity FROM `certificates`");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Certificate certificate = new Certificate();
                certificate.setCertificate_id(result.getInt("certificate_id"));
                certificate.setCertificate_doc(result.getString("certificate_doc"));
                certificate.setCertificate_name(result.getString("certificate_name"));
                certificate.setCertificate_date(result.getDate("certificate_date"));
                certificate.setCertificate_validity(result.getDate("certificate_validity"));
                certificatesList.add((certificate));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return certificatesList;
    }
}
