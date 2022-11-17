package org.Store_App.service;

import org.Store_App.model.Applicant;
import org.Store_App.model.Manager;
import org.Store_App.model.Store;

public interface ManagerService {

    String hire(Manager manager, Applicant applicant, Store store);
}
