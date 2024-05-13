package com.example.category.controller;

import com.example.category.dto.request.SubCategoryRequest;
import com.example.category.dto.response.SubCategoryResponse;
import com.example.category.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subCategories")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    // 카페의 카테고리를 조회한다
    @GetMapping("/{categoryId}")
    List<SubCategoryResponse> getSubCategoryByCategoryId(
            @PathVariable("categoryId") Long categoryId,
            @PageableDefault(
                    page = 0,
                    size = 3,
                    sort = "id",
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        return subCategoryService.getSubCategoryByCategoryId(categoryId, pageable);
    }

    // 카페의 카테고리를 단일 조회한다
    @GetMapping("/category/{id}")
    SubCategoryResponse getSubCategoryById(
            @PathVariable("id") Long id
    ) {
        return subCategoryService.getSubCategoryById(id);
    }

    // 카페의 카테고리를 추가한다
    @PostMapping
    public void createSubCategory(
            @RequestBody SubCategoryRequest subCategoryRequest
    ) {
        subCategoryService.createSubCategory(subCategoryRequest);
    }

    // 카페의 카테고리를 수정한다
    @PutMapping("/{id}")
    public void updateSubCategory(
            @PathVariable("id") Long id,
            @RequestBody SubCategoryRequest subCategoryRequest
    ) {
        subCategoryService.updateSubCategory(id, subCategoryRequest);
    }

    // 카페의 카테고리를 삭제한다
    @PutMapping("/delete/{id}")
    public void deleteSubCategory(
            @PathVariable("id") Long id
    ) {
        subCategoryService.deleteSubCategory(id);
    }
}