package manish.graphql.controller;

import manish.graphql.dto.CustomerAddressDTO;
import manish.graphql.dto.CustomerDTO;
import manish.graphql.service.CustomerAddressService;
import manish.graphql.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerAddressService customerAddressService;

    @QueryMapping
    public List<CustomerDTO> listAllCustomers() {
        return customerService.getAllCustomers();
    }

    @MutationMapping
    public CustomerDTO addCustomer(@Argument CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @MutationMapping
    public CustomerDTO updateCustomerByEmail(@Argument String cEmail, @Argument String cFirstName, @Argument String cMiddleName, @Argument String cLastName,
                                             @Argument Integer cPhoneNumber, @Argument Integer cCellPhoneNumber) {
        CustomerDTO customerDTO = createCustomerDTO(cEmail, cFirstName, cMiddleName, cLastName, cPhoneNumber, cCellPhoneNumber);
        return customerService.updateCustomerByEmail(customerDTO);
    }

    @MutationMapping
    public String deleteCustomerByEmail(@Argument String cEmail) {
        return customerService.deleteCustomer(cEmail);
    }

    @QueryMapping
    public CustomerDTO getCustomerByEmailId(@Argument String cEmail) {
        return customerService.getCustomerByEmail(cEmail);
    }

    @SchemaMapping(typeName = "Customer", field = "cAddress")
    public CustomerAddressDTO getCustomerAddressByEmailID(CustomerDTO customerDTO) {
        log.info("Inside Controller: getCustomerAddressByEmailID...");
        return customerAddressService.getCustomerAddressByEmail(customerDTO.getCEmail());
    }

    private CustomerDTO createCustomerDTO(String cEmail, String cFirstName, String cMiddleName, String cLastName,
                                          Integer cPhoneNumber, Integer cCellPhoneNumber){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCEmail(cEmail);
        customerDTO.setCFirstName(cFirstName);
        customerDTO.setCMiddleName(cMiddleName);
        customerDTO.setCLastName(cLastName);
        customerDTO.setCPhoneNumber(cPhoneNumber);
        customerDTO.setCCellPhoneNumber(cCellPhoneNumber);
        return customerDTO;
    }

}
