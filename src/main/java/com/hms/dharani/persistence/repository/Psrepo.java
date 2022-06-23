package com.hms.dharani.persistence.repository;

import com.hms.dharani.persistence.entity.Ps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Psrepo extends JpaRepository<Ps, Long> {
}
