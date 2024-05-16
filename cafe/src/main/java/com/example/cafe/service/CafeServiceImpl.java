package com.example.cafe.service;

import com.example.cafe.dto.request.CafeRequest;
import com.example.cafe.dto.response.CafeResponse;
import com.example.cafe.excrption.NotFoundCafeException;
import com.example.cafe.global.domain.entity.Cafe;
import com.example.cafe.global.domain.entity.EmailSender;
import com.example.cafe.global.domain.entity.UserDto;
import com.example.cafe.global.domain.repository.CafeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {
    private final CafeRepository cafeRepository;
    private final MemberLevelService memberLevelService;
    private final EmailSender emailSender;

//    카페 생성
    @Transactional
    @Override
    public void createCafe(CafeRequest request) {
        // 카페 생성
        Cafe cafeEntity = request.toEntity();
        Cafe savedCafe = cafeRepository.save(cafeEntity);
        // 카페 생성 후 default MemberLevel 테이블 생성
        memberLevelService.createDefaultMemberLevel(savedCafe);
        UserDto principal = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = principal.getEmail();
        String name = principal.getNickname();
        try{
            emailSender.emailSender(name,email, request.name());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }



    //    managerId로 모든 카페리스트 가져오기 ( 내가 Manager인 카페 보기)
    @Transactional
    @Override
    public Page<CafeResponse> getAllCafeByManagerId(Long managerId, Pageable pageRequest) {
        Page<Cafe> allCafes = cafeRepository.findByManagerId(managerId,pageRequest);
        return allCafes.map(CafeResponse::from);
    }
//    Cafe 이름으로 검색 (포함되어 있는 Cafe 가져오기)
    @Override
    public Page<CafeResponse> getAllCafeByCafeName(String query,Pageable pageRequest) {
        Page<Cafe> allCafes = cafeRepository.findAllByNameContainingOrderByCreatedAtDesc(query, pageRequest);
        return allCafes.map(CafeResponse::from);
    }

//    cafeId로 cafe 하나 가져오기
    @Transactional
    @Override
    public CafeResponse getCafeByCafeId(Long cafeId) {
        Optional<Cafe> byCafeId = cafeRepository.findById(cafeId);
        Cafe cafe = byCafeId.orElseThrow(NotFoundCafeException::new);
        return CafeResponse.from(cafe);
    }
}
