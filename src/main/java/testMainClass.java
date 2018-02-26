import DAO.DAOAgreements;
import DAO.DAOService;
import Model.Agreements;
import Model.Service;

public class testMainClass {
    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, World");

        DAOService daoService = new DAOService();
        Service service = new Service();
        service.setServ_count_people(1);
        service.setServ_time(13);
        service.setServ_description("bla-bla-bla");
        service.setServ_name("First service");
        service.setServ_price(1500);
        boolean res = daoService.addService(service);

        /*DAOAgreements daoAgreements = new DAOAgreements();
        Agreements agreements = new Agreements();
        agreements.setAgr_templete(
*/
    }
}
