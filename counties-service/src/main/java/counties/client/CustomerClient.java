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

	@GetMapping("/animals-api/county/{countyId}")
	List<Customer> findByCounty(@PathVariable("countyId") Long countyId);

	@GetMapping("/animals-api/counties")
	List<County> findAllCounties();

	@GetMapping("/animals-api/counties/county/{countyId}")
	County findCountyById(@PathVariable("countyId") Long countyId);

	@GetMapping("/animals-api/cities/city/{cityId}")
	City findCityById(@PathVariable("cityId") Long cityId);
}
