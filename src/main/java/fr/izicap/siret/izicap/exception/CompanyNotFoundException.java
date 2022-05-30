package fr.izicap.siret.izicap.exception;

public class CompanyNotFoundException extends Exception {

    public CompanyNotFoundException(String siret) {
        super("No company found with a Siret=" + siret);
    }
}
