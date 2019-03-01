package com.elab.actebe.service.intf.config;

import com.elab.actebe.service.dto.config.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    CategoryDTO save(CategoryDTO categoryDTO);

    List<CategoryDTO> findAll();

    CategoryDTO findOne(long id);
}
