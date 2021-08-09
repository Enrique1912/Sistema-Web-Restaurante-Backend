package cr.una.restaurant.backend.webservice;
import cr.una.restaurant.backend.comun.Constants;
import cr.una.restaurant.backend.dto.CategoryDto;
import cr.una.restaurant.backend.exception.CategoryNotFoundException;
import cr.una.restaurant.backend.model.Category;
import cr.una.restaurant.backend.model.Dish;
import cr.una.restaurant.backend.service.CategoryService;
import cr.una.restaurant.backend.service.ICategoryService;
import cr.una.restaurant.backend.service.IDishService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;

@Controller
@CrossOrigin
@RequestMapping(value = Constants.URL_PREFIX + "categories")
public class CategoryController {

    @Autowired
    private ICategoryService service = new CategoryService();

    @Autowired
    private IDishService serviceDishes;


    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("{id}")
    @ResponseBody
    public CategoryDto findById(@PathVariable Long id) throws CategoryNotFoundException {
        Category category = service.findById(id);
        return convertToDto(category);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CategoryDto add(@Valid @RequestBody CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category categoryBD=service.add(category);
        Dish newDish;
        for(int i=0; i<categoryDto.getDishes().size() ;i++){
            newDish=categoryDto.getDishes().get(i);
            newDish.setCategory(categoryBD);
            serviceDishes.add(newDish);
        }
        return convertToDto(category);
       // return categoryBD;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CategoryDto update(@Valid @RequestBody CategoryDto categoryDto) {
        Category category = convertToEntity(categoryDto);
        return convertToDto(service.update(category));
    }

    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        try {
            service.deleteById(id);
        } catch (CategoryNotFoundException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "Category Not Found", ex);
        }
    }

    /*Convert to Dto methods*/
    private CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
        int size=categoryDto.getDishes().size();
        return categoryDto;
    }

    private Category convertToEntity(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return category;
    }
}
