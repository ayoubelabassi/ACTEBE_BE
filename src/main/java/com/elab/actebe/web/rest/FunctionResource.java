package com.elab.actebe.web.rest;

import com.elab.actebe.service.intf.config.FunctionService;
import com.elab.actebe.service.dto.config.FunctionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("api/function")
public class FunctionResource {

    @Inject
    private FunctionService functionService;

    @RequestMapping("/saveFunction")
    public ResponseEntity<FunctionDTO> save(@RequestBody FunctionDTO functionDTO) {
        FunctionDTO dto = functionService.save(functionDTO);
        return new ResponseEntity<FunctionDTO>(dto, HttpStatus.OK);
    }

    @RequestMapping("/findAll")
    public ResponseEntity<List<FunctionDTO>> findAll() {
        List<FunctionDTO> dtos = functionService.findAll();
        return new ResponseEntity<List<FunctionDTO>>(dtos, HttpStatus.OK);
    }

}
