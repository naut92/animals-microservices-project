package animals_app.controller;

import animals_app.entities.*;
import animals_app.services.intf.AnimalService;
import animals_app.services.intf.CustomerService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

//@CrossOrigin(origins = "*")
@RestController
@Api(value="Animals App Management System", description="Operations pertaining to customer in Animals App Management System")
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;
    private final AnimalService animalService;

    public CustomerController(CustomerService serviceC, AnimalService serviceA) {
        customerService = serviceC;
        animalService = serviceA;
    }


    @ApiOperation(value = "View a list of available customers", response = List.class)
    @GetMapping("/customers")
    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
//*
    @GetMapping("/customer-id/{id}")
    ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//*/
    @ApiOperation(value = "Get customer by Id")
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getAnimalsByCustomerId(@PathVariable Long id) {
        Collection<Animal> customer = customerService.getAnimalsByCustomerId(id);
        return ResponseEntity.ok().body(customer);
    }

    @ApiOperation(value = "Get animal by customer Id")
    @GetMapping("/customer/{id}/{animalId}")
    public ResponseEntity<?> getOneAnimalByCustomerId(@PathVariable Long id, @PathVariable Long animalId) {
        Animal animal = customerService.getOneAnimalByCustomerId(id, animalId);
        return ResponseEntity.ok().body(animal);
    }

    @ApiOperation(value = "Get animal by Id")
    @GetMapping("/animal/{customerId}/{animalId}")
    public ResponseEntity<?> getAnimalById(@PathVariable Long animalId) {
        //Optional<Animal> animal = animalService.getAnimalById(animalId);
        //return animal.map(response -> ResponseEntity.ok().body(response))
        //        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        Animal animal = animalService.getAnimalById(animalId);
        return ResponseEntity.ok().body(animal);
    }

    @ApiOperation(value = "Update animal")
    @PutMapping("/animal/{customerId}/{animalId}")
    public ResponseEntity <Customer> updateAnimal(@PathVariable Long animalId, @Valid @RequestBody Animal animal) {
        log.warn("Request to update animal={}", animal);
        Customer result = customerService.updateAnimal(animalId, animal);
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "Add animal")
    @PostMapping("/animal/new/{customerId}")
    public ResponseEntity<Customer> createAnimal
            (@PathVariable Long customerId, @Valid @RequestBody Animal animal) throws URISyntaxException {
        log.warn("Request to create animal={}", animal);
        Customer result = customerService.createAnimal(customerId, animal);
        return ResponseEntity.created(new URI("/customer/" + result.getId()))
                .body(result);
    }

    @ApiOperation(value = "Delete animal")
    @DeleteMapping("/customer/{id}/{animalId}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Long animalId) {
        log.info("Request to delete animal={}", animalId);
        try {
            animalService.deleteById(animalId);
        }catch (Exception e) {
            log.error("объект не удалён");
            e.getStackTrace();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/city/{cityId}")
    public List<Customer> findCustomersByCityId(@PathVariable("cityId") Long cityId) {
        log.info("Customer find: cityId={}", cityId);
        return customerService.findCustomersByCityId(cityId);
    }

    @GetMapping("/county/{countyId}")
    public List<Customer> findCustomersByCountyId(@PathVariable("countyId") Long countyId) {
        log.info("Customer find: countyId={}", countyId);
        return customerService.findCustomersByCountyId(countyId);
    }

    @GetMapping("/veterinarian/{veterinarianId}")
    public Set<Customer> findCustomersByVeterinarianId(@PathVariable("veterinarianId") Long veterinarianId) {
        log.info("Customer find: veterinarianId={}", veterinarianId);
        return customerService.findCustomersByVeterinarianId(veterinarianId);
    }

    @GetMapping("/cities")
    public List<City> findAllCities(){
        log.info("Find all Cities:");
        return customerService.findAllCities();
    }

    @GetMapping("/cities/city/{cityId}")
    public City findCityById(@PathVariable("cityId") Long cityId){
        log.info("City find: cityId={}", cityId);
        return customerService.findCityById(cityId);
    }

    @GetMapping("/counties")
    public List<County> findAllCounties(){
        log.info("Find all Counties:");
        return customerService.findAllCounties();
    }

    @GetMapping("/counties/county/{countyId}")
    public County findCountyById(@PathVariable("countyId") Long countyId){
        log.info("County find: countyId={}", countyId);
        return customerService.findCountyById(countyId);
    }

    @GetMapping("/veterinarians")
    public List<Veterinarian> findAllVeterinarians(){
        log.info("Find all Veterinarians:");
        return customerService.findAllVeterinarians();
    }

    @GetMapping("/veterinarians/veterinarian/{veterinarianId}")
    public Veterinarian findVeterinarianById(@PathVariable("veterinarianId") Long veterinarianId){
        log.info("Veterinarian find: veterinarianId={}", veterinarianId);
        return customerService.findVeterinarianById(veterinarianId);
    }
}
