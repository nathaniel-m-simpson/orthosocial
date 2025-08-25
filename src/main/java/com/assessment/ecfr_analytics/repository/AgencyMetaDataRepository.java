package com.assessment.ecfr_analytics.repository;


import com.assessment.ecfr_analytics.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AgencyMetaDataRepository extends JpaRepository<Agency, Long> {
}

