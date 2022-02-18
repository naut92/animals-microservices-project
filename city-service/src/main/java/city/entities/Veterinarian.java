package city.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Veterinarian {
    private Long id;
    private Long city_id;
    //private Long county_id;
    //private Long customer_id;
    private String firstname;
    private String lastname;
    private String email;
    private City cityById;
    private List<County> counties;
    private List<Customer> customers;
}
