package com.hms.dharani.web.serviceimpl;

import com.hms.dharani.persistence.entity.ProvisionalAck;
import com.hms.dharani.persistence.repository.ProvisionalAckRepository;
import com.hms.dharani.web.service.ProvisionalAckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvisionalAckServiceImpl implements ProvisionalAckService {
    @Autowired
    private ProvisionalAckRepository provisionalAckRepository;

    @Override
    public ProvisionalAck store(ProvisionalAck provisionalAck) {
        return provisionalAckRepository.save(provisionalAck);
    }

    @Override
    public List<ProvisionalAck> getAll() {
        return provisionalAckRepository.findAll();
    }
}
