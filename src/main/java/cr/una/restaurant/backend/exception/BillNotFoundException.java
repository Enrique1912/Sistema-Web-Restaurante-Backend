package cr.una.restaurant.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Bill not found")

public class BillNotFoundException  extends Exception  {
    private static final long serialVersionUID = 1L;


    public BillNotFoundException(String message) {
        super(message);
    }
}
