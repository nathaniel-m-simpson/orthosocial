package com.assessment.ecfr_analytics.repository;

import com.assessment.ecfr_analytics.model.CfrReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CfrReferenceRepository extends JpaRepository<CfrReference, Long> {
}
