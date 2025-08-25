package com.assessment.ecfr_analytics.repository;

import com.assessment.ecfr_analytics.model.Correction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrectionsRepository extends JpaRepository<Correction, Long> {
}
