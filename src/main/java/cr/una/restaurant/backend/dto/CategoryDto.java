package cr.una.restaurant.backend.dto;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CategoryDto {
    @NotBlank(message = "Label of idCategory is not complete, try again")
    private Long idCategory;
    @NotBlank(message = "Label of nameCategory is not complete, try again")
    private String nameCategory;
}
