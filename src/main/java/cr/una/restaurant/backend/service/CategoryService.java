package cr.una.restaurant.backend.service;

import cr.una.restaurant.backend.dao.ICategoryDao;
import cr.una.restaurant.backend.exception.CategoryNotFoundException;
import cr.una.restaurant.backend.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryDao dao;


    @Override
    public Category findById(long id) throws CategoryNotFoundException {
        return dao.findById(id);
    }

    @Override
    public Category add(Category category) {
        return dao.add(category);
    }

    @Override
    public Category update(Category category) {
        return dao.update(category);
    }

    @Override
    public void delete(Category category) {
        dao.delete(category);
    }

    @Override
    public void deleteById(long id) throws CategoryNotFoundException {
        dao.deleteById(id);
    }
}
