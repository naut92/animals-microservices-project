package animals_app.services;


import animals_app.entities.Customer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private EntityManager em;
    @InjectMocks
    private CustomerServiceImpl customerService;

   @BeforeClass
   public static void startUp() throws URISyntaxException, IOException {
       URL url = CustomerServiceImplTest.class.getClassLoader().getResource("data.sql");
       List<String> str = Files.readAllLines(Paths.get(url.toURI()));
       String sql = str.stream().collect(Collectors.joining());
       //System.out.println(sql);
   }

   @Before
   public void setup(){
       //customerService = new CustomerServiceImpl();
       //em = mock(EntityManager.class);
       //customerService.setEntityManager(em);
   }

    @Test
    public void whenFindAll_thenReturnCustomersList()/*getAllCustomers() */{
       System.out.println("1");
    }

    @Test
    public void getCustomerById() {
        Customer sampleCustomer = new Customer();
        sampleCustomer.setFirstname("Susan");
        sampleCustomer.setLastname("Ivanova");

        when(em.find(Customer.class,1L)).thenReturn(sampleCustomer);

        String fullName = customerService.getCustomerById(1L).get().getFirstname() + " "
                + customerService.getCustomerById(1L).get().getLastname();
        assertEquals("true", "Susan Ivanova", fullName);
    }

    @Test
    public void getAnimalsByCustomerId() {
        System.out.println("1");
    }

    @Test
    public void getOneAnimalByCustomerId() {
        System.out.println("1");
    }

    @Test
    public void createAnimal() {
        System.out.println("1");
    }

    @Test
    public void updateAnimal() {
        System.out.println("1");
    }

    @Test
    public void findCustomersByCityId() {
        System.out.println("1");
    }

    @Test
    public void findCustomersByCountyId() {
        System.out.println("1");
    }

    @Test
    public void findCustomersByVeterinarianId() {
        System.out.println("1");
    }

    @Test
    public void findAllVeterinarians() {
        System.out.println("1");
    }

    @Test
    public void findAllCities() {
        System.out.println("1");
    }

    @Test
    public void findAllCounties() {
        System.out.println("1");
    }

    @Test
    public void findCityById() {
        System.out.println("1");
    }

    @Test
    public void findCountyById() {
        System.out.println("1");
    }

    @Test
    public void findVeterinarianById() {
        System.out.println("1");
    }
}
