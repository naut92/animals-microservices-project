package veterinarians.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class City {
    private Long id;
    private String name;
    private List<County> countyById;
    private List<Veterinarian> veterinarianById;
    private List<Customer> customerById;
}
