package org.kfokam48.gestiondestockproduit.exception;

public class ProductStockExhaustedException extends RuntimeException {

    public ProductStockExhaustedException(String message) {
        super(message);
    }
}
