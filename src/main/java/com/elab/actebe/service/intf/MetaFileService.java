package com.elab.actebe.service.intf;

import com.elab.actebe.domaine.config.MetaFile;
import org.springframework.stereotype.Service;

@Service
public interface MetaFileService {

    MetaFile save(MetaFile metaFile);
}
