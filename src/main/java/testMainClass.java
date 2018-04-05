import DAO.DAOAgreements;
import DAO.DAOService;
import Model.Agreements;
import Model.Service;

import java.util.List;

public class testMainClass {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");

        DAOService daoService = new DAOService();
        Service service = new Service();
        service.setServ_count_people(1);
        service.setServ_time(13);
        service.setServ_description("bla-bla-bla");
        service.setServ_name("Another one service");
        service.setServ_price(1500);
        boolean res = daoService.addService(service);
        //////////////////////////////////////////////////////////////////////////////////////////////
        service = daoService.getServiceById(2);
//////////////////////////////////////////////////////////////////////////////////////////////
        service.setServ_price(15555);
        service.setServ_description("pum-pum");
//////////////////////////////////////////////////////////////////////////////////////////////
        res = daoService.editService(service);
//////////////////////////////////////////////////////////////////////////////////////////////
        service = daoService.getServiceById(100);
//////////////////////////////////////////////////////////////////////////////////////////////
        //service = daoService.getServiceById(3);
        //res = daoService.delService(service);

        List<Service> allServices = daoService.getAllServices();
        List<Integer> allTools = daoService.getToolsById(1);
        List<Integer> allMaterials = daoService.getMaterialssById(1);
        List<Integer> allEquipments = daoService.getEquipmentsById(1);
        //TODO Lists of tools/materials/equipments + time_to_use?
        }
}
