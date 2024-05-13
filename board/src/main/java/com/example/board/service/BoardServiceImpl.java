package com.example.board.service;

import com.example.board.dto.request.InsertBoardRequestDto;
import com.example.board.dto.request.UpdateBoardRequestDto;
import com.example.board.dto.response.BoardOneResponseDto;
import com.example.board.exception.*;
import com.example.board.global.domain.entity.Board;
import com.example.board.global.domain.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    public void save(InsertBoardRequestDto req) {
        boardRepository.save(req.toEntity());
    }


    public Page<BoardOneResponseDto> getAllBoards(Pageable pageRequest) {
        Page<Board> all = boardRepository.findAll(pageRequest);
        return all.map(BoardOneResponseDto::from);
    }

    public Page<BoardOneResponseDto> getBoardsByMemberId(Long memberId, Pageable pageRequest) {
        if(!boardRepository.existsByMemberId(memberId)) throw new UserNotFoundException();
        Page<Board> all = boardRepository.findByMemberId(memberId, pageRequest);
        return all.map(BoardOneResponseDto::from);
    }

    public Page<BoardOneResponseDto> getBoardsBySubGroupId(Long subGroupId, Pageable pageRequest) {
        if(!boardRepository.existsBySubGroupId(subGroupId)) throw new SubGroupNotFoundException();
        Page<Board> all = boardRepository.findBySubGroupId(subGroupId, pageRequest);
        return all.map(BoardOneResponseDto::from);

    }

    public Page<BoardOneResponseDto> getBoardsByCafeId(Long cafeId, Pageable pageRequest) {
        if(!boardRepository.existsByCafeId(cafeId)) throw new CafeNotFoundException();
        Page<Board> all =  boardRepository.findByCafeId(cafeId, pageRequest);
        return all.map(BoardOneResponseDto::from);
    }

    public Page<BoardOneResponseDto> getBoardsByBoardTitle(String boardTitle, Pageable pageRequest) {
        if(!boardRepository.existsByBoardTitle(boardTitle)) throw new BoardTitleNotFoundException();
        Page<Board> all =  boardRepository.findByBoardTitle(boardTitle, pageRequest);
        return all.map(BoardOneResponseDto::from);
    }

    public void updateBoard(Long id, UpdateBoardRequestDto req) {
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isEmpty()) throw new BoardNotFoundException();
        Board board = byId.get();
        board.setBoardTitle(req.boardTitle());
        board.setBoardContent(req.boardContent());
        boardRepository.save(board);
    }


    public void deleteBoard(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isEmpty()) throw new BoardNotFoundException();
        boardRepository.deleteById(id);
    }

    public BoardOneResponseDto getBoardById(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        if(byId.isEmpty()) throw new BoardNotFoundException();
        Board board = byId.get();
        board.setBoardViews(board.getBoardViews()+1);
        boardRepository.save(board);
        return BoardOneResponseDto.from(board);
    }
}
