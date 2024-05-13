package com.example.board.controller;

import com.example.board.dto.request.InsertBoardRequestDto;
import com.example.board.dto.request.UpdateBoardRequestDto;
import com.example.board.dto.response.BoardOneResponseDto;
import com.example.board.global.domain.entity.Board;
import com.example.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImpl boardService;

    @PostMapping
    public void insertBoard(
            @RequestBody InsertBoardRequestDto req
    ){
        boardService.save(req);
    }

    @GetMapping
    public Page<BoardOneResponseDto> getAllBoards(@RequestParam(name = "memberId", required = false, defaultValue = "-1") Long memberId,
                                    @RequestParam(name = "subGroupId",required = false, defaultValue = "-1") Long subGroupId,
                                    @RequestParam(name = "cafeId",required = false, defaultValue = "-1") Long cafeId,
                                    @RequestParam(name = "boardTitle",required = false, defaultValue = "" ) String boardTitle,
                                    @RequestParam(name = "pageNo", required = false, defaultValue = "0") Integer pageNo,
                                    @PageableDefault(
                                            sort = "id",
                                            direction = Sort.Direction.DESC,
                                            size = 3
                                    ) Pageable pageable
                                    ){
        Pageable pageRequest = PageRequest.of(pageNo, pageable.getPageSize(), pageable.getSort());
        if(memberId != -1) return boardService.getBoardsByMemberId(memberId, pageRequest);
        else if(subGroupId != -1) return boardService.getBoardsBySubGroupId(subGroupId, pageRequest);
        else if(cafeId != -1) return boardService.getBoardsByCafeId(cafeId, pageRequest);
        else if(boardTitle != null && !boardTitle.isEmpty()) return boardService.getBoardsByBoardTitle(boardTitle, pageRequest);
        else return boardService.getAllBoards(pageRequest);
    }

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable("id") Long id, @RequestBody UpdateBoardRequestDto req
    ){
        boardService.updateBoard(id, req);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
    }

    @GetMapping("/{id}")
    public BoardOneResponseDto getBoardById(@PathVariable("id") Long id) {
        return boardService.getBoardById(id);
    }



}

