package cr.una.restaurant.backend.dao;
import com.google.common.base.Preconditions;
import cr.una.restaurant.backend.exception.CategoryNotFoundException;
import cr.una.restaurant.backend.model.Category;
import org.springframework.stereotype.Repository;
import cr.una.restaurant.backend.exception.DishNotFoundException;
import cr.una.restaurant.backend.model.Dish;
@Repository
public class DishDao extends AbstractHibernateDao implements IDishDao {
    @Override
    public Dish findById(final long id) throws DishNotFoundException {
        Dish Dish = (Dish) getCurrentSession().get(Dish.class, id);
        if (Dish == null) {
            throw new DishNotFoundException("Dish no fue encontrada");
        } else {
            return Dish;
        }
    }

    @Override
    public Dish add(Dish Dish) {
        Preconditions.checkNotNull(Dish);
        getCurrentSession().saveOrUpdate(Dish);

        return Dish;
    }


    @Override
    public Dish update(Dish Dish) {
        Preconditions.checkNotNull(Dish);
        return (Dish) getCurrentSession().merge(Dish);
    }

    @Override
    public void delete(Dish Dish) {
        Preconditions.checkNotNull(Dish);
        getCurrentSession().delete(Dish);
    }

    @Override
    public void deleteById(long id) throws DishNotFoundException {
        final Dish Dish = findById(id);
        Preconditions.checkState(Dish != null);
        delete(Dish);
    }
}
