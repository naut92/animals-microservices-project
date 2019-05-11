package animals_app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class RolesEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "roles")
    private String roles;

    @Basic
    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "customer_role",
            //foreign key for RolesEntity in customer_role table
            joinColumns = @JoinColumn(name = "role_id"),
            //foreign key for other side - Customer in customer_role table
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Collection<Customer> customers;
}