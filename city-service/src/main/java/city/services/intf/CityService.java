package city.services.intf;

import city.entities.City;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CityService {
    City save(City city);
    List findAllCities() throws ClassNotFoundException, SQLException;
    Optional<City> findCityById(Long cityId);
    Optional<City> findByIdWithCounties(Long id);
    Optional<City> findByIdWithCountiesAndCustomers(Long id);
    Optional<City> findByIdWithCountiesAndVeterinarians(Long id);
    Optional<City> findByIdWithCustomers(Long id);
    Optional<City> findByIdWithVeterinarians(Long id);
}
