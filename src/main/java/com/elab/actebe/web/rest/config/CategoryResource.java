package com.elab.actebe.web.rest.config;

import com.elab.actebe.service.intf.config.CategoryService;
import com.elab.actebe.service.dto.config.CategoryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryResource {
    @Inject
    private CategoryService categoryService;

    @RequestMapping("/findAll")
    public ResponseEntity<List<CategoryDTO>> readAll() {
        List<CategoryDTO> cats = categoryService.findAll();
        return new ResponseEntity<List<CategoryDTO>>(cats, HttpStatus.OK);
    }

    @RequestMapping("/save")
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO cat = categoryService.save(categoryDTO);
        return new ResponseEntity<CategoryDTO>(cat, HttpStatus.OK);
    }
}
