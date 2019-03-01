package com.elab.actebe.service.impl.config;

import com.elab.actebe.domaine.config.Category;
import com.elab.actebe.repository.config.CategoryRepository;
import com.elab.actebe.service.intf.config.CategoryService;
import com.elab.actebe.service.dto.config.CategoryDTO;
import com.elab.actebe.service.mapper.config.CategoryMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private CategoryMapper categoryMapper;

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category;
        category = categoryMapper.CategoryDTOtoCategory(categoryDTO);
        category = categoryRepository.save(category);
        return categoryMapper.CategoryToCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> findAll() {
        List<CategoryDTO> categoryDTOList = categoryMapper.CategorysToCategoryDTOs(categoryRepository.findAllByDeleted(false));
        return categoryDTOList;
    }

    @Override
    public CategoryDTO findOne(long id) {
        Category category = categoryRepository.getOne(id);
        return categoryMapper.CategoryToCategoryDTO(category);
    }
}
