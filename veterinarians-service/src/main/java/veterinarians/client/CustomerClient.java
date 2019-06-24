package veterinarians.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import veterinarians.entities.City;
import veterinarians.entities.County;
import veterinarians.entities.Customer;
import veterinarians.entities.Veterinarian;

import java.util.List;

@FeignClient(name = "animals-app")
public interface CustomerClient {

	@GetMapping("/veterinarian/{veterinarianId}")
	List<Customer> findCustomersByVeterinarianId(@PathVariable("veterinarianId") Long veterinarianId);

	@GetMapping("/customer-id/{customerId}")
	Customer findCustomerById(@PathVariable("customerId") Long customerId);

	@GetMapping("/veterinarians")
	List<Veterinarian> findByAllVeterinarians();

	@GetMapping("/veterinarians/veterinarian/{veterinarianId}")
	Veterinarian findVeterinarianById(@PathVariable("veterinarianId") Long veterinarianId);

	@GetMapping("/cities/city/{cityId}")
	City findCityById(@PathVariable("cityId") Long cityId);

	@GetMapping("/counties/county/{countyId}")
	County findCountyById(@PathVariable("countyId") Long countyId);
}
