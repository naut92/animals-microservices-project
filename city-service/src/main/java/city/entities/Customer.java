package city.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class Customer{
    private Long id;
    private Long city_id;
    private Long county_id;
    //private Long veterinarian_id;
    private String firstname;
    private String lastname;
    private String email;
    private List<Veterinarian> veterinarians;
    private City cityById;
    private County countyById;
}