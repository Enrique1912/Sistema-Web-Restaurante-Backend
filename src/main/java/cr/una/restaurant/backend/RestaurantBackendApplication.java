package cr.una.restaurant.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;


import java.util.Properties;
@Repository
@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
@ComponentScan({ "cr.una.restaurant.backend.*" })
public class RestaurantBackendApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RestaurantBackendApplication.class);
        Properties props = new Properties();
        props.setProperty("server.port", "8080");

        app.setDefaultProperties(props);
        app.run(args);

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
