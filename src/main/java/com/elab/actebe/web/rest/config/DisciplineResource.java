package com.elab.actebe.web.rest.config;

import com.elab.actebe.service.dto.config.CategoryDTO;
import com.elab.actebe.service.dto.config.DisciplineDTO;
import com.elab.actebe.service.intf.config.DisciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController

@RequestMapping("api/discipline")
public class DisciplineResource {
    @Inject
    private DisciplineService disciplineService;


    @RequestMapping("/findAll")
    public ResponseEntity<List<DisciplineDTO>> readAll() {
        List<DisciplineDTO> discs = disciplineService.findAll();
        return new ResponseEntity<List<DisciplineDTO>>(discs, HttpStatus.OK);
    }

    @RequestMapping("/save")
    public ResponseEntity<DisciplineDTO> saveCategory(@RequestBody DisciplineDTO disciplineDTO) {
        DisciplineDTO disc = disciplineService.save(disciplineDTO);
        return new ResponseEntity<DisciplineDTO>(disc, HttpStatus.OK);
    }
}
