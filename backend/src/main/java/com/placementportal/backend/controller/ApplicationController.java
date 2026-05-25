package com.placementportal.backend.controller;

import com.placementportal.backend.entity.Application;
import com.placementportal.backend.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping
    public Application addApplication(@Valid @RequestBody Application application){
        return applicationService.saveApplication(application);
    }

    @GetMapping
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable Long id){
        return applicationService.getApplicationById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteApplication(@PathVariable Long id){
        applicationService.deleteApplication(id);

        return "Application deleted successfully";
    }

    @PutMapping("/{id}/status")
    public Application updateApplicationStatus(@PathVariable Long id, @RequestParam String status){

        return applicationService.updateApplicationStatus(id,status);
    }

    @GetMapping("/status/{status}")
    public List<Application> getApplicationsByStatus(@PathVariable String status){
        return applicationService.getApplicationsByStatus(status);
    }

    @GetMapping("/company/{companyId}")
    public List<Application> getApplicationsByCompany(@PathVariable Long companyId){
        return applicationService.getApplicationsByCompany(companyId);
    }

    @GetMapping("/student/{studentId}")
    public List<Application> getApplicationsByStudent(@PathVariable Long studentId){
        return applicationService.getApplicationsByStudent(studentId);
    }

    @GetMapping("/count/{status}")
    public long countApplicationsByStatus(@PathVariable String status){
        return applicationService.countApplicationsByStatus(status);
    }

    @GetMapping("/sorted")
    public List<Application> getAllApplicationsSorted(){
        return applicationService.getAllApplicationsSorted();
    }

    @GetMapping("/paginated")
    public Page<Application> getApplicationsPaginated(@RequestParam int page, @RequestParam int size){
        return applicationService.getApplicationsPaginated(page,size);
    }
}
