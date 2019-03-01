package com.elab.actebe.service.impl.config;

import com.elab.actebe.domaine.config.Function;
import com.elab.actebe.repository.config.FunctionRepository;
import com.elab.actebe.service.intf.config.FunctionService;
import com.elab.actebe.service.dto.config.FunctionDTO;
import com.elab.actebe.service.mapper.config.FunctionMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Inject
    private FunctionRepository functionRepository;

    @Inject
    private FunctionMapper functionMapper;

    @Override
    public FunctionDTO save(FunctionDTO functionDTO) {
        Function function = functionMapper.FunctionDTOtoFunction(functionDTO);
        function = functionRepository.save(function);
        function = functionRepository.getOne(function.getId());
        return functionMapper.FunctionToFunctionDTO(function);
    }

    @Override
    public List<FunctionDTO> findAll() {
        List<Function> functions = functionRepository.getAllByDeleted(false);
        return functionMapper.FunctionsToFunctionDTOs(functions);
    }
}
