package org.Store_App.service.serviceImpl;

import org.Store_App.enums.Role;
import org.Store_App.exceptions.DidntMeetTheCriteriaException;
import org.Store_App.exceptions.NoApplicationFoundException;
import org.Store_App.model.Applicant;
import org.Store_App.model.Cashier;
import org.Store_App.model.Manager;
import org.Store_App.model.Store;
import org.Store_App.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    @Override
    public String hire(Manager manager, Applicant applicant, Store store) {
        if (!store.getApplicantList().contains(applicant)) {
            System.out.println("No application found");
            throw new NoApplicationFoundException("No application found");
        } else {
            if (applicant.getExperience() >= 2 && applicant.getTestScore() >= 60) {
                Cashier staff1 = new Cashier(applicant.getId(), applicant.getFirstName(), applicant.getLastName(), applicant.getPhoneNo(),
                        applicant.getGender(), applicant.getEmail(), applicant.getAddress(), Role.CASHIER, applicant.getQualification());
                store.getStaffList().add(staff1);
                store.getApplicantList().remove(applicant);
                System.out.println("Welcome OnBoard");
                return "Welcome OnBoard";
            } else {
                System.out.println("Sorry, you did not meet the criteria");
                throw new DidntMeetTheCriteriaException("Sorry, you did not meet the criteria");
            }
        }
    }

}
