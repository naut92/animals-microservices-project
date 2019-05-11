package counties.controller;

import counties.entities.County;
import counties.services.intf.CountyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class CountiesController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountiesController.class);


    private final CountyService service;

    public CountiesController(CountyService countyService) {
        service = countyService;
    }

    @PostMapping("/county/new")
    public County add(@RequestBody County county) {
        LOGGER.info("County add: {}", county);
        return service.save(county);
    }

    @GetMapping("/counties")
    public List<County> findAllCounties() throws SQLException, ClassNotFoundException {
        LOGGER.info("Counties find");
        return service.findAllCounties();
    }

    @GetMapping("/county/{id}")
    public Optional<County> findCountyById(@PathVariable("id") Long id) {
        LOGGER.info("County find: id={}", id);
        return service.findCountyById(id);
    }

    @GetMapping("/city/{cityId}")
    public List<County> findCountiesByCityId(@PathVariable("cityId") Long cityId) {
        LOGGER.info("County find: cityId={}", cityId);
        return service.findCountiesByCityId(cityId);
    }

    @GetMapping("/city/{cityId}/customers")
    public List<County> findByCityWithCustomers(@PathVariable("cityId") Long cityId) {
        LOGGER.info("County find: cityId={}", cityId);
        return service.findByCityWithCustomers(cityId);
    }

    @GetMapping("/city/{cityId}/veterinarians")
    public List<County> findByCityWithVeterinarians(@PathVariable("cityId") Long cityId) {
        LOGGER.info("County find: cityId={}", cityId);
        return service.findByCityWithVeterinarians(cityId);
    }
}
