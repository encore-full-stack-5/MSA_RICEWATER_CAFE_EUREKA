package com.example.board.global.domain.repository;

import com.example.board.global.domain.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

    boolean existsByMemberId(Long memberId);
    boolean existsBySubGroupId(Long subGroupId);
    boolean existsByCafeId(Long cafeId);
    boolean existsByBoardTitle(String boardTitle);

    Page<Board> findByMemberId(Long memberId, Pageable pageRequest);
    Page<Board> findBySubGroupId(Long subGroupId, Pageable pageRequest);

    Page<Board> findByCafeId(Long cafeId, Pageable pageRequest);

    Page<Board> findByBoardTitle(String boardTitle, Pageable pageRequest);
}
