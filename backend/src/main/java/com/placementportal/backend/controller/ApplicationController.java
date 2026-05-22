package com.placementportal.backend.controller;

import com.placementportal.backend.entity.Application;
import com.placementportal.backend.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
