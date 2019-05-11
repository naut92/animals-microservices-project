package counties.services.intf;

import counties.entities.County;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CountyService {
    County save(County county);
    List findAllCounties() throws ClassNotFoundException, SQLException;
    Optional<County> findCountyById(Long countyId);
    List<County> findCountiesByCityId(Long id);
    List<County> findByCityWithCustomers(Long cityId);
    List<County> findByCityWithVeterinarians(Long cityId);
}
