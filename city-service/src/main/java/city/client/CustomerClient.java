package city.client;

import city.entities.City;
import city.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "animals-app")
public interface CustomerClient {

	@GetMapping("/animals-api/city/{cityId}")
	List<Customer> findByCity(@PathVariable("cityId") Long cityId);
	@GetMapping("/animals-api/cities")
	List<City> findAllCities();

	@GetMapping("/animals-api/cities/city/{cityId}")
	City findCityById(@PathVariable("cityId") Long cityId);
}