package animals_app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal implements Serializable{
    private static final long serialVersionUID = 5124000706092599751L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @NonNull
    @Column(name = "animalname")
    private String animalname;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Customer customerById;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalname='" + animalname + '\'' +
                ", dateborn='" + dateborn + '\'' +
                ", sex='" + sex + '\'' +
                ", customerId=" + customerId +
                ", typesanimal='" + typesanimal + '\'' +
                ", customerById=" + getCustomerById().getId() +
                '}';
    }
}