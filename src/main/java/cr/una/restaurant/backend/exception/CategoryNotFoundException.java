package cr.una.restaurant.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Category not found")

public class CategoryNotFoundException  extends Exception  {
    private static final long serialVersionUID = 1L;


    public CategoryNotFoundException(String message) {
        super(message);
    }
}
