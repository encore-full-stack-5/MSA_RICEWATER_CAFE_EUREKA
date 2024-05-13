package com.example.cafe.global.domain.repository;

import com.example.cafe.global.domain.entity.Cafe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe,Long> {
    Page<Cafe> findByManagerId(Long managerId, Pageable pageRequest);
    Page<Cafe> findAllByNameContainingOrderByCreatedAtDesc(String query, Pageable pageRequest);
}
