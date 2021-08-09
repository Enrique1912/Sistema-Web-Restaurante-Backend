package cr.una.restaurant.backend.service;

import cr.una.restaurant.backend.exception.CategoryNotFoundException;
import cr.una.restaurant.backend.model.Category;
import org.springframework.context.annotation.Bean;

public interface ICategoryService {
    public Category findById (final long id) throws CategoryNotFoundException;
    public Category add (final Category category);
    public Category update (final Category category);
    public void delete(final Category category);
    public void deleteById (final long id) throws CategoryNotFoundException;

}
