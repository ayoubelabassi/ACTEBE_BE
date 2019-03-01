package com.elab.actebe.service.impl.config;

import com.elab.actebe.domaine.config.FileType;
import com.elab.actebe.repository.config.FileTypeRepository;
import com.elab.actebe.service.intf.config.FileTypeService;
import com.elab.actebe.service.dto.config.FileTypeDTO;
import com.elab.actebe.service.mapper.config.FileTypeMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class FileTypeServiceImpl implements FileTypeService {

    @Inject
    private FileTypeRepository fileTypeRepository;

    @Inject
    private FileTypeMapper fileTypeMapper;

    @Override
    public FileTypeDTO findFileType(Long id) {
        FileType fileType = this.fileTypeRepository.getOne(id);
        return this.fileTypeMapper.FileTypeToFileTypeDTO(fileType);
    }

    @Override
    public FileTypeDTO findOne(String code) {
        FileType fileType = this.fileTypeRepository.findFileTypeByCode(code);
        return this.fileTypeMapper.FileTypeToFileTypeDTO(fileType);
    }

    @Override
    public List<FileTypeDTO> readAll() {
        List<FileType> fileTypes = this.fileTypeRepository.findAll();
        return this.fileTypeMapper.FileTypesToFileTypeDTOs(fileTypes);
    }

    @Override
    public FileTypeDTO save(FileTypeDTO entity) {
        return null;
    }
}
