package learn.manish.graphql.controller;

import learn.manish.graphql.dto.CustomerAddressDTO;
import learn.manish.graphql.service.CustomerAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @MutationMapping
    public CustomerAddressDTO addAddressByEmail(@Argument String cEmail, @Argument int doorNo, @Argument String street1, @Argument String street2,
                                                @Argument String area, @Argument int zipCode, @Argument String state, @Argument String country,
                                                @Argument String addressType, @Argument String phoneNumber, @Argument String email) {
        CustomerAddressDTO customerAddressDTO = createCustomerAddressDTO(cEmail, doorNo, street1, street2, area, zipCode, state, country, addressType, phoneNumber, email);
        return customerAddressService.createCustomerAddress(customerAddressDTO);
    }

    @MutationMapping
    public CustomerAddressDTO updateAddressByEmail(@Argument String cEmail, @Argument int doorNo, @Argument String street1, @Argument String street2,
                                                   @Argument String area, @Argument int zipCode, @Argument String state, @Argument String country,
                                                   @Argument String addressType, @Argument String phoneNumber, @Argument String email) {
        CustomerAddressDTO customerAddressDTO = createCustomerAddressDTO(cEmail, doorNo, street1, street2, area, zipCode, state, country, addressType, phoneNumber, email);
        return customerAddressService.updateCustomerAddressByEmail(customerAddressDTO);
    }

    @MutationMapping
    public CustomerAddressDTO deleteAddressByEmail(@Argument String cEmail) {
        return customerAddressService.deleteCustomerAddressByEmail(cEmail);
    }

    private CustomerAddressDTO createCustomerAddressDTO(String cEmail, int doorNo, String street1, String street2, String area,
                                                        int zipCode, String state, String country, String addressType, String phoneNumber, String email) {
        CustomerAddressDTO customerAddressDTO = new CustomerAddressDTO();
        customerAddressDTO.setCEmail(cEmail);
        customerAddressDTO.setDoorNo(doorNo);
        customerAddressDTO.setStreet1(street1);
        customerAddressDTO.setStreet2(street2);
        customerAddressDTO.setArea(area);
        customerAddressDTO.setZipCode(zipCode);
        customerAddressDTO.setState(state);
        customerAddressDTO.setCountry(country);
        customerAddressDTO.setAddressType(addressType);
        customerAddressDTO.setEmail(email);
        customerAddressDTO.setPhoneNumber(phoneNumber);
        return customerAddressDTO;
    }

}
