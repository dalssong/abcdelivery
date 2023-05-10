package abcdelivery.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "FoodSearch_table")
@Data
public class FoodSearch {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
