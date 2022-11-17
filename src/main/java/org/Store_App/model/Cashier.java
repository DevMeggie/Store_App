package org.Store_App.model;

import org.Store_App.enums.Gender;
import org.Store_App.enums.Qualification;
import org.Store_App.enums.Role;


public class Cashier extends Person {
    private Role role;
    private Qualification qualification;

    public Cashier(int id, String firstName, String lastName, String phoneNo, Gender gender, String email, String address, Role role, Qualification qualification) {
        super(id, firstName, lastName, phoneNo, gender, email, address);
        this.qualification = qualification;
        this.role = role;
    }

    public Cashier () {

    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNo='" + getPhoneNo() + '\'' +
                ", gender=" + getGender() +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                "role=" + role +
                ", qualification=" + qualification +
                '}';
    }
}
