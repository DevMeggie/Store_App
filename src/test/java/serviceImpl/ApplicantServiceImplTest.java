package serviceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.Store_App.enums.Gender;
import org.Store_App.enums.Qualification;
import org.Store_App.model.Applicant;
import org.Store_App.model.Store;
import org.Store_App.service.ApplicantService;
import org.Store_App.service.serviceImpl.ApplicantServiceImpl;

class ApplicantServiceImplTest {

        @Test
        void ShouldAddApplicantToApplicantList() {
            Store store = new Store();
            ApplicantService applicantService = new ApplicantServiceImpl();

            Applicant magreth = new Applicant(2, "Magreth", "Martins", "098765434576", Gender.FEMALE, "mg@gmail.com",
                    "Lagos", 70, Qualification.BSC, 4);
            applicantService.apply(magreth, store);

            Assertions.assertFalse(store.getApplicantList().isEmpty());
            Assertions.assertEquals(1, store.getApplicantList().size());

        }

        @Test
        void ShouldReturnApplicationSuccessfulWhenApplicantApply() {
            Store store = new Store();
            ApplicantService applicantService = new ApplicantServiceImpl();


            Applicant magreth = new Applicant(2, "Magreth", "Martins", "098765434576", Gender.FEMALE, "mg@gmail.com",
                    "Lagos", 70, Qualification.BSC, 4);
            String expectedValue = "Application successful";

            Assertions.assertSame(expectedValue, applicantService.apply(magreth, store));

        }

    }
