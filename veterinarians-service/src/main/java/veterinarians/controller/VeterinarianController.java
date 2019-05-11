package veterinarians.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import veterinarians.entities.Veterinarian;
import veterinarians.service.intf.VeterinarianService;

import java.util.List;


@RestController
public class VeterinarianController {
    private final Logger LOGGER = LoggerFactory.getLogger(VeterinarianController.class);

    private final VeterinarianService service;

    public VeterinarianController(VeterinarianService service) {
        this.service = service;
    }

    @GetMapping("/veterinarians")
    public List<Veterinarian> findAllVeterinarians() {
        return service.findAllVeterinarians();
    }

    @PostMapping("/veterinarian/new")
    public Veterinarian add(@RequestBody Veterinarian veterinarian) {
        LOGGER.info("Veterinarian add: {}", veterinarian);
        return service.save(veterinarian);
    }

    @GetMapping("/veterinarian/{id}")
    public Veterinarian findVeterinarianById(@PathVariable("id") Long veterinarianId) {
        LOGGER.info("Veterinarian find: id={}", veterinarianId);
        return service.findVeterinarianById(veterinarianId);
    }

    @GetMapping("/city/{cityId}")
    public List<Veterinarian> findVeterinariansByCityId(@PathVariable("cityId") Long cityId) {
        LOGGER.info("Veterinarians find: cityId={}", cityId);
        return service.findVeterinariansByCityId(cityId);
    }

    @GetMapping("/county/{countyId}")
    public List<Veterinarian> findVeterinariansByCountyId(@PathVariable("countyId") Long countyId) {
        LOGGER.info("Veterinarian find: countyId={}", countyId);
        return service.findVeterinariansByCountyId(countyId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Veterinarian> findVeterinariansByCustomerId(@PathVariable("customerId") Long customerId) {
        LOGGER.info("Veterinarian find: customerId={}", customerId);
        return service.findVeterinariansByCustomerId(customerId);
    }

}
