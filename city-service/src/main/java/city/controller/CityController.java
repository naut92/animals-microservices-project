package city.controller;


import city.entities.City;
import city.services.intf.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "*")
@RestController
public class CityController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

	private final CityService service;

    public CityController(CityService serviceC) {
        service = serviceC;
    }

    @PostMapping("/city/new ")
	public City save(@RequestBody City city) {
		LOGGER.info("City add: {}", city);
		return service.save(city);
	}

	@GetMapping("/cities")
	public List<City> findAllCities() throws SQLException, ClassNotFoundException {
		LOGGER.info("city find");
		return service.findAllCities();
	}
	
	@GetMapping("/city/{id}")
	public Optional<City> findById(@PathVariable("id") Long cityId) {
		LOGGER.info("City find: id={}", cityId);
		return service.findCityById(cityId);
	}

	@GetMapping("/city/{id}/counties")
	public Optional<City> findByIdWithCounties(@PathVariable("id") Long id) {
		LOGGER.info("City find: id={}", id);
		return service.findByIdWithCounties(id);
	}

	@GetMapping("/city/{id}/counties-and-customers")
	public Optional<City> findByIdWithCountiesAndCustomers(@PathVariable("id") Long id) {
		LOGGER.info("City find: id={}", id);
		return service.findByIdWithCountiesAndCustomers(id);
	}

    @GetMapping("/city/{id}/counties-and-veterinarians")
    public Optional<City> findByIdWithCountiesAndVeterinarians(@PathVariable("id") Long id) {
        LOGGER.info("City find: id={}", id);
        return service.findByIdWithCountiesAndVeterinarians(id);
    }

	@GetMapping("/city/{id}/customers")
	public Optional<City> findByIdWithCustomers(@PathVariable("id") Long id) {
		LOGGER.info("City find: id={}", id);
		return service.findByIdWithCustomers(id);
	}

    @GetMapping("/city/{id}/veterinarians")
    public Optional<City> findByIdWithVeterinarians(@PathVariable("id") Long id) {
        LOGGER.info("City find: id={}", id);
        return service.findByIdWithVeterinarians(id);
    }
}
