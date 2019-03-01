package com.elab.actebe.service.mapper.config;

import com.elab.actebe.domaine.config.Category;
import com.elab.actebe.service.dto.config.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(source = "createdBy.name", target = "createdBy")
    @Mapping(source = "updatedBy.name", target = "updatedBy")
    CategoryDTO CategoryToCategoryDTO(Category Category);

    List<CategoryDTO> CategorysToCategoryDTOs(List<Category> Categorys);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "projects", ignore = true)
    Category CategoryDTOtoCategory(CategoryDTO CategoryDTO);

    List<Category> CategoryDTOsToCategorys(List<CategoryDTO> Categorys);
}
