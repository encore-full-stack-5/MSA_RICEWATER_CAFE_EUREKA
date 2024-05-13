package com.example.category.service;

import com.example.category.dto.request.SubCategoryRequest;
import com.example.category.dto.response.SubCategoryResponse;
import com.example.category.exception.AlreadyDeletedException;
import com.example.category.exception.ExistNameException;
import com.example.category.exception.SubCategoryIdNotFoundException;
import com.example.category.global.domain.entity.SubCategory;
import com.example.category.global.domain.repository.SubCategoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    // 메인 카테고리별 서브 카테고리 조회
    @Override
    public List<SubCategoryResponse> getSubCategoryByCategoryId(Long categoryId, Pageable pageable) {
        List<SubCategory> all = subCategoryRepository.findByIsDeleteFalseAndCategoryId(categoryId, pageable);
        return all.stream().map(SubCategoryResponse::from).toList();
    }

    // 서브 카테고리 단일 조회
    @Override
    public SubCategoryResponse getSubCategoryById(Long id) {
        Optional<SubCategory> byId = subCategoryRepository.findByIsDeleteFalseAndId(id);
        SubCategory subCategory = byId.orElseThrow(() -> new SubCategoryIdNotFoundException(id));
        return SubCategoryResponse.from(subCategory);
    }

    // 서브 카테고리 추가
    @Transactional
    @Override
    public void createSubCategory(
            SubCategoryRequest request
    ) {
        Optional<SubCategory> byName = subCategoryRepository.findByName(request.name());
        if(byName.isPresent()) throw new ExistNameException(request.name());

        subCategoryRepository.save(request.toEntity());
    }

    // 서브 카테고리 수정
    @Transactional
    @Override
    public void updateSubCategory(Long id, SubCategoryRequest request) {
        Optional<SubCategory> byId = subCategoryRepository.findById(id);
        SubCategory subCategory = byId.orElseThrow(() -> new SubCategoryIdNotFoundException(id));
        Optional<SubCategory> byName = subCategoryRepository.findByName(request.name());
        if(byName.isPresent()) throw new ExistNameException(request.name());

        subCategory.setName(request.name());
    }

    // 서브 카테고리 삭제
    @Transactional
    @Override
    public void deleteSubCategory(Long id) {
        Optional<SubCategory> byId = subCategoryRepository.findByIsDeleteFalseAndId(id);
        SubCategory subCategory = byId.orElseThrow(() -> new AlreadyDeletedException(id));

        subCategory.setIsDelete(true);
    }
}