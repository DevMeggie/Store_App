package serviceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.Store_App.enums.Gender;
import org.Store_App.enums.Qualification;
import org.Store_App.enums.Role;
import org.Store_App.exceptions.DidntMeetTheCriteriaException;
import org.Store_App.exceptions.NoApplicationFoundException;
import org.Store_App.model.Applicant;
import org.Store_App.model.Manager;
import org.Store_App.model.Store;
import org.Store_App.service.ManagerService;
import org.Store_App.service.serviceImpl.ManagerServiceImpl;

class ManagerServiceImplTest {

    @Test
    void hireShouldReturnWelcomeOnboardWhenApplicantQualificationIsEqualsTestScore() {
        Store store = new Store();
        ManagerService managerService = new ManagerServiceImpl();
        Manager manager = new Manager(2, "mary", "ofundu", "+234678387",
                Gender.FEMALE, "mo@gmail.com", "abuja", Role.MANAGER, Qualification.PHD);

        Applicant applicant = new Applicant(4, "margret", "martins", "+2346",
                Gender.FEMALE, "mm@gmail.com", "abuja", 60, Qualification.BSC, 4);

        store.getApplicantList().add(applicant);
        managerService.hire(manager, applicant, store);

        Assertions.assertFalse(store.getStaffList().isEmpty());
    }

    @Test
    void shouldThrowExceptionIfApplicantListDoesNotContainApplicant() {
        Store store = new Store();
        ManagerService managerService = new ManagerServiceImpl();
        Manager manager = new Manager(2, "mary", "ofundu", "+234678387",
                Gender.FEMALE, "mo@gmail.com", "abuja", Role.MANAGER, Qualification.PHD);

        Applicant applicant = new Applicant(4, "margret", "martins", "+2346",
                Gender.FEMALE, "mm@gmail.com", "abuja", 60, Qualification.BSC, 4);


        Assertions.assertThrows(NoApplicationFoundException.class,()-> managerService.hire(manager, applicant, store));
    }

    @Test
    void ShouldReturnSorryYouDidntMeetTheCriteria() {
        Store store = new Store();
        ManagerService managerService = new ManagerServiceImpl();

        Manager manager = new Manager(2, "mary", "ofundu", "+234678387",
                Gender.FEMALE, "mo@gmail.com", "abuja", Role.MANAGER, Qualification.PHD);

        Applicant applicant = new Applicant(3, "vida", "sebastine", "593030", Gender.FEMALE,
                "vs@gmail.com", "Lagos", 40, Qualification.BSC, 1);

        store.getApplicantList().add(applicant);

        Assertions.assertThrows(DidntMeetTheCriteriaException.class, () -> managerService.hire(manager, applicant, store));
    }

}