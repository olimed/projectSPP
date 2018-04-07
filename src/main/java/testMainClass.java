import DAO.DAOAgreements;
import DAO.DAOService;
import Model.Agreements;
import Model.Service;

import java.util.List;

public class testMainClass {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");

        //DAOService daoService = new DAOService();
        //Service service = new Service();
        //service.setServ_count_people(1);
        //service.setServ_time(13);
        //service.setServ_description("bla-bla-bla");
        //service.setServ_name("Another one service");
        //service.setServ_price(1500);
        boolean res;
        //res= daoService.addService(service);
        //////////////////////////////////////////////////////////////////////////////////////////////
        //service = daoService.getServiceById(2);
        //////////////////////////////////////////////////////////////////////////////////////////////
        //service.setServ_price(15555);
        //service.setServ_description("pum-pum");
        //////////////////////////////////////////////////////////////////////////////////////////////
        //res = daoService.editService(service);
//////////////////////////////////////////////////////////////////////////////////////////////
        //service = daoService.getServiceById(100);
//////////////////////////////////////////////////////////////////////////////////////////////

        //List<Service> allServices = daoService.getAllServices();
        //List<Integer> allTools = daoService.getToolsById(1);
        //List<Integer> allMaterials = daoService.getMaterialssById(1);
        //List<Integer> allEquipments = daoService.getEquipmentsById(1);
        //TODO Lists of tools/materials/equipments + time_to_use?

        DAOAgreements daoagreement = new DAOAgreements();
        Agreements agreement = new Agreements();
        agreement.setParentServiceId(2);
        agreement.setAgr_templete("la-la-la");
        //??public void setAgr_id(int agr_id)

        daoagreement.addAgreements(agreement);

        agreement = daoagreement.getAgreementsByID(1);
        agreement.setAgr_templete("pam-pam-pam");
        daoagreement.editAgreement(agreement);

        agreement = daoagreement.getAgreementsByID(2);

        int agr_id = agreement.getAgr_id();
        int parentServId = agreement.getParentServiceId();
        String template = agreement.getAgr_templete();

        res = daoagreement.delAgreements(agreement);

        List<Agreements> allAgreements = daoagreement.getAllAgreements();


    }
}