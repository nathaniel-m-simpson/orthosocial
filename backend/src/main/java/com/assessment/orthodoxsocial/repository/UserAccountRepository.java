package com.assessment.orthodoxsocial.repository;

import com.assessment.orthodoxsocial.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
