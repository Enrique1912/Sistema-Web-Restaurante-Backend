package cr.una.restaurant.backend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_category")
    @Getter @Setter
    private Long idCategory;
    @Column(name = "name_category")
    @Getter @Setter
    private String nameCategory;

    @OneToMany(mappedBy = "category")
    private Set<Dish> dishes;

    public Category(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Category() {

    }
}
