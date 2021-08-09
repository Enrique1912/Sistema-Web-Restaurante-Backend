package cr.una.restaurant.backend.dto;
import cr.una.restaurant.backend.model.Dish;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class CategoryDto {
    private Long idCategory;
    @NotBlank(message = "Label of nameCategory is not complete, try again")
    private String nameCategory;
    private List<Dish> dishes;
}
