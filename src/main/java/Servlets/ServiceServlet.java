package Servlets;

import DAO.DAOAgreements;
import DAO.DAOService;
import Model.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/services")
public class ServiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        DAOService daoService = new DAOService();
        List<Service> services = daoService.getAllServices();

        req.getRequestDispatcher("services.jsp").forward(req, resp);
    }
}
