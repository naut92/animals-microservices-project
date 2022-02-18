package animals_app.entities.intf;

import org.springframework.util.ClassUtils;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class IdentifiableEntity<ID extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " {" + id + "}";
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (ClassUtils.getUserClass(obj) == getClass()) {
            IdentifiableEntity<?> other = (IdentifiableEntity<?>) obj;
            return !(getId() == null || other.getId() == null) && getId().equals(other.getId());
        }

        return false;
    }
}
