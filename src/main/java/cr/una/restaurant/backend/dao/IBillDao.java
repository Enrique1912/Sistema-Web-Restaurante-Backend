package cr.una.restaurant.backend.dao;

import cr.una.restaurant.backend.exception.BillNotFoundException;
import cr.una.restaurant.backend.model.Bill;


public interface IBillDao {
    public Bill findById (final long id) throws BillNotFoundException;
    public Bill add (final Bill Category);
    public Bill update (final Bill Category);
    public void delete(final Bill Category);
    public void deleteById (final long id) throws BillNotFoundException;
}
