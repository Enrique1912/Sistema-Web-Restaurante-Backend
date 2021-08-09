package cr.una.restaurant.backend.service;

import cr.una.restaurant.backend.dao.IDishDao;
import cr.una.restaurant.backend.exception.DishNotFoundException;
import cr.una.restaurant.backend.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DishService implements IDishService{
    @Autowired
    private IDishDao dao;


    @Override
    public Dish findById(long id) throws DishNotFoundException {
        return dao.findById(id);
    }

    @Override
    public Dish add(Dish dish) {
        return dao.add(dish);
    }

    @Override
    public Dish update(Dish dish) {
        return dao.update(dish);
    }

    @Override
    public void delete(Dish dish) {
        dao.delete(dish);
    }

    @Override
    public void deleteById(long id) throws DishNotFoundException {
        dao.deleteById(id);
    }
}
