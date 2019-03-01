package com.elab.actebe.service.intf.config;

import com.elab.actebe.service.dto.config.FileTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileTypeService {
    public FileTypeDTO findFileType(Long id);

    public FileTypeDTO findOne(String code);

    public List<FileTypeDTO> readAll();

    public FileTypeDTO save(FileTypeDTO entity);
}
