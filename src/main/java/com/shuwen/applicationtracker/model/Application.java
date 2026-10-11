package com.shuwen.applicationtracker.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String company;
    @NotBlank
    private String position;
    private LocalDate applicationDate;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;
    private String note;

    public Application() {

    }

    public Application(Long id, String company, String position, LocalDate applicationDate, ApplicationStatus status,
            String note) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.applicationDate = applicationDate;
        this.status = status;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public String getNote() {
        return note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
