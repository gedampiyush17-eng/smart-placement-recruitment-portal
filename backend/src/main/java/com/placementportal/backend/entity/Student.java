package com.placementportal.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @NotBlank(message="Name cannot be empty")
    private String name;

    @Email(message="Invalid email format")
    @NotBlank(message="Email cannot be empty")
    private String email;

    @Min(value=0, message="CGPA cannot be less than 0")
    @Max(value=10, message="CGPA cannot be greater than 10")
    private Double cgpa;

    @NotBlank(message="Branch cannot be empty")
    private String branch;

    @NotBlank(message="Skills cannot be empty")
    private String skills;

    public Student(){

    }

    public Student(Long id, String name, String email, Double cgpa, String branch, String skills){
        this.id=id;
        this.name=name;
        this.email=email;
        this.cgpa=cgpa;
        this.branch=branch;
        this.skills=skills;

    }
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


}
