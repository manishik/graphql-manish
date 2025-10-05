package manish.graphql.service;

import manish.graphql.dto.CustomerAddressDTO;
import manish.graphql.exceptions.CustomerNotFoundException;
import manish.graphql.model.CustomerAddressDAO;
import manish.graphql.model.CustomerDAO;
import manish.graphql.repository.CustomerAddressRepository;
import manish.graphql.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CustomerAddressService {

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerAddressDTO getCustomerAddressByEmail(String customerEmail) {
        log.info("Inside Service: getCustomerAddressByEmail");
        CustomerAddressDAO customerAddressDAO = customerAddressRepository.findBycEmail(customerEmail);
        if (customerAddressDAO != null) {
            return modelMapper.map(customerAddressDAO, CustomerAddressDTO.class);
        }
        throw new CustomerNotFoundException("Customer Email ID not found");
    }

    @Transactional
    public CustomerAddressDTO createCustomerAddress(CustomerAddressDTO customerAddressDTO) {
        CustomerAddressDAO customerAddressDAO = modelMapper.map(customerAddressDTO, CustomerAddressDAO.class);
        CustomerDAO customerDAO1 = customerRepository.findBycEmail(customerAddressDAO.getCEmail());
        if (customerDAO1 != null) { // Customer found
            CustomerAddressDAO customerAddressDAO2 = customerAddressRepository.saveAndFlush(customerAddressDAO);
            return modelMapper.map(customerAddressDAO2, CustomerAddressDTO.class);
        } else {
            throw new CustomerNotFoundException("Customer Email ID not found");
        }
    }

    @Transactional()
    public CustomerAddressDTO updateCustomerAddressByEmail(CustomerAddressDTO customerAddressDTO) {
        // Check if user exists
        CustomerAddressDAO customerAddressDAO = modelMapper.map(customerAddressDTO, CustomerAddressDAO.class);
        CustomerDAO customerDAO1 = customerRepository.findBycEmail(customerAddressDAO.getCEmail());
        if (customerDAO1 != null) {
            CustomerAddressDAO customerAddressDAO2 = customerAddressRepository.save(customerAddressDAO);
            return modelMapper.map(customerAddressDAO2, CustomerAddressDTO.class);
        } else {
            throw new CustomerNotFoundException("Customer Email ID not found");
        }
    }

    @Transactional
    public CustomerAddressDTO deleteCustomerAddressByEmail(String customerEmail) {
        CustomerDAO customerDAO = customerRepository.findBycEmail(customerEmail);
        if (customerDAO != null) {
            CustomerAddressDAO customerAddressDAO1 = customerAddressRepository.deleteBycEmail(customerEmail);
            return modelMapper.map(customerAddressDAO1, CustomerAddressDTO.class);
        } else {
            throw new CustomerNotFoundException("Customer Email ID not found");
        }
    }

}
