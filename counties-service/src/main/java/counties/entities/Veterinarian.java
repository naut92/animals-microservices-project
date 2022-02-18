package counties.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class Veterinarian {
    private Long id;
    private Long city_id;
    private String firstname;
    private String lastname;
    private String email;
    private City cityById;
    private List<County> counties;
    private List<Customer> customers;
}
