package com.assessment.orthodoxsocial.repository;

import com.assessment.orthodoxsocial.model.CfrReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CfrReferenceRepository extends JpaRepository<CfrReference, Long> {
}
