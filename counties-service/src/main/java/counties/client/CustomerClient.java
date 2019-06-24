package counties.client;

import counties.entities.City;
import counties.entities.County;
import counties.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "animals-app")
public interface CustomerClient {

	@GetMapping("/county/{countyId}")
	List<Customer> findByCounty(@PathVariable("countyId") Long countyId);

	@GetMapping("/counties")
	List<County> findAllCounties();

	@GetMapping("/counties/county/{countyId}")
	County findCountyById(@PathVariable("countyId") Long countyId);

	@GetMapping("/cities/city/{cityId}")
	City findCityById(@PathVariable("cityId") Long cityId);
}
