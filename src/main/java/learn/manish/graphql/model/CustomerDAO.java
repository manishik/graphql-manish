package learn.manish.graphql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class CustomerDAO {

    public CustomerDAO() {
    }

    public CustomerDAO(String cEmail, String cFirstName, String cMiddleName,
                       String cLastName, int cPhoneNumber, int cCellPhoneNumber) {
        this.cEmail = cEmail;
        this.cFirstName = cFirstName;
        this.cMiddleName = cMiddleName;
        this.cLastName = cLastName;
        this.cPhoneNumber = cPhoneNumber;
        this.cCellPhoneNumber = cCellPhoneNumber;
    }

    @Id
    @Column(name = "custemail")
    private String cEmail;

    @Column(name = "custfirstname")
    private String cFirstName;

    @Column(name = "custmiddlename")
    private String cMiddleName;

    @Column(name = "custlastname")
    private String cLastName;

    @Column(name = "custphonenumber")
    private Integer cPhoneNumber;

    @Column(name = "custcellnumber")
    private Integer cCellPhoneNumber;

}
