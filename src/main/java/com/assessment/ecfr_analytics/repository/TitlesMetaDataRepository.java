package com.assessment.ecfr_analytics.repository;

import com.assessment.ecfr_analytics.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitlesMetaDataRepository extends JpaRepository<Title, Long> {
}

