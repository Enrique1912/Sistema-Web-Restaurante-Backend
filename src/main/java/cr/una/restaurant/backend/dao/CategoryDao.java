package cr.una.restaurant.backend.dao;
import com.google.common.base.Preconditions;
import cr.una.restaurant.backend.exception.CategoryNotFoundException;
import cr.una.restaurant.backend.model.Category;
import org.springframework.stereotype.Repository;
@Repository
public class CategoryDao extends AbstractHibernateDao implements ICategoryDao {

    @Override
    public Category findById(final long id) throws CategoryNotFoundException {
        Category Category = (Category) getCurrentSession().get(Category.class, id);
        if (Category == null) {
            throw new CategoryNotFoundException("Category no fue encontrada");
        } else {
            return Category;
        }
    }

    @Override
    public Category add(Category Category) {
        Preconditions.checkNotNull(Category);
        getCurrentSession().saveOrUpdate(Category);

        return Category;
    }


    @Override
    public Category update(Category Category) {
        Preconditions.checkNotNull(Category);
        return (Category) getCurrentSession().merge(Category);
    }

    @Override
    public void delete(Category Category) {
        Preconditions.checkNotNull(Category);
        getCurrentSession().delete(Category);
    }

    @Override
    public void deleteById(long id) throws CategoryNotFoundException {
        final Category Category = findById(id);
        Preconditions.checkState(Category != null);
        delete(Category);
    }
}
