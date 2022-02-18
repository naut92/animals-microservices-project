package animals_app.entities;

import animals_app.entities.intf.SimpleIdentifiableEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City  extends SimpleIdentifiableEntity {

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityById", cascade = CascadeType.ALL)
    private List<County> countyById;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityById", cascade = CascadeType.ALL)
    private List<Veterinarian> veterinarianById;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cityById", cascade = CascadeType.ALL)
    private List<Customer> customerById;
}
