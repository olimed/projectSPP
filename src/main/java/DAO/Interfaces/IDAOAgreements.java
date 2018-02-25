package DAO.Interfaces;

import Model.Agreements;

import java.util.List;

public interface IDAOAgreements {
    Agreements getAgreementsByID(int ID);
    boolean addAgreements(Agreements agreement);
    boolean delAgreements(Agreements agreement);
    boolean editAgreement(Agreements agreement);
    List<Agreements> getAllAgreements();
}
