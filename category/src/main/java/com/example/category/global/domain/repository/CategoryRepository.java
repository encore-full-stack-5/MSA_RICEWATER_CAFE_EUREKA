package com.example.category.global.domain.repository;

import com.example.category.global.domain.entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 카테고리 조회
    List<Category> findByIsDeleteFalseAndCafeId(Long cafeId, Pageable pageable);

    // 카테고리 단일 조회
    Optional<Category> findByIsDeleteFalseAndId(Long id);

    // 카테고리 이름 조회
    Optional<Category> findByName(String name);
}