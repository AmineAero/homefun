package fr.izicap.siret.izicap.exception;

public class IzicapTechnicalException extends Exception {

    public IzicapTechnicalException(String message) {
        super("Technical exception is occured, please contact the admins.");
    }
}
