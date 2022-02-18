package veterinarians.service;

import org.springframework.stereotype.Service;
import veterinarians.client.CustomerClient;
import veterinarians.entities.City;
import veterinarians.entities.County;
import veterinarians.entities.Customer;
import veterinarians.entities.Veterinarian;
import veterinarians.service.intf.VeterinarianService;

import java.util.List;

@Service
public class VeterinarianServiceImpl implements VeterinarianService {

    private final CustomerClient customerClient;

    public VeterinarianServiceImpl(CustomerClient client) {
        this.customerClient = client;
    }

    @Override
    public List<Veterinarian> findAllVeterinarians() {
        return customerClient.findByAllVeterinarians();
    }

    @Override
    public Veterinarian save(Veterinarian veterinarian) {
        return null;//repository.save(veterinarian);
    }

    @Override
    public Veterinarian findVeterinarianById(Long veterinarianId) {
        return customerClient.findVeterinarianById(veterinarianId);
    }

    @Override
    public List<Veterinarian> findVeterinariansByCityId(Long cityId) {
        City city = customerClient.findCityById(cityId);
        return city.getVeterinarianById();
    }

    @Override
    public List<Veterinarian> findVeterinariansByCountyId(Long countyId) {
        County county = customerClient.findCountyById(countyId);
        System.out.println(county);
        return county.getVeterinarians();
    }

    @Override
    public List<Veterinarian> findVeterinariansByCustomerId(Long customerId) {
        Customer customer = customerClient.findCustomerById(customerId);
        System.out.println(customer);
        return customer.getVeterinarians();
    }
}
