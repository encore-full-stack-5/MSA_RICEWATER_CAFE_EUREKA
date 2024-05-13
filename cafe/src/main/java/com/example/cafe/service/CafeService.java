package com.example.cafe.service;

import com.example.cafe.dto.request.CafeRequest;
import com.example.cafe.dto.response.CafeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CafeService {
    void createCafe(CafeRequest request);

    Page<CafeResponse> getAllCafeByManagerId(Long uid, Pageable pageRequest);
    Page<CafeResponse> getAllCafeByCafeName(String query, Pageable pageRequest);
    CafeResponse getCafeByCafeId(Long cafeId);
}
