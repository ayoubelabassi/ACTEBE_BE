package com.elab.actebe.service.intf.config;

import com.elab.actebe.service.dto.config.FunctionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FunctionService {

    FunctionDTO save(FunctionDTO functionDTO);

    List<FunctionDTO> findAll();
}
