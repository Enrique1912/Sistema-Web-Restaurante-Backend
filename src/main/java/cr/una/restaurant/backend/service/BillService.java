package cr.una.restaurant.backend.service;
import cr.una.restaurant.backend.dao.IBillDao;
import cr.una.restaurant.backend.exception.BillNotFoundException;
import cr.una.restaurant.backend.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BillService implements IBillService{
    @Autowired
    private IBillDao dao;


    @Override
    public Bill findById(long id) throws BillNotFoundException {
        return dao.findById(id);
    }

    @Override
    public Bill add(Bill bill) {
        return dao.add(bill);
    }

    @Override
    public Bill update(Bill bill) {
        return dao.update(bill);
    }

    @Override
    public void delete(Bill bill) {
        dao.delete(bill);
    }

    @Override
    public void deleteById(long id) throws BillNotFoundException {
        dao.deleteById(id);
    }
}
