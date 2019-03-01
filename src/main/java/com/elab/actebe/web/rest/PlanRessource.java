package com.elab.actebe.web.rest;

import com.elab.actebe.service.intf.project.PlanService;
import com.elab.actebe.service.dto.project.PlanDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanRessource {

    @Inject
    private PlanService planService;

    @RequestMapping(value = "/save")
    public ResponseEntity<PlanDTO> savePlan(@RequestBody PlanDTO planDTO){
        PlanDTO dto=planService.save(planDTO);
        return new ResponseEntity<PlanDTO>(dto, HttpStatus.OK);
    }

    @RequestMapping(value = "/getPlansByProject")
    public ResponseEntity<List<PlanDTO>> getByProject(@PathVariable("project_id") long projectId) {
        List<PlanDTO> plans = planService.readAll();
        return new ResponseEntity<List<PlanDTO>>(plans, HttpStatus.OK);
    }
}
