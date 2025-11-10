package com.amefrica.hostal.persistence.repository;

import com.amefrica.hostal.persistence.entity.RoleEntity;
import com.amefrica.hostal.persistence.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {


    Optional<RoleEntity> findByRoleEnum(RoleEnum roleEnum);
}
