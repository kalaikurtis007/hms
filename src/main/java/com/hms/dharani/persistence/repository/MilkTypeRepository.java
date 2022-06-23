package com.hms.dharani.persistence.repository;

import com.hms.dharani.persistence.entity.MilkType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilkTypeRepository extends JpaRepository<MilkType, Long> {
}
