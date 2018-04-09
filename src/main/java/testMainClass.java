import DAO.DAOAgreements;
import DAO.DAOCertificate;
import DAO.DAOService;
import Model.Agreements;
import Model.Certificate;
import Model.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class testMainClass {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");
        /*
        DAOService daoService = new DAOService();
        Service service = new Service();
        service.setServ_count_people(1);
        service.setServ_time(13);
        service.setServ_description("bla-bla-bla");
        service.setServ_name("Another one service");
        service.setServ_price(1500);
        boolean res= daoService.addService(service);
        service = daoService.getServiceById(2);
        service.setServ_price(15555);
        service.setServ_description("pum-pum");
        res = daoService.editService(service);
        service = daoService.getServiceById(100);

        List<Service> allServices = daoService.getAllServices();
        List<Integer> allTools = daoService.getToolsById(1);
        List<Integer> allMaterials = daoService.getMaterialssById(1);
        List<Integer> allEquipments = daoService.getEquipmentsById(1);
        */
        //TODO Lists of tools/materials/equipments + time_to_use?
//////////////////////////////////////////////////////////////////////////////////////////////
        /*
        DAOAgreements daoagreement = new DAOAgreements();
        Agreements agreement = new Agreements();
        agreement.setParentServiceId(4);
        agreement.setAgr_templete("pum-pu-rum");
        //??public void setAgr_id(int agr_id)

        boolean res = daoagreement.addAgreements(agreement);

        agreement = daoagreement.getAgreementsByID(1);
        agreement.setAgr_templete("pam-pam-pam");

        res = daoagreement.editAgreement(agreement);

        agreement = daoagreement.getAgreementsByID(4);

        int agr_id = agreement.getAgr_id();
        int parentServId = agreement.getParentServiceId();
        String template = agreement.getAgr_templete();

        res = daoagreement.delAgreements(agreement);

        List<Agreements> allAgreements = daoagreement.getAllAgreements();
        */
/////////////////////////////////////////////////////////////////////////////////////////////////

        //??public void setCertificate_id(int certificate_id)
        DAOCertificate daoCertificate = new DAOCertificate();
        Certificate certificate = new Certificate();

        certificate.setCertificate_doc("certificate_doc");
        certificate.setCertificate_name("certificate_name");
        certificate.setCertificate_date(Date.valueOf(LocalDate.of(2018,4,9)));
        certificate.setCertificate_validity(Date.valueOf(LocalDate.of(2020,4,9)));

        boolean res = daoCertificate.addCertificate(certificate);

        certificate = daoCertificate.getCertificateById(2);
        int certificateID = certificate.getCertificate_id();
        String certificateDoc = certificate.getCertificate_doc();
        String certificateName = certificate.getCertificate_name();
        Date certificateDate = certificate.getCertificate_date();
        Date certificateValidity = certificate.getCertificate_validity();

        certificate.setCertificate_name("Another one name");

        res = daoCertificate.editCertificate(certificate);

        certificate = daoCertificate.getCertificateById(3);
        daoCertificate.delCertificate(certificate);

        List<Certificate> allCertificates = daoCertificate.getAllCertificates();
        }
}