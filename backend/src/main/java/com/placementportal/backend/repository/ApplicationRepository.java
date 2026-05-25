package com.placementportal.backend.repository;

import com.placementportal.backend.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
    boolean existsByStudentIdAndCompanyId(Long studentId,Long companyId);
    List<Application> findByStatus(String status);

    List<Application> findByCompanyId(Long companyId);

    List<Application> findByStudentId(Long studentId);

    long countByStatus(String status);
}
