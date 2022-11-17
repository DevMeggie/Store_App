package org.Store_App.service.serviceImpl;

import org.Store_App.model.Applicant;
import org.Store_App.model.Store;
import org.Store_App.service.ApplicantService;

public class ApplicantServiceImpl implements ApplicantService {
    @Override
    public String apply(Applicant applicant, Store store) {
        store.getApplicantList().add(applicant);
        System.out.println("Application successful");
        return "Application successful";
    }
}
