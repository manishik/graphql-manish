package manish.graphql.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private String cEmail;
    private String cFirstName;
    private String cMiddleName;
    private String cLastName;
    private Integer cPhoneNumber;
    private Integer cCellPhoneNumber;
    private CustomerAddressDTO cAddress;

}
