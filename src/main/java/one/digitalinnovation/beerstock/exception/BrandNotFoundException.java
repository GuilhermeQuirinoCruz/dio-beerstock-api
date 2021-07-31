package one.digitalinnovation.beerstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BrandNotFoundException extends Exception {

    public BrandNotFoundException(String brandName) {
        super(String.format("Brand with name %s not found in the system.", brandName));
    }
}
