package com.friendsofgroot.mapllistener.services;

import com.friendsofgroot.mapllistener.dto.CategoryDto;
import com.friendsofgroot.mapllistener.exception.ResourceNotFoundException;
import com.friendsofgroot.mapllistener.mappers.CategoryMapper;
import com.friendsofgroot.mapllistener.models.Category;
import com.friendsofgroot.mapllistener.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category cat3 = categoryMapper.toEntity(categoryDto);
        categoryRepository.save(cat3);

        CategoryDto catNewDto = categoryMapper.toDto(cat3);
        return catNewDto;
    }

    @Override
    public CategoryDto getCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Long.toString(categoryId)));

        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
//        List<CategoryDto> categoriesDto = categories.stream().map(category -> categoryMapper.toDto(category))
//                .collect(Collectors.toList());
        List<CategoryDto> catDto = categories.stream().map(categoryMapper::toDto)
                .collect(Collectors.toList());
        return catDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto ) {

        Category category = categoryMapper.toEntity(categoryDto);
        Category categoryUpdate = categoryRepository.findById(category.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Long.toString(category.getId())));

        categoryUpdate.setName(categoryDto.getName());
        categoryUpdate.setDescription(categoryDto.getDescription());
        categoryUpdate.setUrls(categoryDto.getUrls());

        Category categoryDone = categoryRepository.save(categoryUpdate);

        return categoryMapper.toDto(categoryDone);
    }

    @Override
    public boolean deleteCategory(Long categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
