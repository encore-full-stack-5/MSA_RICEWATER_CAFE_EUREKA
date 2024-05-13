package com.example.cafe.service;

import com.example.cafe.dto.request.MemberLevelRequest;
import com.example.cafe.dto.request.MemberLevelsRequest;
import com.example.cafe.excrption.*;
import com.example.cafe.global.domain.entity.Cafe;
import com.example.cafe.global.domain.entity.MemberLevel;
import com.example.cafe.global.domain.repository.CafeRepository;
import com.example.cafe.global.domain.repository.MemberLevelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberLevelServiceImpl implements MemberLevelService {
    private final MemberLevelRepository memberLevelRepository;
    private final CafeRepository cafeRepository;

    @Transactional
    @Override
    public void createDefaultMemberLevel(Cafe cafe) {
        List<MemberLevel> defaultMemberLevel = new ArrayList<>();

        String[] levelNames = {"새싹멤버", "일반멤버", "성실멤버", "열심멤버", "우수멤버", "감사멤버"};
        String[] levelDescriptions = {
                "가입 후 막 활동을 시작하는 멤버",
                "카페 일반 멤버",
                "카페활동을 성실히 하는 멤버",
                "카페 열심 멤버",
                "카페 우수 멤버",
                "최고 고마운 VIP 멤버"
        };

        for (int i = 0; i < levelNames.length; i++) {
            MemberLevel memberLevel = new MemberLevel();
            memberLevel.setPriority(i + 1);
            memberLevel.setName(levelNames[i]);
            memberLevel.setDescription(levelDescriptions[i]);
            memberLevel.setCafe(cafe);
            defaultMemberLevel.add(memberLevel);
        }
        memberLevelRepository.saveAll(defaultMemberLevel);
    }

    @Override
    public void updateMemberLevels(Long cafeId, MemberLevelsRequest memberLevels) {
        // 멤버 등급 update를 하면 멤버 등급 YN을 Y로 업데이트 후 실행
        // 이렇게 cafeRepository로 직접 접근하는게 맞는 방식인지?

        Cafe cafe = cafeRepository.findById(cafeId).orElseThrow(NotFoundLevelException::new);
        cafe.setRankUseYn(true);
        cafeRepository.save(cafe);

        memberLevels.levels().forEach(levelRequest -> {
            Optional<MemberLevel> optionalMemberLevel = Optional.of(memberLevelRepository.findByPriorityAndCafe_Id(levelRequest.priority(), cafeId));
            MemberLevel memberLevel = optionalMemberLevel.orElseThrow(NotFoundLevelException::new);
            memberLevel.setName(levelRequest.name());
            memberLevel.setDescription(levelRequest.description());
            memberLevelRepository.save(memberLevel);
        });
    }
}
