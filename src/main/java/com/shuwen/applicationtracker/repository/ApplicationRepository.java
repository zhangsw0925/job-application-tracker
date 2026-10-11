package com.shuwen.applicationtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shuwen.applicationtracker.model.Application;
import com.shuwen.applicationtracker.model.ApplicationStatus;
import java.util.List;


public interface ApplicationRepository extends JpaRepository<Application, Long>{

    List<Application> findByStatus(ApplicationStatus status);
} 