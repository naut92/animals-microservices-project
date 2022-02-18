package city.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class County {
    private Long id;
    private String name;
    private Long city_id;
    private City cityById;
    private List<Customer> customerById;
    private List<Veterinarian> veterinarians;
}
