package cr.una.restaurant.backend.dto;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class DishDto {
    @NotBlank(message = "IdDish's label is not completed")
    private Long idDish;
    @NotBlank(message = "nameDish's label is not completed")
    private String nameDish;
}
