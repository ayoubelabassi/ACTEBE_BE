package com.elab.actebe.service.mapper.config;

import com.elab.actebe.domaine.config.Function;
import com.elab.actebe.service.dto.config.FunctionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FunctionMapper{

    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    FunctionDTO FunctionToFunctionDTO(Function Function);

    List<FunctionDTO> FunctionsToFunctionDTOs(List<Function> Functions);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    Function FunctionDTOtoFunction(FunctionDTO FunctionDTO);

    List<Function> FunctionDTOsToFunctions(List<FunctionDTO> Functions);
}
