package com.hms.dharani.web.service;

import com.hms.dharani.persistence.entity.ProvisionalAck;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ProvisionalAckService {
    ProvisionalAck store(ProvisionalAck provisionalAck);

    List<ProvisionalAck> getAll();
}
