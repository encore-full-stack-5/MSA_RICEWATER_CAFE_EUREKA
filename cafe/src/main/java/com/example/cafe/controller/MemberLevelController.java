package com.example.cafe.controller;

import com.example.cafe.dto.request.MemberLevelsRequest;
import com.example.cafe.service.MemberLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/memberlevel")
@RequiredArgsConstructor
public class MemberLevelController {
    private final MemberLevelService memberLevelService;
    // Member Level update기능
    @PutMapping
    public void updateMemberLevel(@RequestParam(name = "cafeId") Long cafeId, @RequestBody MemberLevelsRequest memberLevels){
        memberLevelService.updateMemberLevels(cafeId, memberLevels);
    }
}
