package animals_app.entities;

import animals_app.entities.intf.SimpleIdentifiableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "veterinarians")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Veterinarian extends SimpleIdentifiableEntity {
    @Basic
    @Column(name = "city_id")
    private Long city_id;

    /*@Basic
    @Column(name = "county_id")
    private Long county_id;

    @Basic
    @Column(name = "customer_id")
    private Long customer_id;*/

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @UniqueElements(message = "*This email is used")
    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
    private City cityById;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "veterin_county",
            //foreign key for County in veterin_county table
            joinColumns = @JoinColumn(name = "veterinarian_id"),
            //foreign key for other side - Veterinarian in veterin_county table
            inverseJoinColumns = @JoinColumn(name = "county_id"))
    private Set<County> counties;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "veterin_customer",
            //foreign key for Customer entity in veterin_customer table
            joinColumns = @JoinColumn(name = "veterinarian_id"),
            //foreign key for other side - Veterinarian entity in veterin_customer table
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers;
}
