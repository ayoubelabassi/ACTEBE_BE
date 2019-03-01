package com.elab.actebe.service.intf.project;

import com.elab.actebe.service.dto.project.RevisionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RevisionService {

    RevisionDTO save(RevisionDTO revisionDTO);

    List<RevisionDTO> readAll();

    List<RevisionDTO> findByPlan(long planID);

    List<RevisionDTO> findByProject(long projectID);


}
