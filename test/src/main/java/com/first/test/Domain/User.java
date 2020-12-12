package com.first.test.Domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.first.test.service.enums.UserTypes;
import org.hibernate.usertype.UserType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME", length = 50, nullable = false, unique = false)
    private String fName;

    @Column(name = "LAST_NAME", length = 50, nullable = false, unique = false)
    private String lName;

    @Column(name = "CONTACT_NO", length = 10, nullable = false, unique = false)
    private String telephone;

    @Column(name = "USER_TYPE", length = 10, nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private UserTypes userType;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Address> address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}