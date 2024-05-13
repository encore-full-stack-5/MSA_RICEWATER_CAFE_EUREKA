package com.example.category.service;

import com.example.category.dto.request.CategoryRequest;
import com.example.category.dto.response.CategoryResponse;
import com.example.category.exception.AlreadyDeletedException;
import com.example.category.exception.CategoryIdNotFoundException;
import com.example.category.exception.ExistNameException;
import com.example.category.global.domain.entity.Category;
import com.example.category.global.domain.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    // 카페별 카테고리 조회
    @Override
    public List<CategoryResponse> getCategoryByCafeId(Long cafeId, Pageable pageable) {
        List<Category> all = categoryRepository.findByIsDeleteFalseAndCafeId(cafeId, pageable);
        return all.stream().map(CategoryResponse::from).toList();
    }

    // 카테고리 단일 조회
    @Override
    public CategoryResponse getCategoryById(Long id) {
        Optional<Category> byId = categoryRepository.findByIsDeleteFalseAndId(id);
        Category category = byId.orElseThrow(() -> new CategoryIdNotFoundException(id));
        return CategoryResponse.from(category);
    }

    // 카테고리 추가
    @Transactional
    @Override
    public void createCategory(
            CategoryRequest request
    ) {
        Optional<Category> byName = categoryRepository.findByName(request.name());
        if(byName.isPresent()) throw new ExistNameException(request.name());

        categoryRepository.save(request.toEntity());
    }

    // 카테고리 수정
    @Transactional
    @Override
    public void updateCategory(Long id, CategoryRequest request) {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.orElseThrow(() -> new CategoryIdNotFoundException(id));
        Optional<Category> byName = categoryRepository.findByName(request.name());
        if(byName.isPresent()) throw new ExistNameException(request.name());

        category.setName(request.name());
    }

    // 카테고리 삭제
    @Transactional
    @Override
    public void deleteCategory(Long id) {
        Optional<Category> byId = categoryRepository.findByIsDeleteFalseAndId(id);
        Category category = byId.orElseThrow(() -> new AlreadyDeletedException(id));

        category.setIsDelete(true);
    }
}