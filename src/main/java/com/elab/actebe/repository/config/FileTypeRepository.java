package com.elab.actebe.repository.config;

import com.elab.actebe.domaine.config.FileType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileTypeRepository extends JpaRepository<FileType,Long> {
    FileType findFileTypeByCode(String code);
}
