package com.example.category.service;

import com.example.category.dto.request.CategoryRequest;
import com.example.category.dto.response.CategoryResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    /*
     * @param cafeId
     * @return List<CategoryResponse>
     * @method GET
     *
     * 카페의 카테고리를 조회한다
     */
    List<CategoryResponse> getCategoryByCafeId(Long cafeId, Pageable pageable);

    /*
     * @param id
     * @return CategoryResponse
     * @method GET
     *
     * 카페의 카테고리를 단일 조회한다
     */
    CategoryResponse getCategoryById(Long id);

    /*
     * @param categoryRequest
     * @return void
     * @method POST
     *
     * 카페의 카테고리를 추가한다
     */
    void createCategory(CategoryRequest categoryRequest);

    /*
     * @param id, updateCategoryRequest
     * @return void
     * @method PUT
     *
     * 카페의 카테고리를 수정한다
     */
    void updateCategory(Long id, CategoryRequest categoryRequest);

    /*
     * @param id
     * @return void
     * @method PUT
     *
     * 카페의 카테고리를 삭제한다
     */
    void deleteCategory(Long id);
}
