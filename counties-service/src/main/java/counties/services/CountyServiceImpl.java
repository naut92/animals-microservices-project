package counties.services;

import counties.client.CustomerClient;
import counties.entities.City;
import counties.entities.County;
import counties.services.intf.CountyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CountyServiceImpl implements CountyService {

    private final CustomerClient customerClient;

    public CountyServiceImpl(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

	public County save(County county) {
		return null; //repository.save(county);
	}

	public List<County> findAllCounties() {
		return customerClient.findAllCounties();
	}

	public Optional<County> findCountyById(Long countyId) {
		return Optional.ofNullable(customerClient.findCountyById(countyId));
	}

	@Override
	public List<County> findCountiesByCityId(Long cityId) {
		City city = customerClient.findCityById(cityId);
		return city.getCountyById();
    }

	@Override
	public List<County> findByCityWithCustomers(Long cityId) {
		City city = customerClient.findCityById(cityId);
		List<County> counties = city.getCountyById();

        /*Query query = em.createQuery("SELECT e FROM County e WHERE e.city_id =:cityId");
        query.setParameter("cityId", cityId);
        List<County> counties = (List<County>) query.getResultList();*/
        counties.forEach(d -> d.setCustomerById(customerClient.findByCounty(d.getId())));
		return counties;
	}

	@Override
	public List<County> findByCityWithVeterinarians(Long cityId) {
		City city = customerClient.findCityById(cityId);
		return city.getCountyById();
	}
}
