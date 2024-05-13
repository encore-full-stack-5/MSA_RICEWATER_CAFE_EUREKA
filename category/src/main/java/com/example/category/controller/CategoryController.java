package com.example.category.controller;

import com.example.category.dto.request.CategoryRequest;
import com.example.category.dto.response.CategoryResponse;
import com.example.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // 카페의 카테고리를 조회한다
    @GetMapping("/cafe/{cafeId}")
    List<CategoryResponse> getCategoryByCafeId(
            @PathVariable("cafeId") Long cafeId,
            @PageableDefault(
                    page = 0,
                    size = 3,
                    sort = "id",
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ) {
        return categoryService.getCategoryByCafeId(cafeId, pageable);
    }

    // 카페의 카테고리를 단일 조회한다
    @GetMapping("/{id}")
    CategoryResponse getCategoryById(
            @PathVariable("id") Long id
    ) {
        return categoryService.getCategoryById(id);
    }

    // 카페의 카테고리를 추가한다
    @PostMapping
    public void createCategory(
            @RequestBody CategoryRequest categoryRequest
    ) {
        categoryService.createCategory(categoryRequest);
    }

    // 카페의 카테고리를 수정한다
    @PutMapping("/{id}")
    public void updateCategory(
            @PathVariable("id") Long id,
            @RequestBody CategoryRequest categoryRequest
    ) {
        categoryService.updateCategory(id, categoryRequest);
    }

    // 카페의 카테고리를 삭제한다
    @PutMapping("/delete/{id}")
    public void deleteCategory(
            @PathVariable("id") Long id
    ) {
        categoryService.deleteCategory(id);
    }
}