package com.example.category.global.domain.repository;

import com.example.category.global.domain.entity.SubCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    // 서브 카테고리 조회
    List<SubCategory> findByIsDeleteFalseAndCategoryId(Long categoryId, Pageable pageable);

    // 서브 카테고리 단일 조회
    Optional<SubCategory> findByIsDeleteFalseAndId(Long id);

    // 카테고리 이름 조회
    Optional<SubCategory> findByName(String name);
}