package veterinarians.service.intf;

import veterinarians.entities.Veterinarian;

import java.util.List;

public interface VeterinarianService {
    List<Veterinarian> findAllVeterinarians();
    Veterinarian save(Veterinarian veterinarian);
    Veterinarian findVeterinarianById(Long veterinarianId);
    List<Veterinarian> findVeterinariansByCityId(Long cityId);
    List<Veterinarian> findVeterinariansByCountyId(Long countyId);
    List<Veterinarian> findVeterinariansByCustomerId(Long customerId);
}
