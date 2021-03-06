package city.client;

import city.entities.County;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "counties-service")
public interface CountyClient {

	@GetMapping("/city/{cityId}")
	List<County> findByCity(@PathVariable("cityId") Long cityId);
	
	@GetMapping("/city/{cityId}/counties")
	List<County> findByCityWithCounty(@PathVariable("cityId") Long cityId);

	@GetMapping("/city/{cityId}/customers")
	List<County> findByCityWithCustomers(@PathVariable("cityId") Long cityId);

	@GetMapping("/city/{cityId}/veterinarians")
	List<County> findByCityWithVeterinarians(@PathVariable("cityId") Long cityId);
}
