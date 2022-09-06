package localhost;

import java.beans.Customizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import localhost.entity.JpaController;
import localhost.repository.CustomerRepository;

@SpringBootApplication
public class AccessingDataWithJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataWithJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataWithJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demo(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new JpaController("Jack", "Bauer"));
      repository.save(new JpaController("Chloe", "O'Brian"));
      repository.save(new JpaController("Kim", "Bauer"));
      repository.save(new JpaController("David", "Palmer"));
      repository.save(new JpaController("Michelle", "Dessler"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (JpaController jpacontroller : repository.findAll()) {
        log.info(jpacontroller.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      JpaController jpacontroller = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(jpacontroller.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

}