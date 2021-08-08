package cr.una.restaurant.backend.dao;

import cr.una.restaurant.backend.exception.CategoryNotFoundException;
import cr.una.restaurant.backend.model.Category;

public interface ICategoryDao {
    public Category findById (final long id) throws CategoryNotFoundException;
    public Category add (final Category Category);
    public Category update (final Category Category);
    public void delete(final Category Category);
    public void deleteById (final long id) throws CategoryNotFoundException;
}

