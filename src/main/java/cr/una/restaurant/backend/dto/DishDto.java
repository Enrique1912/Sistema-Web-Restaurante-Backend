package cr.una.restaurant.backend.dto;
import cr.una.restaurant.backend.model.Dish;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class DishDto {
    private Long idDish;
    @NotBlank(message = "nameDish's label is not completed,please try again")
    private String nameDish;
    private int quantity;
    @NotBlank(message = "PriceOfTheDish's label is not completed,please try again")
    private int priceOfTheDish;
}
