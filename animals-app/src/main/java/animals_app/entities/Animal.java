package animals_app.entities;

import animals_app.entities.intf.SimpleIdentifiableEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal extends SimpleIdentifiableEntity {
    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "dateborn")
    private String dateborn;

    @Basic
    @Column(name = "sex")
    private String sex;

    @Basic
    @Column(name = "customer_id")
    private Long customerId;

    @Basic
    @Column(name = "typesanimal")
    private String typesanimal;

    @Basic
    @Column(name = "price")
    private Integer price;

    @ToString.Exclude
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customerById;
}
