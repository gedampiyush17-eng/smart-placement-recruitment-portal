package com.placementportal.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="companies")
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Company name cannot be empty")
    private String companyName;

    @NotBlank(message="Role cannot be empty")
    private String role;

    @Min(value=1, message="Package must be greater than 0")
    private Double packageOffered;

    @Min(value=0, message="Minimum CGPA cannot be less than 0")
    @Max(value=10,message="Minimum CGPA cannot be greater than 10")
    private Double minimumCgpa;

    @NotBlank(message="Eligible branch cannot be empty")
    private String eligibleBranch;

    @NotBlank(message="Required skills cannot be empty")
    private String requiredSkills;

    public Company(){

    }

    public Company(Long id, String companyName, String role,
                   Double packageOffered, Double minimumCgpa,
                   String eligibleBranch, String requiredSkills) {

        this.id = id;
        this.companyName = companyName;
        this.role = role;
        this.packageOffered = packageOffered;
        this.minimumCgpa = minimumCgpa;
        this.eligibleBranch = eligibleBranch;
        this.requiredSkills = requiredSkills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getPackageOffered() {
        return packageOffered;
    }

    public void setPackageOffered(Double packageOffered) {
        this.packageOffered = packageOffered;
    }

    public Double getMinimumCgpa() {
        return minimumCgpa;
    }

    public void setMinimumCgpa(Double minimumCgpa) {
        this.minimumCgpa = minimumCgpa;
    }

    public String getEligibleBranch() {
        return eligibleBranch;
    }

    public void setEligibleBranch(String eligibleBranch) {
        this.eligibleBranch = eligibleBranch;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}
