package com.placementportal.backend.service;

import com.placementportal.backend.entity.Company;
import com.placementportal.backend.repository.CompanyRepository;
import com.placementportal.backend.exception.CompanyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(()->new CompanyNotFoundException("Company not found with id "+ id));
    }

    public Company updateCompany(Long id, Company updatedCompany){

        Company existingCompany=companyRepository.findById(id).orElse(null);
        if(existingCompany!=null){
            existingCompany.setCompanyName(updatedCompany.getCompanyName());
            existingCompany.setRole(updatedCompany.getRole());
            existingCompany.setPackageOffered(updatedCompany.getPackageOffered());
            existingCompany.setMinimumCgpa(updatedCompany.getMinimumCgpa());
            existingCompany.setEligibleBranch(updatedCompany.getEligibleBranch());
            existingCompany.setRequiredSkills(updatedCompany.getRequiredSkills());

            return companyRepository.save(existingCompany);
        }
        return null;
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }

}
