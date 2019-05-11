- Microservices project (Animals-app(pet care center): https://github.com/naut92/animals-app), 
- Spring boot 2.1,
- Spring cloud 2.1,
- Eureka,
- Netflix OSS
- Spring Cloud Gateway
- Spring-cloud-config
- Spring Cloud Open Feign
- Swagger2
- Zuul
- PostgreSQL
- Spring Data JPA

Microservices endpoint:

config:
- config-servicies: /8089
- discovery-servicies: /8062
- gateway-service: /8064
- proxy-service(Swagger): /8063/swagger-ui.html
                         
--------------------------

- animals-app(backend): /8081/animals-api/
- animals-app-client(frontend: https://github.com/naut92/animals-app-client): /3000
- city-service: /8082/city-api/
- counties-service: /8083/counties-api/
- veterinarians-service: /8084/veterinarians-api/
