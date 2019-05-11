package animals_app.services;

import animals_app.entities.Animal;
import animals_app.services.intf.AnimalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

    @PersistenceContext
    EntityManager em;

    public Animal getAnimalById(Long id) {
        return em.find(Animal.class, id);
    }

    public void deleteById(Long id) {
        Animal animal = em.find(Animal.class, id);
        em.remove(animal);
    }
}