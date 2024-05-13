package com.example.board.service;

import com.example.board.dto.request.InsertBoardRequestDto;
import com.example.board.dto.request.UpdateBoardRequestDto;
import com.example.board.dto.response.BoardOneResponseDto;
import com.example.board.global.domain.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    public void save(InsertBoardRequestDto req);

    public Page<BoardOneResponseDto> getAllBoards(Pageable pageRequest);

    public Page<BoardOneResponseDto> getBoardsByMemberId(Long memberId, Pageable pageRequest);


    public Page<BoardOneResponseDto> getBoardsBySubGroupId(Long subGroupId, Pageable pageRequest);

    public Page<BoardOneResponseDto> getBoardsByCafeId(Long cafeId, Pageable pageRequest);

    public Page<BoardOneResponseDto> getBoardsByBoardTitle(String boardTitle, Pageable pageRequest);

    public void updateBoard(Long id, UpdateBoardRequestDto req);


    public void deleteBoard(Long id);

    public BoardOneResponseDto getBoardById(Long id);
}
