package cr.una.restaurant.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bill")
    @Getter @Setter
    private Long idBill;
    @Column(name = "delivery_or_pickup")//1 si es delivery o 0 si es pickup
    @Getter @Setter
    private boolean deliveryOrPickUp;
    @Column(name = "subTotal")
    @Getter @Setter
    private int subTotal;
    @Column(name = "coupon_code")
    @Getter @Setter
    private boolean couponCode;

    ///One Bill has many dishes
    @OneToMany(mappedBy="bill")
    private List<Dish> dishes;


}
