package cr.una.restaurant.backend.dao;
import com.google.common.base.Preconditions;
import cr.una.restaurant.backend.exception.BillNotFoundException;
import cr.una.restaurant.backend.model.Bill;
import org.springframework.stereotype.Repository;

@Repository
public class BillDao extends AbstractHibernateDao implements IBillDao {

    @Override
    public Bill findById(final long id) throws BillNotFoundException {
        Bill Bill = (Bill) getCurrentSession().get(Bill.class, id);
        if (Bill == null) {
            throw new BillNotFoundException("Bill no fue encontrada");
        } else {
            return Bill;
        }
    }

    @Override
    public Bill add(Bill bill) {
        Preconditions.checkNotNull(bill);
        getCurrentSession().saveOrUpdate(bill);

        return bill;
    }


    @Override
    public Bill update(Bill Bill) {
        Preconditions.checkNotNull(Bill);
        return (Bill) getCurrentSession().merge(Bill);
    }

    @Override
    public void delete(Bill Bill) {
        Preconditions.checkNotNull(Bill);
        getCurrentSession().delete(Bill);
    }

    @Override
    public void deleteById(long id) throws BillNotFoundException {
        final Bill Bill = findById(id);
        Preconditions.checkState(Bill != null);
        delete(Bill);
    }
}
