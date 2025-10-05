package learn.manish.graphql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customeraddress")
public class CustomerAddressDAO {

    public CustomerAddressDAO() {
    }

    public CustomerAddressDAO(String cEmail, Integer doorNo, String street1, String street2,
                              String area, Integer zipCode, String state, String country,
                              String addressType, String phoneNumber, String email) {
        this.cEmail = cEmail;
        this.doorNo = doorNo;
        this.street1 = street1;
        this.street2 = street2;
        this.area = area;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.addressType = addressType;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Id
    @Column(name = "custemail")
    private String cEmail;

    @Column(name = "doorno")
    private Integer doorNo;

    @Column(name = "street1")
    private String street1;

    @Column(name = "street2")
    private String street2;

    @Column(name = "area")
    private String area;

    @Column(name = "zipcode")
    private Integer zipCode;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "addresstype")
    private String addressType;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
