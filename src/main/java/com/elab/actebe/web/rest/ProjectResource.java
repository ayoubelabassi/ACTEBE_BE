package com.elab.actebe.web.rest;

import com.elab.actebe.service.intf.utils.ExportService;
import com.elab.actebe.service.intf.project.ProjectService;
import com.elab.actebe.service.dto.project.ProjectDTO;
import com.elab.actebe.util.ReportUtils;
import com.elab.actebe.util.Utils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
public class ProjectResource {

    @Inject
    private ProjectService projectService;

    @Inject
    private ExportService exportService;


    @RequestMapping(value = "/getAllProjects")
    public ResponseEntity<List<ProjectDTO>> getAllProjects(){
        List<ProjectDTO> dtos=projectService.readAll();
        return new ResponseEntity<List<ProjectDTO>>(dtos,HttpStatus.OK);
    }
    @RequestMapping(value = "/print/{id}")
    public ResponseEntity<byte[]> generateReport(@PathVariable("id") long id_project){
        Map<String, Object> mapper = new HashMap<String, Object>();
        byte[] content =  exportService.export(mapper, ReportUtils.testReport, ReportUtils.FileFormat.PDF.toString());
        HttpHeaders httpHeaders=Utils.getPDFHeaders("Situation_test.pdf");
        return new ResponseEntity<byte[]>(content, httpHeaders, HttpStatus.OK);
    }

}
