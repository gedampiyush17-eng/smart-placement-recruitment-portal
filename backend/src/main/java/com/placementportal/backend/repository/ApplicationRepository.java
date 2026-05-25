package com.placementportal.backend.repository;

import com.placementportal.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
    boolean existsByStudentIdAndCompanyId(Long studentId,Long companyId);
}
