package com.hms.dharani.persistence.repository;

import com.hms.dharani.persistence.entity.ProvisionalAck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvisionalAckRepository extends JpaRepository<ProvisionalAck,Long> {
}
