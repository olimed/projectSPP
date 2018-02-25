package DAO.Interfaces;

import Model.Certificate;

import java.util.List;

public interface IDAOCertificate {
    Certificate getCertificateById(int id);
    boolean addCertificate(Certificate certificate);
    boolean delCertificate(Certificate certificate);
    boolean editCertificate(Certificate certificate);
    List<Certificate> getAllCertificates();
}
