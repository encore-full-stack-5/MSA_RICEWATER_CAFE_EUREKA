package com.example.cafe.global.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER_LEVEL")
public class MemberLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RANK_ID")
    private Long id;

    @Column(name= "PRIORITY") @Setter
    private Integer priority;

    @Column(name = "NAME") @Setter
    private String name;

    @Column(name = "DESCRIPTION") @Setter
    private String description;

    @JoinColumn(name="CAFE_ID") @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Cafe cafe;
}

