package com.assessment.orthodoxsocial.repository;

import com.assessment.orthodoxsocial.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitlesMetaDataRepository extends JpaRepository<Title, Long> {
}

