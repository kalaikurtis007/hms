package com.hms.dharani.web.serviceimpl;

import com.hms.dharani.persistence.repository.MilkTypeRepository;
import com.hms.dharani.web.service.MilkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MilkTypeServiceImpl implements MilkTypeService {
    @Autowired
    private MilkTypeRepository milkTypeRepository;


}
