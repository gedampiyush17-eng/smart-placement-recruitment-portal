package com.placementportal.backend.service;

import com.placementportal.backend.entity.Application;
import com.placementportal.backend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placementportal.backend.entity.Company;
import com.placementportal.backend.entity.Student;
import com.placementportal.backend.repository.CompanyRepository;
import com.placementportal.backend.repository.StudentRepository;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public Application saveApplication(Application application){
        Long studentId=application.getStudent().getId();
        Long companyId=application.getCompany().getId();

        Student student=studentRepository.findById(studentId)
                .orElseThrow(()->
                        new RuntimeException("Student not found"));

        Company company=companyRepository.findById(companyId)
                .orElseThrow(()->
                        new RuntimeException("Company not found"));

        boolean alreadyApplied=applicationRepository.existsByStudentIdAndCompanyId(studentId,companyId);
        if(alreadyApplied){
            throw new RuntimeException("Student already applied to this company");
        }

        if(student.getCgpa()<company.getMinimumCgpa()){
            throw new RuntimeException("Student does not meet CGPA criteria");
        }

        if(!student.getBranch().equalsIgnoreCase(company.getEligibleBranch())){
            throw new RuntimeException("Student branch is not eligible");
        }

        application.setStudent(student);
        application.setCompany(company);

        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications(){
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Long id){
        return applicationRepository.findById(id).orElse(null);
    }

    public void deleteApplication(Long id){
        applicationRepository.deleteById(id);
    }

    public Application updateApplicationStatus(Long applicationId, String status){
        Application application=applicationRepository.findById(applicationId)
                .orElseThrow(()->
                        new RuntimeException("Application not found"));

        application.setStatus(status);

        return applicationRepository.save(application);
    }

}
