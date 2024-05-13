package com.example.cafe.global.domain.repository;

import com.example.cafe.global.domain.entity.MemberLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLevelRepository extends JpaRepository<MemberLevel,Long> {
    MemberLevel findByPriorityAndCafe_Id(Integer priority, Long cafe_id);
}
