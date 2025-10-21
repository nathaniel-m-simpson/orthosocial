package com.assessment.orthodoxsocial.repository;

import com.assessment.orthodoxsocial.model.Correction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrectionsRepository extends JpaRepository<Correction, Long> {
}
