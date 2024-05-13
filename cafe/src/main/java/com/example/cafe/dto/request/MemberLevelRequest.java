package com.example.cafe.dto.request;


import com.example.cafe.global.domain.entity.Cafe;
import com.example.cafe.global.domain.entity.MemberLevel;
import com.example.cafe.global.domain.entity.RankType;

import java.time.LocalDateTime;

public record MemberLevelRequest(Integer priority, String name, String description) {

}
