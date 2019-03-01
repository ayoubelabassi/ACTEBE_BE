package com.elab.actebe.service.impl.project;

import com.elab.actebe.repository.project.RevisionRepository;
import com.elab.actebe.service.intf.project.RevisionService;
import com.elab.actebe.service.dto.project.RevisionDTO;
import com.elab.actebe.service.mapper.project.RevisionMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RevisionServiceImpl implements RevisionService {

    @Inject
    private RevisionRepository revisionRepository;

    @Inject
    private RevisionMapper revisionMapper;

    @Override
    public RevisionDTO save(RevisionDTO revisionDTO) {
        return null;
    }

    @Override
    public List<RevisionDTO> readAll() {
        return null;
    }

    @Override
    public List<RevisionDTO> findByPlan(long planID) {
        return null;
    }

    @Override
    public List<RevisionDTO> findByProject(long projectID) {
        return null;
    }
}
