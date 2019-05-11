package animals_app.services.intf;

import animals_app.entities.Animal;

public interface AnimalService {

    /**
     * find Animal by Id
     *
     * @param id        - id by Animal
     * @return          - Animal
     */

    Animal getAnimalById(Long id);

    /**
     * delete Animal by Id
     *
     * @param id        - id by Animal
     * @return
     */
    void deleteById(Long id);
}
