package cr.una.restaurant.backend.service;

import cr.una.restaurant.backend.exception.BillNotFoundException;
import cr.una.restaurant.backend.model.Bill;

public interface IBillService {
    public Bill findById (final long id) throws BillNotFoundException;
    public Bill add (final Bill bill);
    public Bill update (final Bill bill);
    public void delete(final Bill bill);
    public void deleteById (final long id) throws BillNotFoundException;

}