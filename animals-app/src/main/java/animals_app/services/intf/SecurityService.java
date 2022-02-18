package animals_app.services.intf;


public interface SecurityService {
    String findLoggedInCustomerEmail();
    void autologin(String customerEmail, String pass);
}