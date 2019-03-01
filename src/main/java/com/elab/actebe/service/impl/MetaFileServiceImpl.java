package com.elab.actebe.service.impl;

import com.elab.actebe.domaine.config.MetaFile;
import com.elab.actebe.repository.MetaFileRepository;
import com.elab.actebe.service.intf.MetaFileService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MetaFileServiceImpl implements MetaFileService {

    @Inject
    private MetaFileRepository fileRepository;

    @Override
    public MetaFile save(MetaFile metaFile) {
        return fileRepository.save(metaFile);
    }
}
