package com.shuwen.applicationtracker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.shuwen.applicationtracker.exception.ApplicationNotFoundException;
import com.shuwen.applicationtracker.model.Application;
import com.shuwen.applicationtracker.repository.ApplicationRepository;
import com.shuwen.applicationtracker.model.ApplicationStatus;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }

    public Application getApplicationbyId(Long id) {
        return applicationRepository.findById(id).orElseThrow(() -> new ApplicationNotFoundException(id));
    }

    public Application updateApplication(Long id, Application updatedApplication) {
        if (!applicationRepository.existsById(id)) {
            throw new ApplicationNotFoundException(id);
        }
        updatedApplication.setId(id);
        return applicationRepository.save(updatedApplication);

    }

    public void deleteApplication(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new ApplicationNotFoundException(id);
        }
        applicationRepository.deleteById(id);
    }

    public List<Application> getApplicationsByStatus(ApplicationStatus status) {
        return applicationRepository.findByStatus(status);
    }

}
