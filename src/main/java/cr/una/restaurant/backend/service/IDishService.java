package cr.una.restaurant.backend.service;

import cr.una.restaurant.backend.exception.DishNotFoundException;
import cr.una.restaurant.backend.model.Dish;

public interface IDishService {
    public Dish findById (final long id) throws DishNotFoundException;
    public Dish add (final Dish dish);
    public Dish update (final Dish dish);
    public void delete(final Dish dish);
    public void deleteById (final long id) throws DishNotFoundException;

}

