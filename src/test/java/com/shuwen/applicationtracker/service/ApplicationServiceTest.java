package com.shuwen.applicationtracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.shuwen.applicationtracker.exception.ApplicationNotFoundException;
import com.shuwen.applicationtracker.model.Application;
import com.shuwen.applicationtracker.model.ApplicationStatus;

@SpringBootTest
class ApplicationServiceTest {
    @Autowired
    private ApplicationService applicationService;

    @Test
    void addApplicationShouldSave() {
        Application application = new Application();
        application.setCompany("Bosch");
        application.setPosition("Java Intern");
        application.setApplicationDate(LocalDate.of(2026, 9, 3));
        application.setStatus(ApplicationStatus.APPLIED);
        application.setNote("Test");
        Application saved = applicationService.addApplication(application);
        assertNotNull(saved.getId());
        assertEquals("Bosch", saved.getCompany());
        assertEquals("Java Intern", saved.getPosition());
        assertEquals(LocalDate.of(2026, 9, 3), saved.getApplicationDate());
        assertEquals(ApplicationStatus.APPLIED, saved.getStatus());
        assertEquals("Test", saved.getNote());
    }

    @Test
    void getApplicationByIdCanBeFound() {
        Application application = new Application();
        application.setCompany("Bosch");
        application.setPosition("Java Intern");
        application.setApplicationDate(LocalDate.of(2026, 9, 3));
        application.setStatus(ApplicationStatus.APPLIED);
        application.setNote("Test");
        Application saved = applicationService.addApplication(application);
        Application found = applicationService.getApplicationbyId(saved.getId());
        assertEquals("Bosch", found.getCompany());
        assertEquals(saved.getId(), found.getId());
    }

    @Test
    void getApplicationByIdNotFound() {
        assertThrows(
                ApplicationNotFoundException.class,
                () -> applicationService.getApplicationbyId(999L));
    }

    @Test
    void updateApplicationIsNew() {
        Application application1 = new Application();
        application1.setCompany("Bosch");
        application1.setPosition("Java Intern");
        application1.setApplicationDate(LocalDate.of(2026, 9, 3));
        application1.setStatus(ApplicationStatus.APPLIED);
        application1.setNote("Test");
        Application saved1 = applicationService.addApplication(application1);
        Application application2 = new Application();
        application2.setCompany("SAP");
        application2.setPosition("Software development intern");
        application2.setApplicationDate(LocalDate.of(2026, 9, 5));
        application2.setStatus(ApplicationStatus.WAITING);
        application2.setNote("Test2");
        applicationService.updateApplication(saved1.getId(), application2);
        Application found = applicationService.getApplicationbyId(saved1.getId());
        assertEquals("SAP", found.getCompany());
        assertEquals("Software development intern", found.getPosition());
        assertEquals(LocalDate.of(2026, 9, 5), found.getApplicationDate());
        assertEquals(ApplicationStatus.WAITING, found.getStatus());
        assertEquals("Test2", found.getNote());
        assertEquals(saved1.getId(), found.getId());
    }

    @Test
    void updateApplicationIdNotFound() {
        Application application = new Application();
        application.setCompany("Bosch");
        application.setPosition("Java Intern");
        application.setApplicationDate(LocalDate.of(2026, 9, 3));
        application.setStatus(ApplicationStatus.APPLIED);
        application.setNote("Test");
        assertThrows(ApplicationNotFoundException.class, () -> applicationService.updateApplication(999L, application));
    }

    @Test
    void deleteApplicationSuccess() {
        Application application = new Application();
        application.setCompany("Bosch");
        application.setPosition("Java Intern");
        application.setApplicationDate(LocalDate.of(2026, 9, 3));
        application.setStatus(ApplicationStatus.APPLIED);
        application.setNote("Test");
        Application saved = applicationService.addApplication(application);
        applicationService.deleteApplication(saved.getId());
        assertThrows(ApplicationNotFoundException.class, () -> applicationService.getApplicationbyId(saved.getId()));
    }

    @Test
    void deleteApplicationNotExist() {
        assertThrows(ApplicationNotFoundException.class, () -> applicationService.deleteApplication(999L));
    }

    @Test
    void getApplicationByStatusReturn() {
        Application application = new Application();
        application.setCompany("Bosch");
        application.setPosition("Java Intern");
        application.setApplicationDate(LocalDate.of(2026, 9, 3));
        application.setStatus(ApplicationStatus.APPLIED);
        application.setNote("Test");
        Application saved = applicationService.addApplication(application);
        List<Application> found = applicationService.getApplicationsByStatus(ApplicationStatus.APPLIED);
        assertTrue(found.stream().anyMatch(app -> app.getId().equals(saved.getId())));
    }

}
