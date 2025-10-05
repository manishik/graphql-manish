package manish.graphql;

import manish.graphql.model.CustomerAddressDAO;
import manish.graphql.repository.CustomerAddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerAddressDataLoader implements CommandLineRunner {

    private final CustomerAddressRepository customerAddressRepository;

    public CustomerAddressDataLoader(CustomerAddressRepository customerAddressRepository) {
        this.customerAddressRepository = customerAddressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        customerAddressRepository.save(new CustomerAddressDAO("Manish@manish.com", 2013, "Mental Hospital", "Mysore",
                "Bogadi", 1000, "Mental", "India", "Hospital", "100", "MentalHospital@Mental.com"));
        customerAddressRepository.save(new CustomerAddressDAO("DDDDD@HHH.com", 2015, "Sunshine Apartments", "Bangalore",
                "Indiranagar", 560038, "Home", "India", "Residential", "101", "alice.home@example.com"));
        customerAddressRepository.save(new CustomerAddressDAO("Manish@MMM.com", 2017, "Green Villa", "Chennai",
                "Adyar", 600020, "Office", "India", "Commercial", "202", "bob.office@workmail.com"));
        customerAddressRepository.save(new CustomerAddressDAO("AAA@AAA.com", 2012, "Ocean Towers", "Mumbai",
                "Andheri West", 400058, "Apartment", "India", "Residential", "303", "charlie.res@gmail.com"));
        customerAddressRepository.save(new CustomerAddressDAO("AASSS@AASSS.com", 2018, "Tech Park Phase 1", "Hyderabad",
                "HITEC City", 500081, "Work", "India", "Business", "404", "diana.office@company.com"));
        customerAddressRepository.save(new CustomerAddressDAO("QQQQ@manish.com", 2014, "Riverbank Homes", "Kolkata",
                "Salt Lake", 700091, "Home", "India", "Residential", "505", "eve.home@contact.com"));
        customerAddressRepository.save(new CustomerAddressDAO("QQQQ@manish.com", 2020, "Heritage Residency", "Delhi",
                "Dwarka", 110075, "Home", "India", "Residential", "606", "frank.residence@domain.com"));
        customerAddressRepository.save(new CustomerAddressDAO("EEEE@manish.com", 2016, "Alpha Building", "Pune",
                "Koregaon Park", 411001, "Office", "India", "Corporate", "707", "grace.office@enterprise.com"));
    }
}
