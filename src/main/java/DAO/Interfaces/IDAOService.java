package DAO.Interfaces;

import Model.Service;

import java.util.List;

public interface IDAOService {
    Service getServiceById(int id);
    boolean addService(Service service);
    boolean delService(Service service);
    boolean editService(Service service);
    List<Service> getAllServices();
    List<Integer> getToolsById(int id);
}
