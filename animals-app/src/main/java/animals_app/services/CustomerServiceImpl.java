package animals_app.services;

import animals_app.entities.*;
//import RolesRepository;
import animals_app.services.intf.CustomerService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    EntityManager em;


    //@Autowired
    //private RolesRepository rolesRepository;

    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Collection<Customer> getAllCustomers() {
        Query query = em.createQuery("SELECT e FROM Customer e");
        return (Collection<Customer>) query.getResultList();
    }

    @Override
    public Optional<Customer> getCustomerById(Long customerId) {
        Customer customer = em.find(Customer.class, customerId);
        if(customer != null) return Optional.of(customer);
        else throw new EntityNotFoundException();
    }

    public Collection<Animal> getAnimalsByCustomerId(Long id) {
        Customer customer = em.find(Customer.class, id);
        if(customer != null) return customer.getAnimalById();
        else throw new EntityNotFoundException();
    }

    public Animal getOneAnimalByCustomerId(Long customerId, Long animalId){
        Customer customer = em.find(Customer.class, customerId);
        Collection<Animal> collectionAnimals = customer.getAnimalById();
        Animal animal;
        try {
            animal = collectionAnimals.stream().filter(item->item.getId().equals(animalId)).findFirst().get();
        }catch (Exception e){
            throw new EntityNotFoundException();
        }
        return animal;
    }

    public Customer createAnimal(Long customerId, Animal animal) {
        Customer customer = em.find(Customer.class, customerId);
        Collection<Animal> coll = customer.getAnimalById();
        animal.setCustomerId(customer.getId());
        animal.setCustomerById(customer);
        coll.add(animal);
        customer.setAnimalById(coll);
        em.persist(animal);
        em.flush();
        em.merge(customer);
        return customer;
    }

    public Customer updateAnimal(Long animalId, Animal animal) {
        Animal animalsEntity = em.find(Animal.class, animalId);
        animal.setId(animalId);
        Customer customer = animalsEntity.getCustomerById();
        animal.setCustomerById(customer);
        em.merge(animal);
        return customer;
    }

    public List<Customer> findCustomersByCityId(Long cityId) {
        City city = em.find(City.class, cityId);
        if(city != null) return city.getCustomerById();
        else throw new EntityNotFoundException();
    }

    @Override
    public List<Customer> findCustomersByCountyId(Long countyId) {
        County county = em.find(County.class, countyId);
        if(county != null) return county.getCustomerById();
        else throw new EntityNotFoundException();
    }

    @Override
    public Set<Customer> findCustomersByVeterinarianId(Long veterinarianId) {
        Veterinarian veterinarian = em.find(Veterinarian.class, veterinarianId);
        if(veterinarian != null) return veterinarian.getCustomers();
        else throw new EntityNotFoundException();
    }

    @Override
    public List<Veterinarian> findAllVeterinarians() {
        Query query = em.createQuery("SELECT e FROM Veterinarian e");
        return (List<Veterinarian>) query.getResultList();
    }

    @Override
    public List<City> findAllCities() {
        Query query = em.createQuery("SELECT e FROM City e");
        return (List<City>) query.getResultList();
    }

    @Override
    public List<County> findAllCounties() {
        Query query = em.createQuery("SELECT e FROM County e");
        return (List<County>) query.getResultList();
    }

    @Override
    public City findCityById(Long cityId) {
        City city = em.find(City.class, cityId);
        if(city != null) return city;
        else throw new EntityNotFoundException();
    }

    @Override
    public County findCountyById(Long countyId) {
        County county = em.find(County.class, countyId);
        if(county != null) return county;
        else throw new EntityNotFoundException();
    }

    @Override
    public Veterinarian findVeterinarianById(Long veterinarianId) {
        Veterinarian veterinarian = em.find(Veterinarian.class, veterinarianId);
        if(veterinarian != null) return veterinarian;
        else throw new EntityNotFoundException();
    }


/*
    @Override
    public void saveByAuth(Customer customer) {
        customer.setPass(bCryptPasswordEncoder.encode(customer.getPass()));
        customer.setRoles(new HashSet<>(rolesRepository.findAll()));
        customersRepository.save(customer);
    }*/
}