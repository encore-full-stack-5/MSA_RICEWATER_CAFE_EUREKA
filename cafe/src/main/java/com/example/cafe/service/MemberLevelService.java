package com.example.cafe.service;

import com.example.cafe.dto.request.MemberLevelsRequest;
import com.example.cafe.global.domain.entity.Cafe;

public interface MemberLevelService {
    void createDefaultMemberLevel(Cafe cafe);

    void updateMemberLevels(Long cafeId, MemberLevelsRequest memberLevels);
}
