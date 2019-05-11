package animals_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer implements Serializable{
    private static final long serialVersionUID = -481073315751589931L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "city_id")
    private Long city_id;
    @Basic
    @Column(name = "county_id")
    private Long county_id;

    /*@Basic
    @Column(name = "veterinarian_id")
    private Long veterinarian_id;*/

    @Basic
    @Column(name = "firstname")
    private String firstname;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "email")
    @UniqueElements(message = "*This email is used")
    private String email;

    @Basic
    @Column(name = "pass")
    @Length(min = 5, max = 80, message = "*Your password must have at least 5 characters")
    @NotNull(message = "*Please provide your password")
    @JsonIgnore
    private String pass;

    @JsonIgnore
    private String passConfirm;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "customer_role",
    //foreign key for RolesEntity in customer_role table
    joinColumns = @JoinColumn(name = "customer_id"),
    //foreign key for other side - Customer in customer_role table
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<RolesEntity> roles;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "veterin_customer",
            //foreign key for Veterinarian in veterin_customer table
            joinColumns = @JoinColumn(name = "customer_id"),
            //foreign key for other side - Customer in veterin_customer table
            inverseJoinColumns = @JoinColumn(name = "veterinarian_id"))
    private Set<Veterinarian> veterinarians;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerById", cascade = CascadeType.ALL)
    private Collection<Animal> animalById;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", insertable = false, updatable = false)
    private City cityById;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "county_id", referencedColumnName = "id", insertable = false, updatable = false)
    private County countyById;

}