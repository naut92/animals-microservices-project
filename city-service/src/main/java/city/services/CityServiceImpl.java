package city.services;

import city.client.CountyClient;
import city.client.CustomerClient;
import city.client.VeterinarianClient;
import city.entities.City;
import city.services.intf.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CityServiceImpl implements CityService{

    private final CountyClient countyClient;
    private final CustomerClient customerClient;
    private final VeterinarianClient veterinarianClient;

    public CityServiceImpl(CountyClient countyClient,
						   CustomerClient customerClient, VeterinarianClient veterinarianClient) {
        this.countyClient = countyClient;
        this.customerClient = customerClient;
        this.veterinarianClient = veterinarianClient;
    }

	public City save(City city) {
		return null;//repository.save(city);
	}

	public List<City> findAllCities() {
		return customerClient.findAllCities();
	}

	public Optional<City> findCityById(Long cityId) {
		return Optional.ofNullable(customerClient.findCityById(cityId));
	}

	public Optional<City> findByIdWithCounties(Long cityId) {
		Optional<City> city = Optional.ofNullable(customerClient.findCityById(cityId));
		city.ifPresent(value -> value.setCountyById(countyClient.findByCity(value.getId())));
		return city;
	}

	public Optional<City> findByIdWithCountiesAndCustomers(Long cityId) {
		Optional <City> city = Optional.ofNullable(customerClient.findCityById(cityId));
		city.ifPresent(value -> value.setCountyById(countyClient.findByCityWithCustomers(value.getId())));
		return city;
	}

    public Optional<City> findByIdWithCountiesAndVeterinarians(Long cityId) {
        Optional <City> city = Optional.ofNullable(customerClient.findCityById(cityId));
		city.ifPresent(value -> value.setCountyById(countyClient.findByCityWithVeterinarians(value.getId())));
        return city;
    }

	public Optional<City> findByIdWithCustomers(Long cityId) {
		Optional <City> city = Optional.ofNullable(customerClient.findCityById(cityId));
		city.ifPresent(value -> value.setCustomerById(customerClient.findByCity(value.getId())));
		return city;
	}

    public Optional<City> findByIdWithVeterinarians(Long cityId) {
		Optional <City> city = Optional.ofNullable(customerClient.findCityById(cityId));
        city.ifPresent(value -> value.setVeterinarianById(veterinarianClient.findByCity(value.getId())));
        return city;
    }
}
