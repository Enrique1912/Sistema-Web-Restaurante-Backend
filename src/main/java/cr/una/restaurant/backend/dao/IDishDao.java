package cr.una.restaurant.backend.dao;
import cr.una.restaurant.backend.exception.DishNotFoundException;
import cr.una.restaurant.backend.model.Dish;

public interface IDishDao {
    public Dish findById (final long id) throws DishNotFoundException;
    public Dish add (final Dish Dish);
    public Dish update (final Dish Dish);
    public void delete(final Dish Dish);
    public void deleteById (final long id) throws DishNotFoundException;
}

