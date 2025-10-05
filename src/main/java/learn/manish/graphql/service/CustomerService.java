package learn.manish.graphql.service;

import learn.manish.graphql.dto.CustomerDTO;
import learn.manish.graphql.exceptions.CustomerAlreadyExistsException;
import learn.manish.graphql.exceptions.CustomerNotFoundException;
import learn.manish.graphql.model.CustomerDAO;
import learn.manish.graphql.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDAO> customersDAO = customerRepository.findAll();
        return Arrays.asList(modelMapper.map(customersDAO, CustomerDTO[].class));
    }

    public CustomerDTO getCustomerByEmail(String customerEmail) {
        CustomerDAO customerDAO = customerRepository.findBycEmail(customerEmail);
        if (customerDAO != null) {
            return modelMapper.map(customerDAO, CustomerDTO.class);
        }
        throw new CustomerNotFoundException("Customer Email ID not found");
    }

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerDAO customerDAO = modelMapper.map(customerDTO, CustomerDAO.class);
        CustomerDAO customerDAO1 = customerRepository.findBycEmail(customerDAO.getCEmail());
        if (customerDAO1 == null) {
            CustomerDAO customerDAO2 = customerRepository.saveAndFlush(customerDAO);
            return modelMapper.map(customerDAO2, CustomerDTO.class);
        } else {
            throw new CustomerAlreadyExistsException("Customer Email ID Already exists");
        }
    }

    @Transactional()
    public CustomerDTO updateCustomerByEmail(CustomerDTO customerDTO) {
        // Check if user exists
        CustomerDAO customerDAO = modelMapper.map(customerDTO, CustomerDAO.class);
        CustomerDAO customerDAO1 = customerRepository.findBycEmail(customerDAO.getCEmail());
        if (customerDAO1 != null) {
            CustomerDAO customerDAO2 = customerRepository.save(customerDAO);
            return modelMapper.map(customerDAO2, CustomerDTO.class);
        } else {
            throw new CustomerNotFoundException("Customer Email ID not found");
        }
    }

    @Transactional
    public String deleteCustomer(String customerEmail) {
        CustomerDAO customerDAO = customerRepository.findBycEmail(customerEmail);
        if (customerDAO != null) {
            customerRepository.deleteBycEmail(customerEmail);
            return "Successfully deleted customer with email: " + customerEmail;
        } else {
            throw new CustomerNotFoundException("Customer Email ID not found");
        }
    }
}
