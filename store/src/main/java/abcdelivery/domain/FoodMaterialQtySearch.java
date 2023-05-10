package abcdelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FoodMaterialQtySearch_table")
@Data
public class FoodMaterialQtySearch {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
