package com.placementportal.backend.service;

import com.placementportal.backend.entity.Application;
import com.placementportal.backend.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application saveApplication(Application application){
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
}
