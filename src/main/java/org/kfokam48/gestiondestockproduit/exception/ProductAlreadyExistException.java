package org.kfokam48.gestiondestockproduit.exception;

public class ProductAlreadyExistException extends RuntimeException {

    public ProductAlreadyExistException(String message) {
        super(message);
    }
}
