package city.client;

import city.entities.Veterinarian;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "veterinarians-service")
public interface VeterinarianClient {

	@GetMapping("/veterinarians-api/city/{cityId}")
	List<Veterinarian> findByCity(@PathVariable("cityId") Long cityId);
}
