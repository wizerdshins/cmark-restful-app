package com.wizerdshins.adminpanel.repository;

import com.wizerdshins.adminpanel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
