package learn.manish.graphql.repository;

import learn.manish.graphql.model.CustomerDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDAO, Long> {

    CustomerDAO findBycEmail(String cEmail);

    void deleteBycEmail(String cEmail);
}
