package com.amefrica.hostal.persistence.repository;

import com.amefrica.hostal.persistence.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}
