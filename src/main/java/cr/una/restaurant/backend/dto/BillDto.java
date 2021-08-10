package cr.una.restaurant.backend.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class BillDto {
    private Long idBill;
    @NotBlank(message = "deliveryOrPickUp's label is not completed,please try again")
    private boolean deliveryOrPickUp;
    @NotBlank(message = "subTotal's label is not completed,please try again")
    private int subTotal;
    private boolean couponCode;
    //private List<Dish> dishes;
}
