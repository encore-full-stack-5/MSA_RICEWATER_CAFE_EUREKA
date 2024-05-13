package com.example.category.service;

import com.example.category.dto.request.SubCategoryRequest;
import com.example.category.dto.response.SubCategoryResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SubCategoryService {
    /*
     * @param categoryId
     * @return List<SubCategoryResponse>
     * @method GET
     *
     * 메인 카테고리의 서브 카테고리를 조회한다
     */
    List<SubCategoryResponse> getSubCategoryByCategoryId(Long categoryId, Pageable pageable);

    /*
     * @param id
     * @return SubCategoryResponse
     * @method GET
     *
     * 메인 카테고리의 서브 카테고리를 단일 조회한다
     */
    SubCategoryResponse getSubCategoryById(Long id);

    /*
     * @param subCategoryRequest
     * @return void
     * @method POST
     *
     * 메인 카테고리의 서브 카테고리를 추가한다
     */
    void createSubCategory(SubCategoryRequest subCategoryRequest);

    /*
     * @param categoryId, updateSubCategoryRequest
     * @return void
     * @method PUT
     *
     * 메인 카테고리의 서브 카테고리를 수정한다
     */
    void updateSubCategory(Long id, SubCategoryRequest subCategoryRequest);

    /*
     * @param id
     * @return void
     * @method PUT
     *
     * 메인 카테고리의 서브 카테고리를 삭제한다
     */
    void deleteSubCategory(Long id);
}