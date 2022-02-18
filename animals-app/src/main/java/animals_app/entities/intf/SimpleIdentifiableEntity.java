package animals_app.entities.intf;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class SimpleIdentifiableEntity extends IdentifiableEntity<Long> implements IdentifiableEntityInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

        if (obj.getClass() == getClass()) {
            SimpleIdentifiableEntity other = (SimpleIdentifiableEntity) obj;

            return !(getId() == null || other.getId() == null) && getId().equals(other.getId());
        }

        return false;
    }
}
