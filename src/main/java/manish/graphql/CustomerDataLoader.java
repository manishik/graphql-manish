package manish.graphql;

import manish.graphql.model.CustomerDAO;
import manish.graphql.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public CustomerDataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepository.save(new CustomerDAO("Manish@manish.com", "Manish", "I", "Keshav", 1234569, 1234589));
        customerRepository.save(new CustomerDAO("DDDDD@HHH.com", "DDDDD", "jjj", "HHHH", 3432, 74754 ));
        customerRepository.save(new CustomerDAO("Manish@MMM.com", "Manish", "e", "MMMM", 23432, 754544 ));
        customerRepository.save(new CustomerDAO("AAA@AAA.com", "AAA", "a", "AAA", 452523, 563643 ));
        customerRepository.save(new CustomerDAO("AASSS@AASSS.com", "AASSS", "SDF", "AASSS", 54654, 85646 ));
        customerRepository.save(new CustomerDAO("QQQQ@manish.com", "QQQQ", "I", "manish", 242334, 363542 ));
        customerRepository.save(new CustomerDAO("WWWW@manish.com", "WWWW", "jsdh", "WWHSL", 5645645, 754463 ));
        customerRepository.save(new CustomerDAO("EEEE@manish.com", "EEEE", "FG", "manish", 2324342, 254544));

    }
}
