package org.Store_App.model;

import org.Store_App.enums.Gender;
import org.Store_App.enums.Qualification;


public class Applicant extends Person {
    private int testScore;
    private Qualification qualification;
    private int experience;

    public Applicant(int id, String firstName, String lastName, String phoneNo, Gender gender, String email, String address,
                     int testScore, Qualification qualification, int experience) {
        super(id, firstName, lastName, phoneNo, gender, email, address);

        this.experience = experience;
        this.qualification = qualification;
        this.testScore = testScore;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", phoneNo='" + getPhoneNo() + '\'' +
                ", gender=" + getGender() +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                "testScore=" + testScore +
                ", qualification=" + qualification +
                ", experience=" + experience +
                '}';
    }
}



