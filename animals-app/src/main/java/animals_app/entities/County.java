package animals_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "counties")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class County {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "city_id")
    private Long city_id;

    /*@Basic
    @Column(name = "veterinarian_id")
    private Long veterinarian_id;*/

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
    private City cityById;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "countyById", cascade = CascadeType.ALL)
    private List<Customer> customerById = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "veterin_county",
            //foreign key for Vetrinarian Entity in veterin_county table
            joinColumns = @JoinColumn(name = "county_id"),
            //foreign key for other side - County entity in veterin_county table
            inverseJoinColumns = @JoinColumn(name = "veterinarian_id"))
    private Set<Veterinarian> veterinarians;
}
