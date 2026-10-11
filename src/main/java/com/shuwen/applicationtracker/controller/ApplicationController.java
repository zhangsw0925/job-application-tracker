package com.shuwen.applicationtracker.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.shuwen.applicationtracker.model.Application;
import com.shuwen.applicationtracker.model.ApplicationStatus;
import com.shuwen.applicationtracker.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getApplications() {
        return applicationService.getApplications();
    }

    @PostMapping
    public Application addApplication(@Valid @RequestBody Application application) {
        return applicationService.addApplication(application);
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationbyId(id);
    }

    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable Long id, @Valid @RequestBody Application updatedApplication) {
        return applicationService.updateApplication(id, updatedApplication);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }

    @GetMapping("/status/{status}")
    public List<Application> getApplicationByStatus(@PathVariable ApplicationStatus status) {
        return applicationService.getApplicationsByStatus(status);
    }

}
