package com.elab.actebe.service.mapper.config;

import com.elab.actebe.domaine.config.FileType;
import com.elab.actebe.service.dto.config.FileTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FileTypeMapper {
    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    FileTypeDTO FileTypeToFileTypeDTO(FileType FileType);

    List<FileTypeDTO> FileTypesToFileTypeDTOs(List<FileType> FileTypes);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    FileType FileTypeDTOtoFileType(FileTypeDTO FileTypeDTO);

    List<FileType> FileTypeDTOsToFileTypes(List<FileTypeDTO> FileTypes);
}
