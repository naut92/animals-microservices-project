package animals_app.services.intf;

import animals_app.entities.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CustomerService {
    /**
     * find All Customers
     *
     * @param
     * @return          - Collection <Customer>
     */
    Collection<Customer> getAllCustomers();
    /**
     * find all Animals by owner
     *
     * @param id        - Customer Id
     * @return          - Collection <Animal>
     */
    Collection<Animal> getAnimalsByCustomerId(Long id);
    /**
     * find Animal by Customer
     *
     * @param customerId - Customer Id
     * @param animalId   - Animal Id
     * @return           - Animal
     */
    Animal getOneAnimalByCustomerId(Long customerId, Long animalId);
    /**
     * create new Animal by Customer
     *
     * @param customerId - Customer Id
     * @param animal     - AnimalEntity
     * @return           - Customer
     */
    Customer createAnimal(Long customerId, Animal animal);
    /**
     * update exit Animal by Customer
     *
     * @param animalId   - Animal Id
     * @param animal     - AnimalEntity
     * @return           - Customer
     */
    Customer updateAnimal(Long animalId, Animal animal);

    List<Customer> findCustomersByCityId(Long cityId);

    List<Customer> findCustomersByCountyId(Long countyId);

    Set<Customer> findCustomersByVeterinarianId(Long veterinarianId);

    List<Veterinarian> findAllVeterinarians();

    List<City> findAllCities();

    List<County> findAllCounties();

    City findCityById(Long cityId);

    County findCountyById(Long countyId);

    Veterinarian findVeterinarianById(Long veterinarianId);

    Optional<Customer> getCustomerById(Long id);


    /**
     * save authentication User
     *
     * @param customer     - Customer
     * @return
     */
    //void saveByAuth(Customer customer);
}
