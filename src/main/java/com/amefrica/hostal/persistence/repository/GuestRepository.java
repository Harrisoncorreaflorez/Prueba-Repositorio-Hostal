package com.amefrica.hostal.persistence.repository;

import com.amefrica.hostal.persistence.entity.GuestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestEntity, Integer> {
}
