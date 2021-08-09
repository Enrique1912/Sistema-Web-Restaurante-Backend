package cr.una.restaurant.backend.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table( name = "dish" )
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dish")
    @Getter @Setter
    private Long idDish;
    @Column(name = "nameDish")
    @Getter @Setter
    private String nameDish;
    @ManyToOne
    @JoinColumn(name="id_category", nullable=false)
    @Getter @Setter
    @JsonIgnore
    private Category category;
}
