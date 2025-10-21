package com.assessment.orthodoxsocial.repository;


import com.assessment.orthodoxsocial.model.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AgencyMetaDataRepository extends JpaRepository<Agency, Long> {
}

