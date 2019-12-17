package com.wizerdshins.adminpanel.repository;

import com.wizerdshins.adminpanel.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("from Role r where r.id = :id")
    Role findRoleById(@Param("id") Integer id);

}
